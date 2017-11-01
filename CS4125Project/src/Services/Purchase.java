package Services;

import Stock.StockItem;
import ThirdParty.*;
import ThirdParty.Delivery.BasicDelivery;
import ThirdParty.Delivery.Delivery;
import ThirdParty.Delivery.MoneySaver;
import ThirdParty.Delivery.Premium;
import java.util.Scanner;

/**
 *
 * @author Matthew Murphy
 */
public class Purchase {
    
    private StockItem item;
    private int quantity;
    
    public Purchase(StockItem item, int quantity){
        this.item = item;
        this.quantity = quantity;
    }
    
    public boolean makePurchase(String address){
        CreditCardCo credit = new CreditCardCo();
        Delivery delivery = null;
        Scanner s = new Scanner(System.in);
        System.out.println("What type of Delivery would you like?:");
        boolean valid = false;
        while(valid == false){
            System.out.println("S)low");
            System.out.println("R)egular");
            System.out.println("P)remium");
            System.out.println("\n");

            String type = s.nextLine();
            switch (type) {
                case "S":
                    delivery = new MoneySaver(new BasicDelivery());
                    valid = true;
                    break;
                case "R":
                    delivery = new BasicDelivery();
                    valid = true;
                    break;
                case "P":
                    delivery = new Premium(new BasicDelivery());
                    valid = true;
                    break;
                default:
                    break;
            }
            System.out.println(delivery.getPrice());
            System.out.println(delivery.getDays());
        }
        
        return true;
    }
    
}
