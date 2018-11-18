package Services;
import User.Account;
/**
 *
 * @author Jack
 */
public class PrivateReceiptBuilder implements ReceiptBuilder{
    
    private Receipt receipt;
    
    public PrivateReceiptBuilder(){
        this.receipt = new Receipt();
    }
    
    public void buildusername(){
        receipt.setUsername(Shop.getInstance().getAccount().getUsername());
    }
    
    public void buildEmail(){
        receipt.setEmail("User email has been hidden due to customer preference");
    }
    
    public void buildPaymentDetails(){
        receipt.setPaymentDetails(Shop.getInstance().getAccount().getPaymentType().getPaymentInfo());
    }
  
    public void buildPurchases(){
        receipt.setPurchases("The contents of this purchase have been hidden due to customer preference.");
    } 
  
    public Receipt getReceipt(){
        return this.receipt;
    } 
}
