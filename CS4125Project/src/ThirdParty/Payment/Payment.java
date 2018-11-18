package ThirdParty.Payment;

/**
 *
 * @author Brain
 */
public abstract class Payment {
    
    protected String username;
    protected String cardNumber;
    protected String billingAddress;
    protected String paymentInfo;
    public IPaymentSystem _IPaymentSystem;
    
    /**
     * Makes payment.
     */
    public abstract void MakePayment();
    
    /**
     * 
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }
    
    /**
     *
     * @param cardNumber the card number to set
     */
    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }
    
    /**
     *
     * @param address the address to set
     */
    public void setBillingAddress(String address) {
        this.billingAddress = address;
    }
    
    /**
     *
     * @param paymentInfo the payment info to set
     */
    public void setPaymentInfo(String paymentInfo){
        this.paymentInfo = paymentInfo;
    }
    
    /**
     *
     * @return username
     */
    public String getUsername() {
        return this.username;
    }
    
    /**
     *
     * @return cardNumber
     */
    public String getCardNumber() {
        return this.cardNumber;
    }
    
    /**
     *
     * @return billingAddress
     */
    public String getBillingAddress() {
        return this.billingAddress;
    }
    
    /**
     *
     * @return paymentInfo
     */
    public String getPaymentInfo() {
        return this.paymentInfo;
    }
    
}