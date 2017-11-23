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
    
    private static DBControler instance;
    private AccountDB aDB;
    private StockItemDB sDB;
    private WarehouseDB wDB;
    private PurchaseDB pDB;
    
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
        
        aDB.setFilename("RegisteredUsers.csv");
        sDB.setFilename("stockiteminfo.csv");
        wDB.setFilename("warehouseinfo.csv");
        pDB.setFilename("purchaseinfo.csv");
    }
    
    /**
     * Creates an instance of DBController
     */
    public static DBControler getInstance(){
        if(instance == null)
            instance = new DBControler();
        return instance;
    }
    
    /**
     * @param loading loads a database depending an int
     */ 
    public void load(int loading){
        try {
            switch (loading){
                case ACCOUNT_DB:    aDB.load();  
                break;
                case STOCKITEM_DB:  sDB.load();  
                break;
                case WAREHOUSE_DB:  wDB.load();  
                break;
                case PURCHASE_DB:   pDB.load();
                break;
                case ALL_DB:        aDB.load();
                                    sDB.load();
                                    wDB.load();
                                    pDB.load();
                break;
        }
        } catch (IOException ex) {
            Logger.getLogger(DBControler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     /**
     * @param saving Depending on the int passed in a different database will be saved.
     */ 
    public void save(int saving){
        try {
            switch (saving){
                case ACCOUNT_DB:    aDB.save();  
                break;
                case STOCKITEM_DB:  sDB.save();  
                break;
                case WAREHOUSE_DB:  wDB.save();  
                break;
                case PURCHASE_DB:   pDB.save();
                break;
                case ALL_DB:        aDB.save();
                                    sDB.save();
                                    wDB.save();
                                    pDB.save();
                break;
        }
        } catch (IOException ex) {
            Logger.getLogger(DBControler.class.getName()).log(Level.SEVERE, null, ex);
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
     * @return List Warehouse
     */ 
    public static List<Warehouse> getWarehouses() {
        if (instance == null)
            getInstance();
        
        return instance.wDB.getWarehouses();
    }
    
    /**
     * @return StockItem
     */ 
    public static StockItem getStockItemByName(String name) {
        if (instance == null)
            getInstance();
        
        return instance.getStockItemDB().getStockItems().get(name);
    }
}
