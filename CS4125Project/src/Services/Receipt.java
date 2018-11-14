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
    
    private String accountUsername;
    private String accountEmail;
    private String paymentDetails;
    private String purchases;
    
    public void SetUsername(String username){
        this.accountUsername = username;
    }
    
    public void SetEmail(String email){
        this.accountEmail = email;
    }
    
    public void SetPaymentDetails(String paymentDetails){
        this.paymentDetails = paymentDetails;
    }
    
    public void SetPurchases(String purchases){
        this.purchases = purchases;
    }
    
    public String GetUsername(){
        return this.accountUsername;
    } 
    
    public String GetEmail(){
        return this.accountEmail;
    } 
    
    public String GetPaymentDetails(){
        return this.paymentDetails;
    } 
    
    public String GetPurchases(){
        return this.purchases;
    } 

}
