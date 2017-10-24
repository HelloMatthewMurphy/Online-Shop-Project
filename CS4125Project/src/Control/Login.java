/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import User.Account;
import java.util.ArrayList;

/**
 *
 * @author Brian
 */
public class Login {
ArrayList<Account> users; 
private String email;
private String password;

    public Login(String email, String password){
        this.email = email;
        this.password = password;
        users = new ArrayList<Account>();
    }
    
    public String getEmail(){
        return email;
    }
    
    public String getPassword(){
        return password;
    }
    
    
    
    public boolean Validate(){
        boolean validated = false;
        for (int i = 0; i < users.size();i++){
            if ((users.get(i).getEmail() == email) && (users.get(i).getPassword() == password) ){
                validated = true;
                System.out.println("Thanks, enjoy your visit!");
            }
        }     
        return validated;
    }
        
}
