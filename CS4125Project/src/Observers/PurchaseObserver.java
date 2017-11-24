package Observers;

import Database.DBControler;
import java.util.Observable;
import java.util.Observer;

/**
<<<<<<< HEAD
 *
 * @author Matthew Murphy
=======
 * 
 * @author Matthew
>>>>>>> 634bac179c7fcde41eb87e4378c787a696f182d9
 */
public class PurchaseObserver implements Observer
{
    /**
    *
    * @param o
    * @param arg
    * 
    */
    @Override
    public void update(Observable o, Object arg) {
        DBControler.getInstance().save(DBControler.PURCHASE_DB);
    }
}