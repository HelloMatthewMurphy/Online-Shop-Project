/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Business.Account;
import java.util.ArrayList;

/**
 *
 * @author Brian
 */
public class Login {
ArrayList<Account> users; 
private String username;
private String password;

    public Login(String username, String password){
        this.username = username;
        this.password = password;
    }
        
}
