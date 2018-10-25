/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs4125project;

import Database.DBControler;
import MenuUI.MainMenuUI;
import Services.*;
import Stock.StockItem;
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
        
        // Initialize and load DBs
        DBControler.getInstance().load(DBControler.ALL_DB);
        // TODO code application logic here
        MainMenuUI menu = new MainMenuUI();
        menu.run();
        
        
        // remember to remove all this boi
        ShoppingBasket basket = new ShoppingBasket();
        ShopControl controler = new ShopControl();
        
        controler.AddCommand(new BuyItemCommand(new StockItem("Item 1", 4.20), basket));
        controler.AddCommand(new BuyItemCommand(new StockItem("Item 2", 400), basket));
        controler.AddCommand(new BuyItemCommand(new StockItem("Item 3", 9999.99), basket));
        
        controler.ExecuteCommand(0);
        controler.ExecuteCommand(2);
        controler.ExecuteCommand(1);
        
        controler.Undo();
        controler.Undo();
        controler.Undo();
    }
}
