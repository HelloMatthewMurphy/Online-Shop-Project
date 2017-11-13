package Observers;

import Database.DBControler;
import Services.Shop;

/**
 *
 * @author Matthew Murphy
 */
public class WarehouseStockObserver extends Observer{
    
    private Shop shop;

    public WarehouseStockObserver(Shop shop) {
        this.shop = shop;
    }

    @Override
    public void update() {
        DBControler.getInstance().save(2);
    }
    
}
