package ThirdParty.Payment;

public abstract class Payment {
    
    public IPaymentSystem _IPaymentSystem;
    public abstract void MakePayment();
}