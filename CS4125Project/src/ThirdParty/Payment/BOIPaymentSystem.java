package ThirdParty.Payment;

import javax.swing.JOptionPane;

public class BOIPaymentSystem implements IPaymentSystem {
    
    public void processPayment(String paymentSystem){
        JOptionPane.showMessageDialog(null ,"Using Bank Of Ireland gateway for " +  paymentSystem);
    }
}