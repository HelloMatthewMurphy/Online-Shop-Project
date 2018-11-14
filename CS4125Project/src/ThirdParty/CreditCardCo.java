/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ThirdParty;

import User.Account;

/**
 * Third party credit card company
 * @author Jack
 */
public class CreditCardCo {
    
    /**
     * A empty constructor 
     */
    public CreditCardCo(){
        
    }
    
    /**
     * 
     * @param account users account
     * @param ammount the amount to be charged to the user
     * @return true
     */
    public boolean makePurchase(Account account, double ammount){
        return true;
    }
    
}
