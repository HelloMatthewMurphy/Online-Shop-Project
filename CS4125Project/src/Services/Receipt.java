package Services;

/**
 *
 * @author Jack
 */
public class Receipt implements ReceiptPlan{
    
    private String accountUsername;
    private String accountEmail;
    private String paymentDetails;
    private String purchases;
    
    public void setUsername(String username){
        this.accountUsername = username;
    }
    
    public void setEmail(String email){
        this.accountEmail = email;
    }
    
    public void setPaymentDetails(String paymentDetails){
        this.paymentDetails = paymentDetails;
    }
    
    public void setPurchases(String purchases){
        this.purchases = purchases;
    }
    
    public String getUsername(){
        return this.accountUsername;
    } 
    
    public String getEmail(){
        return this.accountEmail;
    } 
    
    public String getPaymentDetails(){
        return this.paymentDetails;
    } 
    
    public String getPurchases(){
        return this.purchases;
    } 

}
