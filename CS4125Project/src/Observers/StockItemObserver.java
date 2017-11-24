package Observers;

import Database.DBControler;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author Matthew Murphy
 */
public class StockItemObserver implements Observer{
    
    @Override
    public void update(Observable o, Object arg) {
        DBControler.getInstance().save(DBControler.STOCKITEM_DB);
    }
}