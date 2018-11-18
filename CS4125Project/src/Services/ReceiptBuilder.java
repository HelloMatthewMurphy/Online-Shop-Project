package Services;

/**
 *
 * @author Jack
 */
interface ReceiptBuilder {

    public void buildusername();
    
    public void buildEmail();
    
    public void buildPaymentDetails();
  
    public void buildPurchases(); 
  
    public Receipt getReceipt(); 
}
