package Services;

//import Business.Account;
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
    
    private StockItem item;
    private int quantity;
    private Customer account;
    private ArrayList<Warehouse> warehouses;
    
    public Shop(Customer account){
        this.account = account;
        warehouses = new ArrayList<Warehouse>();
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
        //Needs to add item back to warehouse
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
        }
    }
    
    public void addDiscount(){
        
    }
    
    public void addWarehouse(Warehouse w){
        warehouses.add(w);
    }
    
}
