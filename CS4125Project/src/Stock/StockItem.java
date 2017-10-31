/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Stock;
//Add javadocs later
/**
 *
 * @author Jack
 */
public class StockItem {
    private String name;
    private double price;
    private String category;
    private String description;
    
    public StockItem(String name, double price){
        this.name = name;
        this.price = price;
        this.category = "";
        this.description = "";
    }
    
    public StockItem(String name, double price, String category, String description){
        this.name = name;
        this.price = price;
        this.category = category;
        this.description = description;
    }
    
    public String getName(){
    return this.name;
    }
    
    public double getPrice(){
    return this.price;
    }
    
    public String getCategory(){
    return this.category;
    }
    
    public String getDescription(){
    return this.description;
    }
    
    public void setPrice(double price){
        this.price = price;
    }
}
