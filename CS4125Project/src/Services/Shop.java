package Services;

//import Business.Account;
import Database.DBControler;
import Observers.Observer;
import Observers.WarehouseStockObserver;
import Stock.StockItem;
import Storage.Warehouse;
import User.Customer;
import Services.Purchase;
import Storage.Location;
import java.util.ArrayList;

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
public class Shop {
    
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
    
    private StockItem item;
    private int quantity;
    private Customer account;
    private List<Warehouse> warehouses;
    private List<Observer> observers;
    
    public Shop(Customer account){
        this.account = account;
        warehouses = new ArrayList<Warehouse>();
        warehouses.addAll(DBControler.getInstance().getWarehouseDB().getWarehouses());
        observers = new ArrayList<Observer>();
        observers.add(new WarehouseStockObserver(this));
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
        for(int i = 0; i < warehouses.size(); i++){
            tempStock = warehouses.get(i).checkStock();
            // Loop through and check if item exists on totalStock.
            totalStock.putAll(tempStock);
        }
        return totalStock;
    }
    
    public void returnItem(StockItem item){
        boolean done = false;
        for(int i = 0; i < warehouses.size() && !done; i++){
            if(warehouses.get(i).hasItem(item.getName())){
                warehouses.get(i).addStock(item.getName(), 1);
                done = true;
            }
        }
        updateAllObservers();
    }
    
    public void makePurchase(StockItem item, int quantity){
        Purchase pur = new Purchase(item, quantity);
        boolean purchaseHappened = false;
        purchaseHappened = pur.makePurchase(account.getLocation());
        if(purchaseHappened){
            boolean done = false;
            for(int i = 0; i < warehouses.size() && !done; i++){
                if(warehouses.get(i).hasItem(item.getName())){
                    warehouses.get(i).buyStock(item.getName(), quantity);
                    done = true;
                }
            }
            updateAllObservers();
        }
    }
    
    public void addDiscount(){
        
    }
    
    public void addWarehouse(Warehouse w){
        warehouses.add(w);
    }
    
    private void updateAllObservers(){
        for(Observer observer : observers) {
            observer.update();
        }
    }
    
}
