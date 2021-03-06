package Database;

import Storage.Warehouse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * A database that holds warehouse information.
 * @author Shane
 */
public class WarehouseDB implements IDatabase {
    
    private final WarehouseDBLegacy warehouseDBLegacy;
    
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
    
    /**
     *
     * @param backupNum the backup number to load
     * @throws IOException -
     */
    public void loadBackup(int backupNum) throws IOException {
        warehouseDBLegacy.loadBackup(backupNum);
    }
    
    /**
     *
     * @return backup times
     * @throws IOException -
     */
    public String[] getBackupTimes() throws IOException {
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
     * @throws IOException -
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
