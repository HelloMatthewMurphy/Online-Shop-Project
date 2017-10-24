package Services;

import Stock.StockItem;

/**
 *
 * @author Matthew Murphy
 */
public class StockOrder {
    
    private StockItem item;
    private int quantity;
    //private Account account;
    
    public StockOrder(StockItem item, int quantity){
        this.item = item;
        this.quantity = quantity;
    }
}
