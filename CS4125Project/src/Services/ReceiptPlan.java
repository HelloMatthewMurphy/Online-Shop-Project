package Services;
/**
 *
 * @author Jack
 */
interface ReceiptPlan {
    public void setUsername(String account);
    public String getUsername();
    public void setEmail(String email);
    public String getEmail();
    public void setPaymentDetails(String paymentDetails);
    public String getPaymentDetails();
    public void setPurchases(String purchases);
    public String getPurchases();
    
}
