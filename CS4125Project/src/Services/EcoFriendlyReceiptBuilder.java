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
public class EcoFriendlyReceiptBuilder implements ReceiptBuilder{
        private Receipt receipt;
    
    public EcoFriendlyReceiptBuilder(){
        this.receipt = new Receipt();
    }
    
    public void buildusername(){
        receipt.SetUsername(Shop.getInstance().getAccount().getUsername());
    }
    
    public void buildEmail(){
        receipt.SetEmail("");
    }
    
    public void buildPaymentDetails(){
        receipt.SetPaymentDetails("");
    }
  
    public void buildPurchases(){
        ArrayList<Purchase>purchases = ShoppingBasket.GetInstance().GetBasketContents();
        String itemList = "You have " + purchases.size() + " items.\n";
        float total = 0;
        //Money.Currency currency = Purchase.
        for (Purchase p : purchases) {
            total += p.getItem().getPrice() * p.getQuantity();
        }
        
        Money totalMoney = new Money(Money.Currency.EUR, total);
        totalMoney.changeCurrency(purchases.get(0).getMoney().getCurrency());
        
        itemList += "Total: " + totalMoney;
                
        receipt.SetPurchases(itemList);
    } 
  
    public Receipt getReceipt(){
        return this.receipt;
    } 
}
