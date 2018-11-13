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
    
    private Account userAccount;
    private Delivery delivery;
    private ShoppingBasket purchases;
    
    public void User(Account account){
        this.userAccount = account;
    }
    
    public void DeliveryMethod(Delivery delivery){
        this.delivery = delivery;
    }
    
    public void Purchases(ShoppingBasket purchases){
        this.purchases = purchases;
    } 
}
