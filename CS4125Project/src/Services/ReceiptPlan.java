/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;
import User.Account;
import ThirdParty.Delivery.Delivery;
/**
 *
 * @author Jack
 */
interface ReceiptPlan {
    public void SetUsername(String account);
    public String GetUsername();
    public void SetEmail(String email);
    public String GetEmail();
    public void SetPaymentDetails(String paymentDetails);
    public String GetPaymentDetails();
    public void SetPurchases(String purchases);
    public String GetPurchases();
    
}
