package Observers;

import Database.DBControler;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author Matthew Murphy
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