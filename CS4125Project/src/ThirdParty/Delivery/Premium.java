/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ThirdParty.Delivery;

/**
 * Fastest but most expensive delivery method.
 * @author Brian
 */
public class Premium extends DeliveryDecorator {
    
    /**
     * 
     * @param delivery the delivery type
     */
    public Premium(Delivery delivery){
        super(delivery);
    }
    
    /**
     * 
     * @return  price
     */
    public double getPrice(){
        return tempDelivery.getPrice()+10;
    }
    
    /**
     * 
     * @return days
     */
    public int getDays(){
        return tempDelivery.getDays()-2;
    }
}
