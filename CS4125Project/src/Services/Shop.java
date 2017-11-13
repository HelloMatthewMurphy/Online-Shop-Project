package Services;

//import Business.Account;
import Database.DBControler;
import Observers.Observer;
import Observers.StockItemObserver;
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
import java.util.Scanner;

/**
 *
 * @author Matthew Murphy
 */
public class Shop {
    
    private static Shop instance;
    private StockItem item;
    private int quantity;
    private Customer account;
    //private List<Warehouse> warehouses;
    private List<Observer> observers;
    
    private Shop(Customer account){
        this.account = account;
        //warehouses = new ArrayList<Warehouse>();
        //warehouses.addAll(DBControler.getInstance().getWarehouseDB().getWarehouses());
        observers = new ArrayList<Observer>();
        observers.add(new WarehouseStockObserver(this));
        observers.add(new StockItemObserver(this));
    }
    
    public static Shop getInstance(){
        if(instance == null)
            instance = new Shop();
        return instance;
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
        updateAllObservers();
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
            updateAllObservers();
        }
    }
    
    public void addDiscount(){
        
        updateAllObservers();
    }
    
    public void addWarehouse(Warehouse w){
        //Broken NullPointerException
        DBControler.getWarehouses().add(w);
        updateAllObservers();
    }
    
    private void updateAllObservers(){
        for(Observer observer : observers) {
            observer.update();
        }
    }
    
}
