/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ThirdParty.Delivery;

/**
 *
 * @author Brian
 */
public class BasicDelivery implements Delivery {
    
    
    public BasicDelivery(){
        
    }

    @Override
    public String getType() {
       return "Basic Delivery";
    }

    @Override
    public double getPrice() {
       return 20.00;
    }
    
    @Override
    public int getDays() {
        return 5;
    }
}
