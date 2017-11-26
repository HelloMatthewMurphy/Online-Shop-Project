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

/**
 *  Creates testWarehouses and populates them.
 * @author Shane
 */
public class TestWarehouseDB {
    
    /**
     *  Creates testWarehouses and populates them.
     * 
     */
    public static void test() {
        
        /* 
            Test WarehouseDB
        */
        
        Warehouse w1 = new Warehouse(new Location("Ireland", "Tulla, Co. Clare"), "one");
        Warehouse w2 = new Warehouse(new Location("Spain", "Puto street, gracias"), "two");
        
        StockItem sweet = new StockItem("sweet", 1.99, "food", "a delicious treat",1);
        StockItem apple = new StockItem("apple", 0.49, "food", "a healthy snack", 1);
        StockItem yeezy = new StockItem("yeezy", 199.99, "clothes", "a cool shoe", 1);
        
        w1.addStock("sweet", 20);
        w1.addStock("apple", 40);
        w2.addStock("yeezy", 100);
        
        List<Warehouse> warehouses = new ArrayList();
        warehouses.add(w1);
        warehouses.add(w2);
        
        WarehouseDB db = DBControler.getInstance().getWarehouseDB();
        db.setFilename("warehouseinfo.csv");
        
        try {
            db.save();
        } 
        catch (IOException ex) {
            ex.printStackTrace();
        }
        
        List<Warehouse> loadedWarehouses = new ArrayList();
        
        try {
            db.load();
            loadedWarehouses.addAll(db.getWarehouses());
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
        
        // print loaded warehouses
        for (Warehouse wh : loadedWarehouses) {
            for (String siName : wh.checkStock().keySet()) {
            }
        }
        
        /* 
            Test StockItemDB
        */
        
        StockItemDB sidb = DBControler.getInstance().getStockItemDB();
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
            sidb.load();
            loadedStockItems = sidb.getStockItems();
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
        
        // print loaded stock items
    }
}
