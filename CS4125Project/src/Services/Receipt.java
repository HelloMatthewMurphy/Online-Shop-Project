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
public class Receipt implements ReceiptPlan{
    
    private String AccountUsername;
    private String AccountEmail;
    private String paymentDetails;
    private String delivery;
    private ShoppingBasket purchases;
    
    public void Username(String username){
        this.AccountUsername = username;
    }
    
    public void Email(String email){
        this.AccountEmail = email;
    }
    
    public void PaymentDetails(String paymentDetails){
        this.paymentDetails = paymentDetails;
    }
    
    public void DeliveryMethod(String delivery){
        //this.delivery = delivery.getType();
    }
    
    public void Purchases(String purchases){
        //this.purchases = purchases;
    } 
}
