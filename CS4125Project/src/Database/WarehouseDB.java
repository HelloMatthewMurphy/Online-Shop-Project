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
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * A database that holds warehouse information.
 * @author Shane
 */
public class WarehouseDB implements IDatabase {
    
    private WarehouseDBLegacy warehouseDBLegacy;
    
    /**
     * A constructor sets filename and a blank ArrayList for accounts
     */
    public WarehouseDB() {
        warehouseDBLegacy = new WarehouseDBLegacy();
    }
    
    /**
     * A constructor sets filename and a ArrayList for warehouses
     * @param warehouses An ArrayList of warehouses
     */
    public WarehouseDB(List<Warehouse> warehouses) {
        warehouseDBLegacy = new WarehouseDBLegacy(warehouses);
    }
    
    /**
     *@param  filename sets name of filename
     */ 
    @Override
    public void setFilename(String filename) {
        warehouseDBLegacy.setFilename(filename);
    }
    
    public void loadBackup(int backupNum) throws IOException {
        warehouseDBLegacy.loadBackup(backupNum);
    }
    
    public String[] getBackupTimeStrings() throws IOException {
        ArrayList<GregorianCalendar> backupTimes = warehouseDBLegacy.getBackupTimes();
        
        String[] result = new String[backupTimes.size()];
        
        for (int i = 0; i < backupTimes.size(); i++)
        {
            GregorianCalendar date = backupTimes.get(i);
            int day = date.get(Calendar.DAY_OF_MONTH);
                int month = date.get(Calendar.MONTH) + 1;
                int year = date.get(Calendar.YEAR);
                int hour = date.get(Calendar.HOUR_OF_DAY);
                int minute = date.get(Calendar.MINUTE);
                int second = date.get(Calendar.SECOND);
                result[i] = String.format("%2d:\tCreated on %02d/%02d/%02d at %02d:%02d:%02d\n",
                        i, day, month, year, hour, minute, second);
        }
        
        return result;
    }
    
    /**
     * saves Warehouses to a CSV file
     * @throws IOException
     */
    @Override
    public void save() throws IOException {
        warehouseDBLegacy.save();
    }
    
    @Override
    public void load() throws IOException {
        warehouseDBLegacy.load();
    }
    
    /**
     * @return warehouses
     */ 
    public List<Warehouse> getWarehouses() {
        return warehouseDBLegacy.getWarehouses();
    }   
}
