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

    private StockItem stockItem;
    private ShoppingBasket shoppingBasket;
    
    // Concrete Command
    public BuyItemCommand(StockItem stockItem, ShoppingBasket shoppingBasket){
        this.stockItem = stockItem;
        this.shoppingBasket = shoppingBasket;
    }
    
    @Override
    public void execute() {
        shoppingBasket.AddToBasket(stockItem);
        System.out.println("You just bought: " + stockItem.getName());
    }

    @Override
    public void Undo() {
        shoppingBasket.RemoveFromBasket(stockItem);
        System.out.println("You just undone: " + stockItem.getName());
    }
    
}
