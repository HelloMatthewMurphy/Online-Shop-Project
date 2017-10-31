/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

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
        Warehouse w1 = new Warehouse(new Location("Ireland", "Street With Name"), "w1");
        Warehouse w2 = new Warehouse(new Location("Ireland", "Street With Name also, huh what are the chances?"), "w2");
        
        StockItem book = new StockItem("Book", 5.0, "Readable", "Read or burn it!");
        StockItem chair = new StockItem("Chair", 50.0, "Sitable", "Sit on it or burn it!");
        StockItem bread = new StockItem("Bread", 2.0, "Eatable", "Eat it or burn it!");

        
        w1.addStock(book.getName(), 30);
        w1.addStock(chair.getName(), 2);
        w2.addStock(bread.getName(), 9);
        Shop s = new Shop(c);
        s.addWarehouse(w1);
        s.addWarehouse(w2);
        String stock = "";
        Map<String, Integer> checkStock = s.checkStock();
        stock = checkStock.toString();
        System.out.println(stock);
        
        s.makePurchase(book, 2);
        
        Map<String, Integer> checkStock2 = s.checkStock();
        stock = checkStock2.toString();
        System.out.println(stock);
    }
}
