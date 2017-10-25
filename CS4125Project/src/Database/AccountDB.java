/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import Control.Login;
import User.Account;
import java.util.ArrayList;

/**
 *
 * @author Brian
 */
public class AccountDB {
    private String filename;
    private ArrayList<Account> accounts;
    
    public AccountDB(ArrayList<Account> accounts){
        this.accounts = accounts;
    }
    
    public Account Login(Login login){
        return new Account(login.getEmail(),login.getPassword());
    }
    
    public void setFileName(String file){
        filename = file;
    }
    
    public void save(){
        //implement code for saving data into files
    }
    
    public void load(){
        //implement code for loading file data into program
    }
}
