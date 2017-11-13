/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Database.DBControler;
import Storage.*;
import Services.*;
import Stock.*;
import User.*;
import java.util.Map;

/**
 *
 * @author Matthew Murphy
 */
public class TestingShop {
    public static void test(){
        Customer c = new Customer("Matt", "Pass", "Email@email.email");

        //Testing warehouses
        Shop s = Shop.getInstance();
        s.setAccount(c);
        print(s);
        
        //Testing making purchace
        StockItem stockItem = DBControler.getInstance().getStockItemDB().getStockItemByName("yeezy");
        s.makePurchase(stockItem, 2);
        print(s);
        
        //Testing returning item
        s.returnItem(stockItem);
        print(s);
    }
    
    private static void print(Shop s){
        String stock = "";
        Map<String, Integer> checkStock = s.checkStock();
        stock = checkStock.toString();
        System.out.println(stock);
    }
}
