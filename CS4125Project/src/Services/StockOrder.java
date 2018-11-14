package Services;

import Stock.StockItem;

/**
 *
 * @author Matthew Murphy
 */
public class StockOrder {
    
    private final StockItem item;
    private final int quantity;
    //private Account account;
    /***
     * 
     * @param item The item of the order.
     * @param quantity The amount of StockItem in the order.
     */
    public StockOrder(StockItem item, int quantity){
        this.item = item;
        this.quantity = quantity;
    }
}
