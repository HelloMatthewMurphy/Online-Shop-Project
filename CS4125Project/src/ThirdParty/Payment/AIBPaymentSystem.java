package ThirdParty.Payment;

import javax.swing.JOptionPane;

public class AIBPaymentSystem implements IPaymentSystem {
    
    public void processPayment(String paymentSystem) {
        JOptionPane.showMessageDialog(null,"Using Allied Irish Bank gateway for " + paymentSystem);
    }
}