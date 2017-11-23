 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Database.AccountDB;
import User.Account;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Brian
 */
public class Login {
    ArrayList<Account> users;
    private AccountDB accountDB;

    // The only instance of the class
    private static Login instance;
    
    /**
     * Get the single instance of the class
     * 
     */
    public static Login getInstance() {
        // Craete it if needed
        if (instance == null)
            instance = new Login();
        return instance;
    }
    
    /**
     * Private so that it cannot be instantiated from the outside
     * 
     */
    private Login() {
        users = new ArrayList();
        accountDB = new AccountDB();        
        try {
            accountDB.load();
            users.addAll(accountDB.getAccounts());
        } 
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    /**
    * 
    * Checks if the user exists on the system
    * @param email users email.
    * @param password users password.
    * @return validated
    * @throws InterruptedException
    * 
    */
    public boolean Validate(String email, String password) throws InterruptedException {
        
        boolean validated = false;
        for (int i = 0; i < users.size();i++){
            if ((users.get(i).getEmail().equals(email)) && (users.get(i).getPassword().equals(password)) ){
                validated = true;
            }            
        }  
        
        if(validated == false){
            System.out.println("Error,Please enter a valid login");
        }        
        else if (validated == true){
            System.out.println("Thanks, enjoy your visit!");
            System.out.println("\n");
            System.out.println("\n");
            System.out.println("\n");
            TimeUnit.SECONDS.sleep(2);
        }
        return validated;
    }
        
}
