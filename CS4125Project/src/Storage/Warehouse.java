package Storage;

import Stock.StockItem;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Matthew Murphy
 */
public class Warehouse {
    
    // Map of stockitem's names to quantity
    private Map<String, Integer> stock;
    //private ArrayList<StockItem> stock;
    private Location warehouseLocation;
    private String name;
    
    public Warehouse(Location warehouseLocation, String name){
        stock = new HashMap<String, Integer>();
        this.warehouseLocation = warehouseLocation;
        this.name = name;
    }
    
    public void addStock(String itemName){
        stock.put(itemName, 1);
    }
    
    public void addStock(String itemName, int amount){
        if(stock.containsKey(itemName))
            stock.put(itemName, stock.get(itemName) + amount);
        else
            stock.put(itemName, amount);
    }
    
    public void buyStock(String itemBought, int amountBought){
        stock.put(itemBought, stock.get(itemBought) - amountBought);
    }
    
    public boolean hasItem(String itemName){
        boolean bool = stock.containsKey(itemName);
        return bool;
    }
    
    public Map<String, Integer> checkStock(){
        return stock;
    }
    
    public Location getLocation (){
        return warehouseLocation;
    }
    
    public String getName() {
        return name;
    }
}
