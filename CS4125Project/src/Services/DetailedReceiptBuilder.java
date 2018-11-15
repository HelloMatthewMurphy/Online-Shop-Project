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
        receipt.setUsername(Shop.getInstance().getAccount().getUsername());
    }
    
    public void buildEmail(){
        receipt.setEmail(Shop.getInstance().getAccount().getEmail());
    }
    
    public void buildPaymentDetails(){
        receipt.setPaymentDetails(Shop.getInstance().getAccount().getPaymentType().getPaymentInfo());
    }
  
    public void buildPurchases(){ 
        ArrayList<Purchase>purchases = ShoppingBasket.GetInstance().GetBasketContents();
        String itemList = "You have " + purchases.size() + " purchases.\n";
        float total = 0;
        for (Purchase p : purchases) {
            itemList += "Item Name: " + p.getItem().getName() + "           ";
            itemList += "Quantity: " + p.getQuantity() + "           ";
            itemList += "Price: " + String.format("€%.2f", p.getItem().getPrice()) + "\n";
            total += p.getItem().getPrice() * p.getQuantity();
        }
        
        Money totalMoney = new Money(purchases.get(0).getMoney().getCurrency(), total);
        
        itemList += "Total: " + totalMoney;
                
        receipt.setPurchases(itemList);
    } 
  
    public Receipt getReceipt(){
        return this.receipt;
    } 
}
