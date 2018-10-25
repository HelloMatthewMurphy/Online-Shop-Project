/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import Stock.StockItem;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 *A database that holds all types of StockItems
 * @author Shane
 */
public class StockItemDB implements IDatabase {
    
    private static final String BUP_PATH = "./backups/";
    private static final String BUP_PREFIX  = "SI_";
    private static final int MAX_BACKUPS = 5;
    
    String filename;
    HashMap<String, StockItem> stockItems;
    
    /**
     * A constructor sets filename and a hashmap of StockItems
     */
    public StockItemDB() {
        filename = "";
        stockItems = new HashMap();
    }
    
    /**
     * @param stockItem added to stockItem hashmap
     */
    public void addStockItem(StockItem stockItem) {
        stockItems.put(stockItem.getName(), stockItem);
    }
    
    /**
     *@param  filename sets name of filename
     */ 
    @Override
    public void setFilename(String filename) {
        this.filename = filename;
    }
    
    public void loadBackup(int backupNum) throws IOException {
        if (backupNum > MAX_BACKUPS)
            backupNum = MAX_BACKUPS;
        
        String loadFilename = BUP_PREFIX + String.format("%03d", backupNum);
        loadFile(new File(BUP_PATH, loadFilename).getPath());
    }
    
    /**
     * Rename SI_000 to SI_001 etc.
     */
    private void shiftBackupFiles() {
        File dir = new File(BUP_PATH);
        ArrayList<File> filesInDir = new ArrayList(Arrays.asList(dir.listFiles()));
        
        // Remove all non-files (folders) from the arraylist, and ones which are
        // not relevant to this type
        
        for (int i = 0; i < filesInDir.size(); ) {
            if (!filesInDir.get(i).isFile() || !filesInDir.get(i).getName().startsWith(BUP_PREFIX))
                filesInDir.remove(i);
            else
                i++;
        }
        
        // Sort files by filename reverse alphabetically
        filesInDir.sort((o1, o2) -> {
            return -o1.getName().compareTo(o2.getName());
        });
        
        // Print out all files
        for (int i = 0; i < filesInDir.size(); i++) {            
            String oldFilename = filesInDir.get(i).getName();
            int id = Integer.parseInt(oldFilename.substring(BUP_PREFIX.length()));
            String newFilename = BUP_PREFIX + String.format("%03d", id + 1);
            
            
            if (newFilename.equals(BUP_PREFIX + String.format("%03d", MAX_BACKUPS)))
                filesInDir.get(i).delete();
        }
        
    }
    
    /**
     * saves StockItems to a CSV file
     * @throws IOException
     */ 
    @Override
    public void save() throws IOException {
        saveFile(filename);
        shiftBackupFiles();
        saveFile(new File(BUP_PATH, BUP_PREFIX + "000").getPath());
    }
    
    private void saveFile(String filename) throws IOException {
        PrintWriter writer = new PrintWriter(new FileWriter(filename, false));
        writer.write("Name,Price,Category,Description,Discount,\n");
        
        for (String siName : stockItems.keySet()) {
            String line = String.format("%s,%.2f,%s,%s,%.2f",
                    siName,
                    stockItems.get(siName).getPrice(),
                    stockItems.get(siName).getCategory(),
                    stockItems.get(siName).getDescription(),
                    stockItems.get(siName).getDiscount());
            writer.write(line + "\n");
        }
        
        writer.flush();
    }
    
    /**
     * Creates StockItem and adds them to a DB
     * @throws IOException
     */ 
    @Override
    public void load() throws IOException {
        loadFile(filename);
    }
    
    public void loadFile(String filename) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        // Ignore the headers
        reader.readLine();
        
        String line;
        while ((line = reader.readLine()) != null) {
            String[] data = line.split(",");
            double price = Double.parseDouble(data[1]);
            double discount = Double.parseDouble(data[4]);
            StockItem si = new StockItem(data[0], price, data[2], data[3], discount);
            
            stockItems.put(data[0], si);
        }
        
        reader.close();        
    }
    /**
     * @return stockItems
     */ 
    public HashMap<String, StockItem> getStockItems() {
        return stockItems;
    }
    
    /**
     * @return stockItem
     */
    public StockItem getStockItemByName(String name){
        return stockItems.get(name);
    }
      
}
