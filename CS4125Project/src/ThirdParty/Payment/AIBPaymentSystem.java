package ThirdParty.Payment;

public class AIBPaymentSystem implements IPaymentSystem {
    
    public void processPayment(String paymentSystem) {
        System.out.println("Using Allied Irish Bank gateway for " + paymentSystem);
    }
}