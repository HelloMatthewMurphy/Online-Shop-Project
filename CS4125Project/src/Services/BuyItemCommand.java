/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;
import Stock.StockItem;

/**
 *
 * @author hello
 */
public class BuyItemCommand implements Command{

    private final Purchase purchase;
    private final ShoppingBasket shoppingBasket;
    
    // Concrete Command
    public BuyItemCommand(StockItem stockItem, int quantity, String username, Money.Currency currency){
        purchase = new Purchase(stockItem, quantity, username, currency);
        this.shoppingBasket = ShoppingBasket.GetInstance();
    }
    
    @Override
    public void execute() {
        shoppingBasket.AddToBasket(purchase);
    }

    @Override
    public void Undo() {
        shoppingBasket.RemoveFromBasket(purchase);
    }
    
}
