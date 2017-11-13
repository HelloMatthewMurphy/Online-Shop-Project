package Observers;

import Database.DBControler;
import Services.Shop;

/**
 *
 * @author Matthew Murphy
 */
public class StockItemObserver extends Observer{
    
    private Shop shop;

    public StockItemObserver(Shop shop) {
        this.shop = shop;
    }

    @Override
    public void update() {
        DBControler.getInstance().save(1);
    }
    
}