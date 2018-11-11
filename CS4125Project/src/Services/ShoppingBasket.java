/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Stock.StockItem;
import java.util.ArrayList;

/**
 *
 * @author Matthew
 */
public class ShoppingBasket {
    
    private ArrayList<Purchase> basket = new ArrayList<Purchase>();
    private static ShoppingBasket instance;
    
    // Receiver
    private ShoppingBasket(){
        
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
    
    public void RemoveFromBasket(StockItem item){
        basket.remove(item);
    }
    
    public void PrintOutShoppingBasket(){
        System.out.println("You have " + basket.size() + " items.");
        for(int i = 0; i < basket.size(); i++){
            System.out.println(basket.get(i).getItem().getName());
        }
    }
    
    public ArrayList<Purchase> GetBasketContents(){
        return basket;
    }
    
}
