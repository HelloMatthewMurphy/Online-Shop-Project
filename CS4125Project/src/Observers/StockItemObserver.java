package Observers;

import Database.DBControler;
import Services.Shop;
import java.util.Observable;
import java.util.Observer;


/**
 *
 * @author Matthew Murphy
 */
public class StockItemObserver implements Observer{
    
    private Shop shop;

    public StockItemObserver(Shop shop) {
        this.shop = shop;
    }

    @Override
    public void update(Observable o, Object arg) {
        DBControler.getInstance().save(1);
    }
    
}