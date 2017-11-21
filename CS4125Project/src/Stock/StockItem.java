/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Stock;
//Add javadocs later
/**
 * A stock Item holds all the information of each item a customer can purchase
 * @author Jack
 * 
 */
public class StockItem {
    private String name;
    private double price;
    private String category;
    private String description;
    
/**
 * A constructor that sets values for the Stock Item
 * @param name This is the name of each Stock Item
 * @param price Price of Stock Item
 * 
 */
    public StockItem(String name, double price){
        this.name = name;
        this.price = price;
        this.category = "";
        this.description = "";
    }
    
/**
 * Another constructor that sets values for the Stock Item
 * @param name This is the name of each Stock Item
 * @param price Price of Stock Item
 * @param category A category that the Stock Item is set to
 * @param description A short description of the Stock Item
 * 
 */
    public StockItem(String name, double price, String category, String description){
        this.name = name;
        this.price = price;
        this.category = category;
        this.description = description;
    }
    
/**
 * 
 * @return name
 * 
 */
    public String getName(){
    return this.name;
    }

/**
 *
 * @return price
 * 
 */    
    public double getPrice(){
    return this.price;
    }

/**
 *
 * @return category
 * 
 */    
    public String getCategory(){
    return this.category;
    }
    
/**
 *
 * @return description
 * 
 */    
    public String getDescription(){
    return this.description;
    }
    
/**
 *
 * @param price Sets a new value for price
 * 
 */ 
    public void setPrice(double price){
        this.price = price;
    }
}
