/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import Control.Login;
import User.Accounts;
import java.util.ArrayList;

/**
 *
 * @author Brian
 */
public class AccountDB {
    private String filename;
    private ArrayList<Accounts> accounts;
    
    public AccountDB(ArrayList<Accounts> accounts){
        this.accounts = accounts;
    }
    
    public Accounts Login(Login login){
        return new Accounts(login.getEmail(),login.getPassword());
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
