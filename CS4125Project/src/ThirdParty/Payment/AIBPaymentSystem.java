package ThirdParty.Payment;

import Services.Shop;
import javax.swing.JOptionPane;

public class AIBPaymentSystem implements IPaymentSystem {
    
    public void processPayment(String paymentSystem) {
        Shop.getInstance().getAccount().getPaymentType().paymentInfo = "Using Allied Irish Bank gateway for " + paymentSystem;
        JOptionPane.showMessageDialog(null,"Using Allied Irish Bank gateway for " + paymentSystem);
    }
}