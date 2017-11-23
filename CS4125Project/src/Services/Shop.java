package Services;

//import Business.Account;
import Database.DBControler;
import Observers.*;
import Stock.StockItem;
import Storage.Warehouse;
import User.Customer;
import Services.Purchase;
import Services.PurchaseConstraints.PurchaseType;
import Storage.Location;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Observable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import javafx.util.Pair;

/**
 *
 * @author Matthew Murphy
 */

public class Shop extends Observable{
    public enum SortOrder {
        NAME_DESC(true, false),
        NAME_ASC(false, false),
        QUANTITY_DESC(true, true),
        QUANTITY_ASC(false, true);
        
        private boolean descending;
        private boolean byQuantity;
        
        SortOrder(boolean descending, boolean byQuantity)
        {
            this.descending = descending;
            this.byQuantity = byQuantity;
        }
        
        public boolean getDescending() { return descending; }
        public boolean getByQuantity() { return byQuantity; }
    }
    
    private static Shop instance;
    private StockItem item;
    private int quantity;
    private Customer account;
    
    private Shop() {
        //warehouses = new ArrayList<Warehouse>();
        //warehouses.addAll(DBControler.getInstance().getWarehouseDB().getWarehouses());
        addObserver(new WarehouseStockObserver());
        addObserver(new StockItemObserver());
        addObserver(new PurchaseObserver());
    }
    
    public static Shop getInstance(){
        if(instance == null)
            instance = new Shop();
        return instance;
    }
    
    public void setAccount(Customer account){
        this.account = account;
    }
    
    public List<Entry<String, Integer>> getSortedStock(SortOrder order)
    {
        Map<String, Integer> allStock = checkStock();
        
        List<Entry<String, Integer>> result = new ArrayList();
        result.addAll(allStock.entrySet());
        
        // Use lambda expression to sort items
        result.sort((e1, e2) -> {
            int comp;
            // Check whether to sort by name or quantity
            if (order.byQuantity)
                comp = e1.getKey().compareTo(e2.getKey());
            else
                comp = e1.getValue().compareTo(e2.getValue());
            // Return the result, or the opposite (* -1) if in ascending order
            return comp * (order.getDescending() ? 1 : -1);
        });
        
        return result;
    }
    
    public Map<String, Integer> checkStock(){
        Map<String, Integer> tempStock;
        Map<String, Integer> totalStock = new HashMap<String, Integer>();
        
        for(int i = 0; i < DBControler.getWarehouses().size(); i++){
            tempStock = DBControler.getWarehouses().get(i).checkStock();
            // Loop through and check if item exists on totalStock.
            totalStock.putAll(tempStock);
        }
        return totalStock;
    }
    
    public void returnItem(StockItem item){
        boolean done = false;
        for(int i = 0; i < DBControler.getWarehouses().size() && !done; i++){
            if(DBControler.getWarehouses().get(i).hasItem(item.getName())){
                DBControler.getWarehouses().get(i).addStock(item.getName(), 1);
                done = true;
                
                Purchase pur = new Purchase(item, -1);
                DBControler.getInstance().getPurchaseDB().getPurchases().add(pur);
            }
        }
        setChanged();
        notifyObservers();
    }
    
    public void makePurchase(StockItem item, int quantity){
        Purchase pur = new Purchase(item, quantity);
        boolean purchaseHappened = false;
        purchaseHappened = pur.makePurchase(account.getLocation());
        if(purchaseHappened){
            boolean done = false;
            for(int i = 0; i < DBControler.getWarehouses().size() && !done; i++){
                if(DBControler.getWarehouses().get(i).hasItem(item.getName())){
                    DBControler.getWarehouses().get(i).buyStock(item.getName(), quantity);
                    
                    // Shane: add purchase to purchase database
                    DBControler.getInstance().getPurchaseDB().getPurchases().add(pur);
                    done = true;
                }
            }
//            updateAllObservers();
            setChanged();
            notifyObservers();
        }
    }
    
    /**
     * Get the list of sales or returns which fall within the given date range
     * @param start The date from which to start looking
     * @param end The date where you look until
     * @param getSales If true, return sales. If false, return returns
     * @return The list of sales or returns which fall within the range
     */
//    public List<Purchase> getPurchases(GregorianCalendar start, GregorianCalendar end, boolean getSales)
    public List<Purchase> getPurchases(PurchaseConstraints constraints)
    {
        GregorianCalendar start = constraints.getStart();
        GregorianCalendar end = constraints.getEnd();
        boolean getSales = constraints.getType() == PurchaseType.SALES;
        String itemName = constraints.getProduct();
        String category = constraints.getCategory();
        
        ArrayList<Purchase> purchases = new ArrayList();
        purchases.addAll(DBControler.getInstance().getPurchaseDB().getPurchases());
        
        /* Remove entries from purchases which fall outside the date range*/
        for (int i = 0; i < purchases.size(); )
        {
            GregorianCalendar date = purchases.get(i).getDate();
            
            // Check to see if the purchase matches the type that we are looking for
            boolean matchType = purchases.get(i).getQuantity() > 0 == getSales;
            
            int cmpStart = start.get(Calendar.YEAR) * 12 + start.get(Calendar.MONTH);
            int cmpEnd = end.get(Calendar.YEAR) * 12 + end.get(Calendar.MONTH);
            int cmpDate = date.get(Calendar.YEAR) * 12 + date.get(Calendar.MONTH);
            
            boolean inRange = cmpDate >= cmpStart && cmpDate <= cmpEnd;
            
            boolean isName = (itemName == null 
                    || itemName.equals(purchases.get(i).getItem().getName()));
            
            boolean isCategory = (category == null)
                    || category.equals(purchases.get(i).getItem().getCategory());
            
            System.out.println(purchases.get(i).getItem().getName() + ", range = (" + start.get(Calendar.YEAR) + ", " + end.get(Calendar.YEAR) + ") " + cmpDate);
            
            // Remove entries if needed
            if (matchType && inRange && isName && isCategory)
                i++;
            else
                purchases.remove(i);
        }
        
        return purchases;
    }
    
    public void addDiscount(){
        setChanged();
        notifyObservers();
    }
    
    public void addWarehouse(Warehouse w){
        //Broken NullPointerException
        DBControler.getWarehouses().add(w);
        setChanged();
        notifyObservers();
    }
}
