package Services;

import Stock.StockItem;

/**
 *
 * @author Matthew Murphy
 */
public class Purchase {
    
    private StockItem item;
    private int quantity;
    
    public Purchase(StockItem item, int quantity){
        this.item = item;
        this.quantity = quantity;
    }
    
}
