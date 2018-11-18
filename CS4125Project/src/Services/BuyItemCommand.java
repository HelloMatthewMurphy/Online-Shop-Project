package Services;
import Stock.StockItem;

/**
 * A Concrete Command for the command pattern. A command that creates a purchase that the user wants and adds it to the basket.
 * @author Matthew
 */
public class BuyItemCommand implements Command{

    private final Purchase purchase;
    private final ShoppingBasket shoppingBasket;

    /**
     * A constructor for BuyItemCommand
     * @param stockItem item that will be bought
     * @param quantity amount to buy
     * @param username username of user
     * @param currency the currency they are using
     */
    public BuyItemCommand(StockItem stockItem, int quantity, String username, Money.Currency currency){
        purchase = new Purchase(stockItem, quantity, username, currency);
        this.shoppingBasket = ShoppingBasket.getInstance();
    }
    
    @Override
    public void execute() {
        shoppingBasket.addToBasket(purchase);
    }

    @Override
    public void undo() {
        shoppingBasket.removeFromBasket(purchase);
    }
    
}
