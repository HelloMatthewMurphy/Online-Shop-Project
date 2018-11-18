/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;
import User.Customer;
import java.util.List;
import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import ThirdParty.Payment.*;

/**
 *
 * @author Matthew Murphy
 */
public class ShopTest {
    
    public ShopTest() {
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
        System.out.println("getInstance");
        boolean workedFine = false;
        Shop expResult = Shop.getInstance();
        
        if(expResult != null)
            workedFine = true;
        
        assert(workedFine);
    }

    /**
     * Test of setAccount method, of class Shop.
     */
    @Test
    public void testSetAccount() {
        System.out.println("setAccount");
        boolean workedFine = false;
        Customer account = new Customer("Matt", "Pass", "Email@email.email");;
        Shop instance = Shop.getInstance();
        instance.setAccount(account);
        if(instance.getAccount() != null)
            workedFine = true;
        
        assert(workedFine);
    }
    
    /**
     * Test of getSortedStock method, of class Shop.
     */
    @Test
    public void testGetSortedStock() {
        System.out.println("getSortedStock");
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
     * Test of setPaymentType method, of class Shop.
     */
    @Test
    public void testCreditCardDetails(){
        boolean workedFine = false;
        System.out.println("CreditCardDetails");
        Customer account = new Customer("Matt", "Pass", "Email@email.email");
        Payment paymentType = new NetBankingPayment();
        paymentType._IPaymentSystem = new BOIPaymentSystem();
        Shop instance = Shop.getInstance();
        instance.setAccount(account);
        Shop.getInstance().getAccount().setPaymentType(paymentType);
        
        if(Shop.getInstance().getAccount().getPaymentType() != null){
            workedFine = true;
        }
        
        assert(workedFine);
    }
    
        /**
     * Test of makeReceipt method, of class ReceiptDirector.
     */
    @Test
    public void testCreateReceipt(){
        boolean workedFine = false;
        System.out.println("makeReceipt");
        Customer account = new Customer("Matt", "Pass", "Email@email.email");
        Payment paymentType = new NetBankingPayment();
        paymentType._IPaymentSystem = new BOIPaymentSystem();
        Shop instance = Shop.getInstance();
        instance.setAccount(account);
        Shop.getInstance().getAccount().setPaymentType(paymentType);
        
        PrivateReceiptBuilder privateReceipt = new PrivateReceiptBuilder();
        ReceiptDirector.GetInstance().makeReceipt(privateReceipt);
        
        if(privateReceipt.getReceipt() != null){
            workedFine = true;
        }
        
        assert(workedFine);
    }
    
}
