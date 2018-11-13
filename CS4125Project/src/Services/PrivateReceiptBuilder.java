/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;
import User.Account;
/**
 *
 * @author Jack
 */
public class PrivateReceiptBuilder implements ReceiptBuilder{
    
    private Receipt receipt;
    
    public PrivateReceiptBuilder(){
        this.receipt = new Receipt();
    }
    
    public void buildusername(){
        receipt.Username(Shop.getInstance().getAccount().getUsername());
    }
    
    public void buildEmail(){
        receipt.Email("User email has been hidden due to customer preference");
    }
    
    //Need brians payment method to add.
    public void buildPaymentDetails(){
        //receipt.PaymentDetails(Shop.getInstance().getAccount());
    }
    
     public void bulidDelivery(){
        receipt.DeliveryMethod(Shop.getInstance().getAccount().getLocation());
    } 
  
    public void buildPurchases(){
        receipt.Purchases("The contents of this purchase have been hidden due to customer preference.");
    } 
  
    public Receipt getReceipt(){
        return this.receipt;
    } 
}
