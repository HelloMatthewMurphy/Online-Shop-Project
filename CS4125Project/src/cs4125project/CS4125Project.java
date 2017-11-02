/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs4125project;

import MenuUI.MenuUI;
import Services.TestingShop;
import java.io.IOException;

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
        
        // TODO code application logic here
        MenuUI menu = new MenuUI();
        menu.startSession();
        //TestingShop.test();
    }
}
