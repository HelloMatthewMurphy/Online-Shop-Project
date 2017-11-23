/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import Storage.Warehouse;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Shane
 */
public class WarehouseDB implements IDatabase {
    
    private static final String BUP_PATH = "./backups/";
    private static final String BUP_PREFIX = "WH_";
    private static final int MAX_BACKUPS = 5;
    
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
    
    public void loadBackup(int backupNum) throws IOException {
        if (backupNum > MAX_BACKUPS)
            backupNum = MAX_BACKUPS;
        
        String loadFilename = BUP_PREFIX + String.format("%03d", backupNum);
        loadFile(new File(BUP_PATH, loadFilename).getPath());
    }
    
    @Override
    public void save() throws IOException {
        saveFile(filename);
        shiftBackupFiles();
        saveFile(new File(BUP_PATH, BUP_PREFIX + "000").getPath());
    }
    
    /**
     * Rename WH_000 to WH_001 etc.
     */
    private void shiftBackupFiles() {
        File dir = new File(BUP_PATH);
        ArrayList<File> filesInDir = new ArrayList(Arrays.asList(dir.listFiles()));
        
        // Remove all non-files (folders) from the arraylist
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
            else
                filesInDir.get(i).renameTo(new File(BUP_PATH, newFilename));
        }
        
        System.out.println(filesInDir);
    }
    
    private void saveFile(String filename) throws IOException {
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
        
        writer.close();
    }
    
    private void loadFile(String filename) throws IOException {
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
        reader.close();
    }
    
    @Override
    public void load() throws IOException {
        loadFile(filename);
    }
    
    public List<Warehouse> getWarehouses() {
        return warehouses;
    }   
}
