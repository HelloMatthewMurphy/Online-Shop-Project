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
 * @author hello
 */
public class ShoppingBasket {
    
    private ArrayList<StockItem> basket = new ArrayList<StockItem>();
    
    // Receiver
    public ShoppingBasket(){
        
    }
    
    public void AddToBasket(StockItem item){
        basket.add(item);
    }
    
    public void RemoveFromBasket(StockItem item){
        basket.remove(item);
    }
    
    public void PrintOutShoppingBasket(){
        for(int i = 0; i < basket.size(); i--){
            System.out.println(basket.get(i).getName() + " + ");
        }
    }
    
}
