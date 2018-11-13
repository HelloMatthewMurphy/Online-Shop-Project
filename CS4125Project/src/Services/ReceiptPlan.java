/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;
import User.Account;
import ThirdParty.Payment.Payment;
import ThirdParty.Delivery.Delivery;
/**
 *
 * @author Jack
 */
interface ReceiptPlan {
    public void User(Account account);
    public void PaymentMethod(Payment payment);
    public void DeliveryMethod(Delivery delivery);
    public void Purchases(ShoppingBasket purchases);
    
}
