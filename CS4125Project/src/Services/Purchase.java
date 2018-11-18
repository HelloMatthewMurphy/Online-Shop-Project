package Services;

import Stock.StockItem;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;

/**
 * Creates a receipt of purchases made.
 * @author Matthew
 */
public class Purchase {
    
    private StockItem item;
    private int quantity;
    private double discount = 1;
    private String username;
    private GregorianCalendar date;
    private Money money;
    
    /**
    * A constructor that initializes purchase values
    * @param  item a StockItem object
    * @param quantity The amount of StockItem being bought
    * @param username The user that bought the item
    * @param currency The currency of the purchase
    */
    public Purchase(StockItem item, int quantity, String username, Money.Currency currency){
        this(item, quantity,username, currency, new GregorianCalendar());
    }
    
    /**
    * Another constructor that initializes purchase values
    * @param  item A StockItem object
    * @param quantity The amount of StockItem being bought
    * @param username The user that bought the item
    * @param currency the currency to make purchase in
    * @param date The date of purchase
    * 
    */
    public Purchase(StockItem item, int quantity,String username, Money.Currency currency, GregorianCalendar date){
        this.item = item;
        this.quantity = quantity;
        this.username = username;
        this.date = date;
        
        double amountEur = getCost();
        this.money = new Money(currency, currency.getFromEuroRate() * amountEur);
    }
    
    /**
    * A method for making purchases
    * @param  address  the address of the purchase
    * @return true
    * 
    */

    public boolean validatePurchase(String address){
        if (Shop.getInstance().getAccount().getPaymentType() == null) {
            JOptionPane.showMessageDialog(null, "Error - There is no payment method set for this account");
            return false;
        }
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
    
    /**
     * @return the cost of this purchase
     */
    public double getCost() {
        return quantity * item.getPrice() * discount;
    }
    
    /**
     * @return the cost of the purchase in the currency used, with the
     * currency's symbol in front of it
     */
    public String getCostString() {
        return money.toString();
    }
    
    /**
    * @return the money of the purchase
    */
    public Money getMoney() {
        return money;
    }
}
