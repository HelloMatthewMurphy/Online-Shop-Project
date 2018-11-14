package Database;

import Stock.StockItem;
import Storage.Warehouse;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Creates an instance of each database for the system to use.
 * @author Matthew Murphy
 */
public class DBControler {
    
    public static final int ACCOUNT_DB = 0;
    public static final int STOCKITEM_DB = 1;
    public static final int WAREHOUSE_DB = 2;
    public static final int ALL_DB = 3;
    public static final int PURCHASE_DB = 4;
    public static final int LOCALIZATION_DB = 5;
    
    private static DBControler instance;
    private final AccountDB aDB;
    private final StockItemDB sDB;
    private final WarehouseDB wDB;
    private final PurchaseDB pDB;
    private final LocalizationDB lDB;
    
    /**
     * A constructor sets filename for each database
     * Creates an instance of each database
     * 
     */
    private DBControler(){
        aDB = new AccountDB();
        sDB = new StockItemDB();
        wDB = new WarehouseDB();
        pDB = new PurchaseDB();
        lDB = new LocalizationDB();
        
        aDB.setFilename("RegisteredUsers.csv");
        sDB.setFilename("stockiteminfo.csv");
        wDB.setFilename("warehouseinfo.csv");
        pDB.setFilename("purchaseinfo.csv");
        lDB.setFilename("Localization.csv");
    }
    
    /**
     * Creates an instance of DBController
     * @return instance
     */
    public static DBControler getInstance(){
        if(instance == null)
            instance = new DBControler();
        return instance;
    }
    
    /**
     * @param loading loads a database depending an integer
     */ 
    public void load(int loading){
        try {
            switch (loading){
                case ACCOUNT_DB:        aDB.load();  
                break;
                case STOCKITEM_DB:      sDB.load();  
                break;
                case WAREHOUSE_DB:      wDB.load();  
                break;
                case PURCHASE_DB:       pDB.load();
                break;
                case LOCALIZATION_DB:   lDB.load();
                break;
                case ALL_DB:            aDB.load();
                                        sDB.load();
                                        wDB.load();
                                        pDB.load();
                                        lDB.load();
                break;
        }
        } catch (IOException ex) {
            Logger.getLogger(DBControler.class.getName()).log(Level.SEVERE, null, ex);
            System.exit(0);
        }
    }
    
     /**
     * @param saving Depending on the int passed in a different database will be saved.
     */ 
    public void save(int saving){
        try {
            switch (saving){
                case ACCOUNT_DB:        aDB.save();  
                break;
                case STOCKITEM_DB:      sDB.save();  
                break;
                case WAREHOUSE_DB:      wDB.save();  
                break;
                case PURCHASE_DB:       pDB.save();
                break;
                case LOCALIZATION_DB:   lDB.save();
                break;
                case ALL_DB:            aDB.save();
                                        sDB.save();
                                        wDB.save();
                                        pDB.save();
                                        lDB.save();
                break;
        }
        } catch (IOException ex) {
            Logger.getLogger(DBControler.class.getName()).log(Level.SEVERE, null, ex);
            System.exit(0);
        }
    }
    
     /**
     * @return AccountDB
     */ 
    public AccountDB getAccountDB(){
        return aDB;
    }
    
    /**
     * @return StockItemDB
     */ 
    public StockItemDB getStockItemDB(){
        return sDB;
    }
    
    /**
     * @return WareHouseDB
     */ 
    public WarehouseDB getWarehouseDB(){
        return wDB;
    }
    
    /**
     * @return PurchaseDB
     */ 
    public PurchaseDB getPurchaseDB() {
        return pDB;
    }
    
    /**
     * @return LocalizationDB
     */ 
    public LocalizationDB getLocalizationDB() {
        return lDB;
    }
    
    /**
     * @return List Warehouse
     */ 
    public static List<Warehouse> getWarehouses() {
        if (instance == null)
            getInstance();
        
        return instance.wDB.getWarehouses();
    }
    
    /**
     * @param name Name of stock item
     * @return StockItem
     */ 
    public static StockItem getStockItemByName(String name) {
        if (instance == null)
            getInstance();
        
        return instance.getStockItemDB().getStockItems().get(name);
    }
}
