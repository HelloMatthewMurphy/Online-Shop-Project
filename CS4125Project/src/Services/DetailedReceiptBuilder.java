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
public class DetailedReceiptBuilder implements ReceiptBuilder{
    private Receipt receipt;
    
    public DetailedReceiptBuilder(){
        this.receipt = new Receipt();
    }
    
    public void buildusername(){
        receipt.SetUsername(Shop.getInstance().getAccount().getUsername());
    }
    
    public void buildEmail(){
        receipt.SetEmail(Shop.getInstance().getAccount().getEmail());
    }
    
    public void buildPaymentDetails(){
        receipt.SetPaymentDetails(Shop.getInstance().getAccount().getPaymentType().getPaymentInfo());
    }
    
    public void bulidDelivery(){
        receipt.SetDeliveryMethod(Shop.getInstance().getAccount().getLocation());
    } 
  
    public void buildPurchases(){
        ArrayList<Purchase> basket = ShoppingBasket.GetInstance().GetBasketContents();
        String purchase = "You have " + basket.size() + " items.\n";
        
        for(int i = 0; i < basket.size(); i++){
            purchase += (basket.get(i).getItem().getName()) + "\n";
        }
        
        receipt.SetPurchases(purchase);
    } 
  
    public Receipt getReceipt(){
        return this.receipt;
    } 
}
