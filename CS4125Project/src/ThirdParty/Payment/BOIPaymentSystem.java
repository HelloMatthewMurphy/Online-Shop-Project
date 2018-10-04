package ThirdParty.Payment;

public class BOIPaymentSystem implements IPaymentSystem {
    
    public void processPayment(String paymentSystem){
        System.out.println("Using Bank Of Ireland gateway for " +  paymentSystem);
    }
}