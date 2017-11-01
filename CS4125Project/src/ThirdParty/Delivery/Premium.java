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
public class Premium extends DeliveryDecorator {
    
    
    public Premium(Delivery delivery){
        super(delivery);
    }
    
    public double getPrice(){
        return tempDelivery.getPrice()+10;
    }
    
    public int getDays(){
        return tempDelivery.getDays()-2;
    }
}
