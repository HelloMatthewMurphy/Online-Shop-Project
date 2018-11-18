package Control;

import Database.AccountDB;
import User.Account;
import java.io.IOException;
import java.util.ArrayList;

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
     * @return instance
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
    * @throws InterruptedException -
    * 
    */
    public boolean Validate(String email, String password) throws InterruptedException {
        for (int i = 0; i < users.size();i++){
            if ((users.get(i).getEmail().equals(email)) && (users.get(i).getPassword().equals(password)) ){
                return true;
            }           
        }
        return false;
    }     
}
