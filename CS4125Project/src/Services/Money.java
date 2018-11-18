package Services;

/**
 *
 * @author Shane
 */
public class Money {
    
    /**
     *Currency enum
     */
    public enum Currency {
        EUR('€', 1), GBP('£', 1.15), USD('$', 0.88);
        
        Currency(char symbol, double toEuroRate) {
            this.symbol = symbol;
            this.toEuroRate = toEuroRate;
        }
        
        private final char symbol;
        private final double toEuroRate;
        
        public char getSymbol() {
            return symbol;
        }
        
        public double getToEuroRate() {
            return toEuroRate;
        }
        
        public double getFromEuroRate() {
            return 1 / toEuroRate;
        }
    }
    
    private Currency currency;
    private double amount;
    
    /**
     *
     * @param currency the currency to start money with
     * @param amount the amount to start money with
     */
    public Money(Currency currency, double amount) {
        this.currency = currency;
        this.amount = amount;
    }
    
    /**
     *
     * @param newCurrency the new currency
     */
    public void changeCurrency(Currency newCurrency) {
        double rate = currency.getToEuroRate() * (1 / newCurrency.getToEuroRate());
        
        currency = newCurrency;
        amount *= rate;
    }
    
    /**
     *
     * @return currency
     */
    public Currency getCurrency() {
        return currency;
    }
    
    /**
     *
     * @param currency a currency to set the currency too
     */
    public void setCurrency(Currency currency) {
        this.currency = currency;
    }
    
    /**
     *
     * @return amount
     */
    public double getAmount() {
        return amount;
    }
    
    /**
     *
     * @param amount the amount to set amount too
     */
    public void setAmount(double amount) {
        this.amount = amount;
    }
    
    @Override
    public String toString() {
        double absAmount = Math.abs(amount);
        return String.format("%s%c%.2f", (amount < 0 ? "-" : ""), currency.getSymbol(), absAmount);
    }    
}
