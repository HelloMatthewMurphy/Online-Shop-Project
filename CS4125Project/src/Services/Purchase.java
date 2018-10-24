package Services;

import MenuUI.PaymentSetupUI;
import Stock.StockItem;
import ThirdParty.*;
import ThirdParty.Delivery.BasicDelivery;
import ThirdParty.Delivery.Delivery;
import ThirdParty.Delivery.MoneySaver;
import ThirdParty.Delivery.Premium;
import java.util.GregorianCalendar;
import java.util.Scanner;
import ThirdParty.Payment.*;

/**
 * Creates a receipt of purchases made.
 * @author Matthew Murphy
 */
public class Purchase {
    
    private StockItem item;
    private int quantity;
    private double discount = 1;
    private String username;
    private GregorianCalendar date;
    
    /**
    * A constructor that initializes purchase values
    * @param  item a StockItem object
    * @param quantity The amount of StockItem being bought
    * @param username The user that bought the item
    * 
    */
    public Purchase(StockItem item, int quantity, String username){
        this(item, quantity,username, new GregorianCalendar());
    }
    
    /**
    * Another constructor that initializes purchase values
    * @param  item A StockItem object
    * @param quantity The amount of StockItem being bought
    * @param username The user that bought the item
    * @param date The date of purchase
    * 
    */
    public Purchase(StockItem item, int quantity,String username, GregorianCalendar date){
        this.item = item;
        this.quantity = quantity;
        this.username = username;
        this.date = date;
    }
    
    /**
    * A method for making purchases
    * @param  address 
    * @return true
    * 
    */
    
    public boolean makePurchase(String address, Payment payment){
        //I took everything to put in ui now there is nothing left but a lonely return - Matthew
        System.out.println(address);
        if (payment == null) {
            PaymentSetupUI paymentMenu = new PaymentSetupUI(payment);
            paymentMenu.run();       
        }
        payment.MakePayment();
        return true;
    }
    
    /**
    * 
    * @return item
    * 
    */
    public StockItem getItem()
    {
        return item;
    }
    
    /**
    * 
    * @return quantity
    * 
    */
    public int getQuantity()
    {
        return quantity;
    }
    
    /**
    * 
    * @return discount
    * 
    */
    public double getDiscount()
    {
        return discount;
    }
    
    /**
    * 
    * @return username
    * 
    */
    public String getUsername(){
        return username;
    }
    
    /**
    * 
    * @return date
    * 
    */
    public GregorianCalendar getDate()
    {
        return date;
    }
}
