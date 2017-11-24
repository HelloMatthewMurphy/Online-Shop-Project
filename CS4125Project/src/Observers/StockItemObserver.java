package Observers;

import Database.DBControler;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author Matthew Murphy
 */
public class StockItemObserver implements Observer{
    
<<<<<<< HEAD
=======
    /**
    *
    * @param o
    * @param arg
    * 
    */
>>>>>>> 634bac179c7fcde41eb87e4378c787a696f182d9
    @Override
    public void update(Observable o, Object arg) {
        DBControler.getInstance().save(DBControler.STOCKITEM_DB);
    }
}