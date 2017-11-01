/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package User;

/**
 *
 * @author Jack
 */
public class AccountFactory {
    
    public AccountFactory(){
        
    }
    
    public Account createAccount(String accountType, String username, String password, String email){
        Account account = null;
        if(accountType.equalsIgnoreCase("customer")){
            account = new Customer(username,password,email);
        }
        else if(accountType.equalsIgnoreCase("supervisor")){
            account = new Supervisor(username,password,email);
        }
        return account;
    }
}
