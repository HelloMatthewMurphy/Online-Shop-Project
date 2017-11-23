package Services;

import Stock.StockItem;
import ThirdParty.*;
import ThirdParty.Delivery.BasicDelivery;
import ThirdParty.Delivery.Delivery;
import ThirdParty.Delivery.MoneySaver;
import ThirdParty.Delivery.Premium;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 *
 * @author Matthew Murphy
 */
public class Purchase {
    
    private StockItem item;
    private int quantity;
    private double discount = 1;
    private String username;
    private GregorianCalendar date;
    
    public Purchase(StockItem item, int quantity, String username){
        this(item, quantity,username, new GregorianCalendar());
    }
    
    public Purchase(StockItem item, int quantity,String username, GregorianCalendar date){
        this.item = item;
        this.quantity = quantity;
        this.username = username;
        this.date = date;
    }
    
    public boolean makePurchase(String address){
        //I took everything to put in ui now there is nothing left but a lonely return - Matthew
        return true;
    }
    
    public StockItem getItem()
    {
        return item;
    }
    
    public int getQuantity()
    {
        return quantity;
    }
    
    public double getDiscount()
    {
        return discount;
    }
    
    public String getUsername(){
        return username;
    }
    public GregorianCalendar getDate()
    {
        return date;
    }
}
