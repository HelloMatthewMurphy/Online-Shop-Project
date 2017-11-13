/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import Stock.StockItem;
import Storage.Warehouse;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Shane
 */
public class WarehouseDB implements IDatabase {
    
    private String filename;
    private List<Warehouse> warehouses;
    
    public WarehouseDB() {
        filename = "";
        warehouses = new ArrayList();
    }
    
    public WarehouseDB(List<Warehouse> warehouses) {
        filename = "";
        this.warehouses = warehouses;
    }
    
    @Override
    public void setFilename(String filename) {
        this.filename = filename;
    }
    
    @Override
    public void save() throws IOException {
        PrintWriter writer = new PrintWriter(new FileWriter(filename, false));
        writer.write("Location,Item name,Quantity\n");
        
        // For every warehouse
        for (Warehouse wh : warehouses) {
            
            // Write the name of the warehouse
            writer.write(wh.getName());
            
            boolean firstItem = true;            
            // For every item in stock
            for (String siName : wh.checkStock().keySet()) {
                // Write item name and quantity to file
                
                String line = String.format(",%s,%s",
                        siName,
                        wh.checkStock().get(siName));
                writer.write((firstItem ? "" : " ") + line + "\n");
                firstItem = false;
            }
            
            writer.flush();
        }
    }
    
    @Override
    public void load() throws IOException {
        
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        // Ignore the headers
        reader.readLine();
        
        String line;
        String previousWarehouseName = "";
        String currentWarehouseName = "";
        
        warehouses = new ArrayList();
        int currentWarehouseIndex = -1;
        
        while ((line = reader.readLine()) != null) {            
            // Separate the data
            String[] data = line.split(",");
            
            // Check to see if it is the first item for that warehouse
            if (!data[0].equals(" ")) {
                currentWarehouseName = data[0];
            }
            
            // If the reader comes accross a new warehouse
            if (!currentWarehouseName.equals(previousWarehouseName)) {
                warehouses.add(new Warehouse(null, data[0]));
                currentWarehouseIndex++;
            }
            
            // add data to warehouse
            int quantity = Integer.parseInt(data[2]);
            warehouses.get(currentWarehouseIndex).addStock(data[1], quantity);
            
            previousWarehouseName = currentWarehouseName;
        }
    }
    
    public List<Warehouse> getWarehouses() {
        return warehouses;
    }
}
