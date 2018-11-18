package Storage;

import java.util.HashMap;
import java.util.Map;

/**
 * A warehouse which holds stock.
 * @author Matthew
 */
public class Warehouse {
    
    // Map of stockitem's names to quantity
    private final Map<String, Integer> stock;
    //private ArrayList<StockItem> stock;
    private final Location warehouseLocation;
    private final String name;
    
    /**
     * A constructor of Warehouse which sets the location and name of the warehouse.
     * @param warehouseLocation The location where the warehouse is.
     * @param name The name of the warehouse.
     */
    public Warehouse(Location warehouseLocation, String name){
        stock = new HashMap<>();
        this.warehouseLocation = warehouseLocation;
        this.name = name;
    }
    
    /**
     * 
     * @param itemName The name of the item.
     */
    public void addStock(String itemName){
        stock.put(itemName, 1);
    }
    
    /**
     * 
     * @param itemName The name of the item.
     * @param amount The amount of stock to be added to the warehouse.
     */
    public void addStock(String itemName, int amount){
        if(stock.containsKey(itemName))
            stock.put(itemName, stock.get(itemName) + amount);
        else
            stock.put(itemName, amount);
    }
    
    /**
     * 
     * @param itemBought The item to be bought.
     * @param amountBought The amount to be bought.
     */
    public void buyStock(String itemBought, int amountBought){
        stock.put(itemBought, stock.get(itemBought) - amountBought);
    }
    
    /**
     * 
     * @param itemName Checks if Item is in warehouse.
     * @return true if warehouse is storing a requested item
     */
    public boolean hasItem(String itemName){
        boolean bool = stock.containsKey(itemName);
        return bool;
    }
    
    /**
     * 
     * @return stock
     */
    public Map<String, Integer> checkStock(){
        return stock;
    }
    
    /**
     * 
     * @return warehouseLocation
     */
    public Location getLocation (){
        return warehouseLocation;
    }
    
    /**
     * 
     * @return name
     */
    public String getName() {
        return name;
    }
}
