/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;
import Stock.StockItem;
import Services.Purchase;

/**
 *
 * @author hello
 */
public class BuyItemCommand implements Command{

    private StockItem stockItem;
    private int quantity;
    private String username;
    private ShoppingBasket shoppingBasket;
    
    // Concrete Command
    public BuyItemCommand(StockItem stockItem, int quantity, String username){
        this.stockItem = stockItem;
        this.quantity = quantity;
        this.username =  username;
        this.shoppingBasket = ShoppingBasket.GetInstance();
    }
    
    @Override
    public void execute() {
        shoppingBasket.AddToBasket(new Purchase(stockItem, quantity, username));
        System.out.println("You just bought: " + stockItem.getName());
    }

    @Override
    public void Undo() {
        shoppingBasket.RemoveFromBasket(stockItem);
        System.out.println("You just undone: " + stockItem.getName());
    }
    
}
