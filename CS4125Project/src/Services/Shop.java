package Services;

import Database.DBControler;
import Observers.*;
import Stock.StockItem;
import Storage.Warehouse;
import User.Customer;
import Services.PurchaseConstraints.PurchaseType;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Observable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * An object that allows user to check stock, buy and return items.
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
        
    /**
     * Sets a descending boolean, and byQuantity boolean
     * @param descending A boolean which determines if the order is ascending or descending
     * @param byQuantity A boolean which determines if the order is based of quantity
     */
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
    
    /**
     * Creates observers for warehouse, stockItem, Purchase
     */
    private Shop() {
        addObserver(new WarehouseStockObserver());
        addObserver(new StockItemObserver());
        addObserver(new PurchaseObserver());
    }
    /**
     * 
     * @return instance
     */
    public static Shop getInstance(){
        if(instance == null)
            instance = new Shop();
        return instance;
    }
    /**
     * 
     * @param account Sets the shop account to the current user
     */
    public void setAccount(Customer account){
        this.account = account;
    }
    /**
     * 
     * @param order passes the sorted stock
     * @return result
     */
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
    
    /**
     * 
     * @return totalStock
     */
    
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
    
    /**
     * 
     * @param item Item to be returned.
     * @param quantity The amount of the item to be returned.
     */
    public void returnItem(StockItem item, int quantity){
        boolean done = false;
        for(int i = 0; i < DBControler.getWarehouses().size() && !done; i++){
            if(DBControler.getWarehouses().get(i).hasItem(item.getName())){
                DBControler.getWarehouses().get(i).addStock(item.getName(), 1);
                done = true;
                
                Purchase pur = new Purchase(item, (-1)*quantity,this.getAccount().getUsername());
                DBControler.getInstance().getPurchaseDB().getPurchases().add(pur);
            }
        }
        setChanged();
        notifyObservers();
    }
    
    /**
     * 
     * @param item Item to be bought.
     * @param quantity amount of item to be bought.
     * @param username User making purchase.
     */
    public void makePurchase(StockItem item, int quantity, String username){
        Purchase pur = new Purchase(item, quantity, username);
        //Precondition - you can not purchace a negative.
        if(quantity > 0){
            boolean purchaseHappened = false;
            purchaseHappened = pur.makePurchase(account.getLocation(), account.getPaymentType());
            if(purchaseHappened){
                boolean done = false;
                for(int i = 0; i < DBControler.getWarehouses().size() && !done; i++){
                    if(DBControler.getWarehouses().get(i).hasItem(item.getName())){
                        DBControler.getWarehouses().get(i).buyStock(item.getName(), quantity);

                        DBControler.getInstance().getPurchaseDB().getPurchases().add(pur);
                        done = true;
                    }
                }
                setChanged();
                notifyObservers();
            }
        }
        //Postcondition - the purchace must of been from the user logged in.
        assert pur.getUsername().equals(account.getUsername());
    }
    
    /**
     * Get the list of sales or returns which fall within the given date range
     * @param constraints 
     * @return purchases The list of sales or returns which fall within the range
     */
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
            
            
            // Remove entries if needed
            if (matchType && inRange && isName && isCategory)
                i++;
            else
                purchases.remove(i);
        }
        
        return purchases;
    }
    
    /**
     * Updates database when discount is made.
     */
    public void addDiscount(){
        setChanged();
        notifyObservers();
    }
    
    /**
     * 
     * @param w A warehouse to be added to the warehouseDB
     */
    public void addWarehouse(Warehouse w){
        DBControler.getWarehouses().add(w);
        setChanged();
        notifyObservers();
    }
    
    /**
     * 
     * @return account
     */
    public Customer getAccount(){
        return account;
    }
}
