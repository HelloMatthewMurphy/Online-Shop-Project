/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Observers;

import Database.DBControler;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author Matthew
 */
public class PurchaseObserver implements Observer
{
    @Override
    public void update(Observable o, Object arg) {
        System.out.println("purchase observer updated");
        DBControler.getInstance().save(DBControler.PURCHASE_DB);
    }
}
