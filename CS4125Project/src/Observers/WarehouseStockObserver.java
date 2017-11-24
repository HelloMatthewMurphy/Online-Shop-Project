package Observers;

import Database.DBControler;
import Services.Shop;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author Matthew Murphy
 */
public class WarehouseStockObserver implements Observer{

    /**
    *
    * @param o
    * @param arg
    * 
    */
    @Override
    public void update(Observable o, Object arg) {
        DBControler.getInstance().save(DBControler.WAREHOUSE_DB);
    }
    
}
