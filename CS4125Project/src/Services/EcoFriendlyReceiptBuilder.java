/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import java.util.ArrayList;

/**
 *
 * @author Jack
 */
public class EcoFriendlyReceiptBuilder {
        private Receipt receipt;
    
    public EcoFriendlyReceiptBuilder(){
        this.receipt = new Receipt();
    }
    
    public void buildusername(){
        receipt.Username(Shop.getInstance().getAccount().getUsername());
    }
    
    public void buildEmail(){
        receipt.Email("");
    }
    
    //Need brians payment method to add.
    public void buildPurchaseDetails(){
        receipt.PaymentDetails("");
    }
    
    public void bulidDelivery(){
        receipt.DeliveryMethod(Shop.getInstance().getAccount().getLocation());
    } 
  
    public void buildPurchases(){
        ArrayList<Purchase> basket = new ArrayList<Purchase>();
        basket = ShoppingBasket.GetInstance().GetBasketContents();
        String purchase = "You have " + basket.size() + " items.\n";
 
        receipt.Purchases(purchase);
    } 
  
    public Receipt getReceipt(){
        return this.receipt;
    } 
}
