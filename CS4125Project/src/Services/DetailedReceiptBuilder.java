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
        ArrayList<Purchase>purchases = ShoppingBasket.getInstance().getBasketContents();
        String itemList = "You have " + purchases.size() + " purchases.\n";
        float total = 0;
        for (Purchase p : purchases) {
            itemList += "Item Name: " + p.getItem().getName() + "           ";
            itemList += "Quantity: " + p.getQuantity() + "           ";
            itemList += "Price: " + (p.getCostString()) + "\n";
            total += p.getMoney().getAmount();
        }
        
        Money totalMoney = new Money(purchases.get(0).getMoney().getCurrency(), total);
        
        itemList += "Total: " + totalMoney;
                
        receipt.setPurchases(itemList);
    } 
  
    /**
     *
     * @return receipt
     */
    public Receipt getReceipt(){
        return this.receipt;
    } 
}
