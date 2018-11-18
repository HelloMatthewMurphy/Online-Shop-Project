/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;
import Database.DBControler;
import Services.Money.Currency;
import Stock.StockItem;
import User.Customer;
import java.util.List;
import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import ThirdParty.Payment.*;
import static junit.framework.Assert.assertNotNull;

/**
 *
 * @author Matthew Murphy
 */
public class ShopTest {
    
    public ShopTest() {
        /* Load CSV files when creating a ShopTest instance */
        DBControler.getInstance().load(DBControler.ALL_DB);
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getInstance method, of class Shop.
     */
    @Test
    public void testGetInstance() {
        Shop expResult = Shop.getInstance();
        
        assertNotNull(expResult);
    }

    /**
     * Test of setAccount method, of class Shop.
     */
    @Test
    public void testSetAccount() {
        Customer account = new Customer("Matt", "Pass", "Email@email.email");;
        Shop instance = Shop.getInstance();
        instance.setAccount(account);
        
        assertNotNull(instance.getAccount());
    }
    
    /**
     * Test of getSortedStock method, of class Shop.
     */
    @Test
    public void testGetSortedStock() {
        Shop instance = Shop.getInstance();
        List<Map.Entry<String, Integer>> result = instance.getSortedStock(Shop.SortOrder.NAME_DESC);
        boolean workedFine = true;
        String lastName = "";
        for(int i = 0; i < result.size() && workedFine; i++){
            if(result.get(i).getKey().compareTo(lastName) < 0)
                workedFine = false;
        }
        assert(workedFine);
    }
    
    /**
     * Test of returnItem method, of class Shop.
     */
    @Test
    public void testReturnItem() {
        StockItem item = DBControler.getInstance().getStockItemDB().getStockItemByName("yeezy");
        assertNotNull(item);
        Shop instance = Shop.getInstance();
        instance.returnItem(item, 1, Currency.EUR);
    }

    /**
     * Test of makePurchase method, of class Shop.
     */
    @Test   
    public void testMakePurchase() {
        StockItem item = DBControler.getInstance().getStockItemDB().getStockItemByName("yeezy");
        assertNotNull(item);
        int quantity = 1;
        Shop instance = Shop.getInstance();
        instance.setAccount(new Customer("Brian", "test", "testing"));
        instance.makePurchase(item, quantity, "Brian", Currency.EUR);
    }
    
        /**
     * Test of setPaymentType method, of class Shop.
     */
    @Test
    public void testCreditCardDetails(){
        Customer account = new Customer("Matt", "Pass", "Email@email.email");
        Payment paymentType = new NetBankingPayment();
        paymentType._IPaymentSystem = new BOIPaymentSystem();
        Shop instance = Shop.getInstance();
        instance.setAccount(account);
        Shop.getInstance().getAccount().setPaymentType(paymentType);
        
        assertNotNull(Shop.getInstance().getAccount().getPaymentType());
    }
    
        /**
     * Test of makeReceipt method, of class ReceiptDirector.
     */
    @Test
    public void testCreateReceipt(){
        Customer account = new Customer("Matt", "Pass", "Email@email.email");
        Payment paymentType = new NetBankingPayment();
        paymentType._IPaymentSystem = new BOIPaymentSystem();
        Shop instance = Shop.getInstance();
        instance.setAccount(account);
        Shop.getInstance().getAccount().setPaymentType(paymentType);
        
        PrivateReceiptBuilder privateReceipt = new PrivateReceiptBuilder();
        ReceiptDirector.GetInstance().makeReceipt(privateReceipt);
        
        assertNotNull(privateReceipt.getReceipt());
    }
    
}
