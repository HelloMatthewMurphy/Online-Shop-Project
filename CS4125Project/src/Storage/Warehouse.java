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
        stock.put(itemName, amount);
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
