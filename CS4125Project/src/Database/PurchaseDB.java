/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import Services.Money;
import Services.Purchase;
import Stock.StockItem;
import java.io.*;
import java.util.*;


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
        
        for (int i = 0; i < filesInDir.size();) {
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
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename, false))) {
            // Write the headers
            writer.write("Name,Quantity,Discount,Currency,Date\n");
            
            purchases.stream().map((Purchase purchase) -> String.format("%s,%d,%.2f,%s,%d/%d/%d,%s",
                    purchase.getItem().getName(),
                    purchase.getQuantity(),
                    purchase.getDiscount(),
                    purchase.getMoney().getCurrency().name(),
                    purchase.getDate().get(Calendar.DATE),
                    purchase.getDate().get(Calendar.MONTH) + 1,
                    purchase.getDate().get(Calendar.YEAR),
                    purchase.getUsername())).forEachOrdered((String line) -> {
                        writer.write(line + "\n");
            });
            
            writer.flush();
        }
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

        BufferedReader reader = new BufferedReader(new FileReader(filename));
        reader.readLine();
        
        // Initialize/Clear the list
        purchases = new ArrayList();
        
        String line;
        while ((line = reader.readLine()) != null) {
            String[] data = line.split(",");
            
            int quantity = Integer.parseInt(data[1]);
            double discount = Double.parseDouble(data[2]);
            
            String currencyStr = data[3];
            Money.Currency currency = Money.Currency.valueOf(currencyStr);
            
            String dateString = data[4];
            String username = data[5];
            
            int day = Integer.parseInt(dateString.split("/")[0]);
            int month = Integer.parseInt(dateString.split("/")[1]);
            int year = Integer.parseInt(dateString.split("/")[2]);
            
            GregorianCalendar date = new GregorianCalendar(year, month-1, day);
            
            StockItem si = DBControler.getStockItemByName(data[0]);
            purchases.add(new Purchase(si, quantity, username, currency, date));
        }
    }
    /**
     * @return  List of Purchases
     */ 
    public List<Purchase> getPurchases()
    {
        return purchases;
    }
}
