/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Storage;

import Stock.StockItem;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Matthew Murphy
 */
public class Warehouse {
    
    private Map<StockItem, Integer> stock;
    //private ArrayList<StockItem> stock;
    private Location warehouseLocation;
    
    public Warehouse(Location warehouseLocation){
        stock = new HashMap<StockItem, Integer>();
        this.warehouseLocation = warehouseLocation; 
    }
    
    public void addStock(StockItem item){
        stock.put(item, 1);
    }
    
    public void addStock(StockItem item, int amount){
        stock.put(item, amount);
    }
    
    public Map<StockItem, Integer> checkStock(){
        return stock;
    }
    
    public Location getLocation (){
        return warehouseLocation;
    }
}
