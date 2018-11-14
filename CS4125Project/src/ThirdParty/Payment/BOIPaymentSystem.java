package ThirdParty.Payment;

import Services.Shop;
import javax.swing.JOptionPane;

public class BOIPaymentSystem implements IPaymentSystem {
    
    public void processPayment(String paymentSystem){
        Shop.getInstance().getAccount().getPaymentType().paymentInfo = "Using Bank Of Ireland gateway for " +  paymentSystem;
        JOptionPane.showMessageDialog(null ,"Using Bank Of Ireland gateway for " +  paymentSystem);
    }
}