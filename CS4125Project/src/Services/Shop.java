package Services;

//import Business.Account;
import Database.DBControler;
import Observers.StockItemObserver;
import Observers.WarehouseStockObserver;
import Stock.StockItem;
import Storage.Warehouse;
import User.Customer;
import Services.Purchase;
import Storage.Location;
import java.util.ArrayList;
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
    
    private Shop(){
        this.account = account;
        //warehouses = new ArrayList<Warehouse>();
        //warehouses.addAll(DBControler.getInstance().getWarehouseDB().getWarehouses());
        addObserver(new WarehouseStockObserver(this));
        addObserver(new StockItemObserver(this));
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
            }
        }
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
                    done = true;
                }
            }
            notifyObservers();
        }
    }
    
    public void addDiscount(){
        notifyObservers();
    }
    
    public void addWarehouse(Warehouse w){
        //Broken NullPointerException
        DBControler.getWarehouses().add(w);
        notifyObservers();
    }
}
