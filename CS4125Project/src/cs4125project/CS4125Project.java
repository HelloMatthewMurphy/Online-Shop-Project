/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs4125project;

import Database.DBControler;
import MenuUI.MainMenuUI;
import MenuUI.MenuUI;
import MenuUI.ShopAnalysisUI;
import Services.TestingShop;
import Storage.Warehouse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author Matthew Murphy
 */
public class CS4125Project {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, InterruptedException {

        //Database.TestWarehouseDB.test();
        
        // Initialize and load DBs
        DBControler.getInstance().load(DBControler.ALL_DB);
        // TODO code application logic here
        MainMenuUI menu = new MainMenuUI();
        menu.run();
    }
}
