/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import Storage.Location;
import Storage.Warehouse;
import Stock.StockItem;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Shane
 */
public class TestWarehouseDB {
    
    public static void test() {
        
        /* 
            Test WarehouseDB
        */
        
        Warehouse w1 = new Warehouse(new Location("Ireland", "Tulla, Co. Clare"), "one");
        Warehouse w2 = new Warehouse(new Location("Spain", "420 puto street, gracias"), "two");
        
        StockItem sweet = new StockItem("sweet", 1.99, "food", "a delicious treat");
        StockItem apple = new StockItem("apple", 0.49, "food", "a healthy snack");
        StockItem yeezy = new StockItem("yeezy", 199.99, "clothes", "a cool shoe");
        
        w1.addStock("sweet", 20);
        w1.addStock("apple", 40);
        w2.addStock("yeezy", 100);
        
        List<Warehouse> warehouses = new ArrayList();
        warehouses.add(w1);
        warehouses.add(w2);
        
        WarehouseDB db = new WarehouseDB(warehouses);
        db.setFilename("warehouseinfo.csv");
        
        try {
            db.save();
        } 
        catch (IOException ex) {
            ex.printStackTrace();
        }
        
        List<Warehouse> loadedWarehouses = new ArrayList();
        
        try {
            loadedWarehouses.addAll(db.load());
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
        
        // print loaded warehouses
        for (Warehouse wh : loadedWarehouses) {
            System.out.println("NAME: " + wh.getName());
            for (String siName : wh.checkStock().keySet()) {
                System.out.println(siName + "\t" + wh.checkStock().get(siName));
            }
        }
        
        /* 
            Test StockItemDB
        */
        
        StockItemDB sidb = new StockItemDB();
        sidb.setFilename("stockiteminfo.csv");
        
        sidb.addStockItem(sweet);
        sidb.addStockItem(apple);
        sidb.addStockItem(yeezy);
        
        try {
            sidb.save();
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
        
        HashMap<String, StockItem> loadedStockItems = null;
        
        try {
            loadedStockItems = sidb.load();
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
        
        // print loaded warehouses
        for (String siName : loadedStockItems.keySet()) {
            System.out.printf("%s,%.2f,%s,%s\n",
                    loadedStockItems.get(siName).getName(),
                    loadedStockItems.get(siName).getPrice(),
                    loadedStockItems.get(siName).getCategory(),
                    loadedStockItems.get(siName).getDescription());
        }
    }
}
