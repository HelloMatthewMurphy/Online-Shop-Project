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

/**
 *
 * @author Brian
 */
public class Login {
ArrayList<Account> users; 
private String email;
private String password;
private AccountDB account;

    public Login(String email, String password) throws IOException{
        users = new ArrayList<Account>();
        this.email = email;
        account = new AccountDB();
        this.password = password;
        //System.out.println(account.load().size());
        users.addAll(account.load());
    }
    
    public String getEmail(){
        return email;
    }
    
    public String getPassword(){
        return password;
    }
    
    
    
    public boolean Validate(){
        //System.out.println(users.size());
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
                }
        return validated;
    }
        
}
