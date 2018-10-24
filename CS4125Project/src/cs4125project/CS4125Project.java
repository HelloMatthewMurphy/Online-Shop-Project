/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs4125project;

import Database.DBControler;
import MenuUI.MainMenuUI;
import Services.*;
import Stock.StockItem;
import MenuUI.PaymentSetupUI;
import ThirdParty.Payment.AIBPaymentSystem;
import ThirdParty.Payment.BOIPaymentSystem;
import ThirdParty.Payment.CardPayment;
import ThirdParty.Payment.Payment;
import java.io.IOException;

/**
 *
 * @author Matthew Murphy
 */
public class CS4125Project {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, InterruptedException {
        
        // Initialize and load DBs
        Payment pay = new CardPayment();
        // pay.setBillingAddress("Hello");
        //System.out.println(pay.getBillingAddress());
        pay._IPaymentSystem = new AIBPaymentSystem();
        pay.MakePayment();
        pay._IPaymentSystem = new BOIPaymentSystem();
        pay.MakePayment();
        
        
        Payment payment;
        payment = null;
        
        PaymentSetupUI paymentMenu = new PaymentSetupUI(payment);
        paymentMenu.run();       
        
        if (payment != null) {
            payment.MakePayment();
        }        
        DBControler.getInstance().load(DBControler.ALL_DB);
        // TODO code application logic here
        MainMenuUI menu = new MainMenuUI();
        menu.run();
    }
}
