package Database;

import Storage.Warehouse;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Matthew Murphy
 */
public class DBControler {
    
    public static final int ACCOUNT_DB = 0;
    public static final int STCOKITEM_DB = 1;
    public static final int WAREHOUSE_DB = 2;
    public static final int ALL_DB = 3;
    
    private static DBControler instance;
    private AccountDB aDB;
    private StockItemDB sDB;
    private WarehouseDB wDB;
    
    private DBControler(){
        aDB = new AccountDB();
        sDB = new StockItemDB();
        wDB = new WarehouseDB();
        
        aDB.setFilename("RegisteredUsers.csv");
        sDB.setFilename("stockiteminfo.csv");
        wDB.setFilename("warehouseinfo.csv");
        
        try {
            aDB.load();
            sDB.load();
            wDB.load();
        } catch (IOException ex) {
            Logger.getLogger(DBControler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static DBControler getInstance(){
        if(instance == null)
            instance = new DBControler();
        return instance;
    }
    
    public void load(int loading){
        try {
            switch (loading){
                case ACCOUNT_DB:    aDB.load();  
                break;
                case STCOKITEM_DB:  sDB.load();  
                break;
                case WAREHOUSE_DB:  wDB.load();  
                break;
                case ALL_DB:        aDB.load();
                                    sDB.load();
                                    wDB.load();
                break;
        }
        } catch (IOException ex) {
            Logger.getLogger(DBControler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void save(int saving){
        try {
            switch (saving){
                case ACCOUNT_DB:    aDB.save();  
                break;
                case STCOKITEM_DB:  sDB.save();  
                break;
                case WAREHOUSE_DB:  wDB.save();  
                break;
                case ALL_DB:        aDB.save();
                                    sDB.save();
                                    wDB.save();
                break;
        }
        } catch (IOException ex) {
            Logger.getLogger(DBControler.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Saved to a DB");
    }
    
    public AccountDB getAccountDB(){
        return aDB;
    }
    
    public StockItemDB getStockItemDB(){
        return sDB;
    }
    
    public WarehouseDB getWarehouseDB(){
        return wDB;
    }
}
