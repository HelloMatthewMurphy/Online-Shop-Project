package Services;

import Stock.StockItem;
import ThirdParty.*;

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
    
    public boolean makePurchase(String address){
        CreditCardCo credit = new CreditCardCo();
        ShippingCo ship = new ShippingCo();
        return true;
    }
    
}
