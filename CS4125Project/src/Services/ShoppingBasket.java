package Services;

import java.util.ArrayList;

/**
 * Is Receiver for command pattern. Hold all the purchases so they can be removed before checking out and buying them all.
 * @author Matthew
 */
public class ShoppingBasket {
    
    private final ArrayList<Purchase> basket;
    private static ShoppingBasket instance;
    
    /**
    * A constructor for the shopping basket
    */
    private ShoppingBasket(){
        this.basket = new ArrayList<>();
    }
    
    /** 
     * Returns an instance of the ShoppingBasket and creates one if none exist
     * @return instance
     */
    public static ShoppingBasket getInstance(){
        if(instance == null)
            instance = new ShoppingBasket();
        return instance;
    }
    
    /**
     * Adds a Purchase to the basket
     * @param item the item to add
     */
    public void addToBasket(Purchase item){
        basket.add(item);
    }
    
    /**
     * Clears the basket
     */
    public void clearBasket(){
        basket.clear();
    }
    
    /**
     * Removes a Purchase to the basket
     * @param item the item to remove
     */
    public void removeFromBasket(Purchase item){
        basket.remove(item);
    }
    
    /**
     * Returns the basket
     * @return basket
     */
    public ArrayList<Purchase> getBasketContents(){
        return basket;
    }
    
}
