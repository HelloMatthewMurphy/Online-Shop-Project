/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import Services.Purchase;
import Stock.StockItem;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Stores all sales ever made
 * @author Shane
 */
public class PurchaseDB implements IDatabase {
    
    private String filename;
    private List<Purchase> purchases;
    
    public PurchaseDB() {
        filename = "";
        purchases = new ArrayList();
    }
    
    @Override
    public void setFilename(String filename) {
        this.filename = filename;
    }
    
    @Override
    public void save() throws IOException
    {
        PrintWriter writer = new PrintWriter(new FileWriter(filename, false));
        // Write the headers
        writer.write("Name,Quantity,Discount,Date");
        
        for (Purchase purchase : purchases)
        {
            String line = String.format("%s,%d,%.2f,%d/%d/%d",
                purchase.getItem().getName(),
                purchase.getQuantity(),
                purchase.getDiscount(),
                purchase.getDate().get(Calendar.DATE),
                purchase.getDate().get(Calendar.MONTH) + 1,
                purchase.getDate().get(Calendar.YEAR));
            writer.write(line + "\n");
        }
        
        writer.flush();
    }
    
    @Override
    public void load() throws IOException
    {
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
            
            GregorianCalendar date = new GregorianCalendar(year, month-1, day);
            
            StockItem si = 
                    DBControler.getInstance().getStockItemDB().getStockItems().get(data[1]);
            purchases.add(new Purchase(si, quantity));
        }
    }
}
