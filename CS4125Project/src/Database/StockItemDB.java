/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import Stock.StockItem;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Shane
 */
public class StockItemDB {
    
    String filename;
    HashMap<String, StockItem> stockItems;
    
    public StockItemDB() {
        filename = "";
        stockItems = new HashMap();
    }
    
    public void setFilename(String filename) {
        this.filename = filename;
    }
    
    public void addStockItem(StockItem stockItem) {
        stockItems.put(stockItem.getName(), stockItem);
    }
    
    public void save() throws IOException {
        PrintWriter writer = new PrintWriter(new FileWriter(filename, false));
        writer.write("Name,Price,Category,Description\n");
        
        for (String siName : stockItems.keySet()) {
            String line = String.format("%s,%.2f,%s,%s",
                    siName,
                    stockItems.get(siName).getPrice(),
                    stockItems.get(siName).getCategory(),
                    stockItems.get(siName).getDescription());
            writer.write(line + "\n");
        }
        
        writer.flush();
    }
    
    public HashMap<String, StockItem> load() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        // Ignore the headers
        reader.readLine();
        
        HashMap<String, StockItem> result = new HashMap();
        
        String line;
        while ((line = reader.readLine()) != null) {
            String[] data = line.split(",");
            double price = Double.parseDouble(data[1]);
            
            StockItem si = new StockItem(data[0], price, data[2], data[3]);
            
            result.put(data[0], si);
        }
        
        return result;
    }
}
