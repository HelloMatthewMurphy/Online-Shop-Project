package ThirdParty.Payment;

public abstract class Payment {
    
    protected String username;
    protected String cardNumber;
    protected String billingAddress;
    protected String paymentInfo;
    
    public IPaymentSystem _IPaymentSystem;
    
    public abstract void MakePayment();
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }
    
    public void setBillingAddress(String address) {
        this.billingAddress = address;
    }
    
    public void setPaymentInfo(String paymentInfo){
        this.paymentInfo = paymentInfo;
    }
    
    public String getUsername() {
        return this.username;
    }
    
    public String getCardNumber() {
        return this.cardNumber;
    }
    
    public String getBillingAddress() {
        return this.billingAddress;
    }
    
    public String getPaymentInfo() {
        return this.paymentInfo;
    }
    
}