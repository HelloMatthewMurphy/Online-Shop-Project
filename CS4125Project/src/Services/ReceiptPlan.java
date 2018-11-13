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
    public void Username(String account);
    public void Email(String email);
    public void PaymentDetails(String paymentDetails);
    public void DeliveryMethod(String delivery);
    public void Purchases(String purchases);
    
}
