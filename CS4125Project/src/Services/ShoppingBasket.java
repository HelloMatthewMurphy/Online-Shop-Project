/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import java.util.ArrayList;

/**
 *
 * @author Matthew
 */
public class ShoppingBasket {
    
    private final ArrayList<Purchase> basket;
    private static ShoppingBasket instance;
    
    // Receiver
    private ShoppingBasket(){
        this.basket = new ArrayList<>();
    }
    
    public static ShoppingBasket GetInstance(){
        if(instance == null)
            instance = new ShoppingBasket();
        return instance;
    }
    
    public void AddToBasket(Purchase item){
        basket.add(item);
    }
    
    public void ClearBasket(){
        basket.clear();
    }
    
    public void RemoveFromBasket(Purchase item){
        basket.remove(item);
    }
    
    public ArrayList<Purchase> GetBasketContents(){
        return basket;
    }
    
}
