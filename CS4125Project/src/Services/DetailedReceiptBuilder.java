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
  
    public void buildPurchases(){ 
        ArrayList<Purchase>purchases = ShoppingBasket.GetInstance().GetBasketContents();
        String totalCost = "";
        String itemList = "You have \" + basket.size() + \" items.\\n";
        float total = 0;
        //Money.Currency currency = Purchase.
        for (Purchase p : purchases) {
            itemList += "Item Name: " + p.getItem().getName() + "\t\t";
            itemList += "Quantity:  " + p.getQuantity() + "\t\t";
            itemList += "Price: " + String.format("€%.2f", p.getItem().getPrice()) + "\n";
            total += p.getItem().getPrice() * p.getQuantity();
        }
        itemList += "Total: " + total;
        
        receipt.SetPurchases(itemList);
    } 
  
    public Receipt getReceipt(){
        return this.receipt;
    } 
}
