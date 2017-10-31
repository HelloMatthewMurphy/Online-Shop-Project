/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package User;

import Stock.StockItem;

/**
 *
 * @author Jack
 */
public class Supervisor extends Account{
    
    public Supervisor(String name, String password, String email){
        super(name, password, email);
    }
    
    public void buyStock(StockItem stock){
        
    }
    
    public void addDiscount(StockItem stock, double discount){
        
    }
    
    public String checkSales(){
        String result = "";
        return result;
    }
    
    public void setUpAutoReorder(StockItem stock){
        
    }
}
