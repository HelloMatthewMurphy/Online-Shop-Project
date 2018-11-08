/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

/**
 *
 * @author Shane
 */
public class Money {
    
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
    
    public Money(Currency currency, double amount) {
        this.currency = currency;
        this.amount = amount;
    }
    
    public void changeCurrency(Currency newCurrency) {
        double rate = currency.getToEuroRate() * (1 / newCurrency.getToEuroRate());
        
        currency = newCurrency;
        amount *= rate;
    }
    
    public Currency getCurrency() {
        return currency;
    }
    
    public void setCurrency(Currency currency) {
        this.currency = currency;
    }
    
    public double getAmount() {
        return amount;
    }
    
    public void setAmount(double amount) {
        this.amount = amount;
    }
    
    @Override
    public String toString() {
        double absAmount = Math.abs(amount);
        return String.format("%s%c%.2f", (amount < 0 ? "-" : ""), currency.getSymbol(), absAmount);
    }    
}
