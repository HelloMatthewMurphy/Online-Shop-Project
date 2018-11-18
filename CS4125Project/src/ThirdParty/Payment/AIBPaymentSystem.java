package ThirdParty.Payment;

import Services.Shop;
import javax.swing.JOptionPane;

/**
 *
 * @author Brian
 */
public class AIBPaymentSystem implements IPaymentSystem {
    
    @Override
    public void processPayment(String paymentSystem) {
        Shop.getInstance().getAccount().getPaymentType().paymentInfo = "Using Allied Irish Bank gateway for " + paymentSystem;
        JOptionPane.showMessageDialog(null,"Using Allied Irish Bank gateway for " + paymentSystem);
    }
}