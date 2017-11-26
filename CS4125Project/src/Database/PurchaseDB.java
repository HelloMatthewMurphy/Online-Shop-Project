/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import Services.Purchase;
import Stock.StockItem;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;

/**
 * Stores all sales ever made
 * @author Shane
 */
public class PurchaseDB implements IDatabase {
    
    private static final String BUP_PATH = "./backups/";
    private static final String BUP_PREFIX  = "P_";
    private static final int MAX_BACKUPS = 5;
    
    private String filename;
    private List<Purchase> purchases;
    
    /**
     * A constructor sets filename and a blank ArrayList for purchases
     */
    public PurchaseDB() {
        filename = "";
        purchases = new ArrayList();
    }
    
    /**
     *@param  filename sets name of filename
     */ 
    @Override
    public void setFilename(String filename) {
        this.filename = filename;
    }
    
    public ArrayList<GregorianCalendar> getBackupTimes() throws IOException {
        File dir = new File(BUP_PATH);
        ArrayList<File> filesInDir = new ArrayList(Arrays.asList(dir.listFiles()));
        
        // Remove all non-files (folders) from the arraylist, and ones which are
        // not relevant to this type
        System.out.println(filesInDir.size());
        
        for (int i = 0; i < filesInDir.size(); ) {
            System.out.println(filesInDir);
            if (!filesInDir.get(i).isFile() || !filesInDir.get(i).getName().startsWith(BUP_PREFIX))
                filesInDir.remove(i);
            else
                i++;
        }
        
        //HashMap<String, GregorianCalendar> result = new HashMap();
        ArrayList<GregorianCalendar> result = new ArrayList();
        
        // Sort files by filename alphabetically
        filesInDir.sort((o1, o2) -> {
            return o1.getName().compareTo(o2.getName());
        });
        
        // Get Dates
        for (File file : filesInDir) {
            BasicFileAttributes attr = Files.readAttributes(file.toPath(), BasicFileAttributes.class);
            long ms = attr.creationTime().toMillis();
            GregorianCalendar date = new GregorianCalendar();
            date.setTimeInMillis(ms);
            
            result.add(date);
        }
        
        return result;
    }
    
    public void loadBackup(int backupNum) throws IOException {
        if (backupNum > MAX_BACKUPS)
            backupNum = MAX_BACKUPS;
        
        String loadFilename = BUP_PREFIX + String.format("%03d", backupNum);
        
        File bupFile = new File(BUP_PATH, loadFilename);
        loadFile(bupFile.getPath());
    }
    
    /**
     * Rename P_000 to P_001 etc.
     */
    private void shiftBackupFiles() {
        File dir = new File(BUP_PATH);
        ArrayList<File> filesInDir = new ArrayList(Arrays.asList(dir.listFiles()));
        
        // Remove all non-files (folders) from the arraylist, and ones which are
        // not relevant to this type
        System.out.println(filesInDir.size());
        
        for (int i = 0; i < filesInDir.size(); ) {
            System.out.println(filesInDir);
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
            
            System.out.println("\t" + newFilename);
            
            if (newFilename.equals(BUP_PREFIX + String.format("%03d", MAX_BACKUPS)))
                filesInDir.get(i).delete();
            else
                System.out.println(filesInDir.get(i).renameTo(new File(BUP_PATH, newFilename)));
        }
        
        System.out.println(filesInDir);
    }
    
    /**
     * saves Purchases to a CSV file
     * @throws IOException
     */
    @Override
    public void save() throws IOException
    {
        saveFile(filename);
        shiftBackupFiles();
        saveFile(new File(BUP_PATH, BUP_PREFIX + "000").getPath());
    }
    
    private void saveFile(String filename) throws IOException
    {   
        PrintWriter writer = new PrintWriter(new FileWriter(filename, false));
        // Write the headers
        writer.write("Name,Quantity,Discount,Date\n");
        
        for (Purchase purchase : purchases)
        {
            String line = String.format("%s,%d,%.2f,%d/%d/%d,%s",
                purchase.getItem().getName(),
                purchase.getQuantity(),
                purchase.getDiscount(),
                purchase.getDate().get(Calendar.DATE),
                purchase.getDate().get(Calendar.MONTH) + 1,
                purchase.getDate().get(Calendar.YEAR),
                purchase.getUsername());
            writer.write(line + "\n");
        }
        
        writer.flush();
        
        System.out.println("purchase db saved");
        
        writer.close();
    }
    
    /**
     * Creates an ArrayList of purchases and adds them to a DB from a CSV file
     * @throws IOException
     */ 
    @Override
    public void load() throws IOException
    {
        loadFile(filename);
    }
    
    private void loadFile(String filename) throws IOException
    {
        System.out.println("Loading purchases from file: " + filename);
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        // Ignore the headers
        reader.readLine();
        
        // Initialize/Clear the list
        purchases = new ArrayList();
        
        String line;
        while ((line = reader.readLine()) != null) {
            String[] data = line.split(",");
            
            int quantity = Integer.parseInt(data[1]);
            double discount = Double.parseDouble(data[2]);
            
            String dateString = data[3];
            
            int day = Integer.parseInt(dateString.split("/")[0]);
            int month = Integer.parseInt(dateString.split("/")[1]);
            int year = Integer.parseInt(dateString.split("/")[2]);
            
            String username = data[4];
            
            GregorianCalendar date = new GregorianCalendar(year, month-1, day);
            
            System.out.println("Line = " + line);
            //System.out.println("Num of stockItems = " + DBControler.getInstance().getStockItemDB().getStockItems().size());
            StockItem si = DBControler.getStockItemByName(data[0]);
            System.out.println("siname = " + si.getCategory());
            purchases.add(new Purchase(si, quantity, username, date));
        }
        
        reader.close();
    }
    /**
     * @return  List of Purchases
     */ 
    public List<Purchase> getPurchases()
    {
        return purchases;
    }
}
