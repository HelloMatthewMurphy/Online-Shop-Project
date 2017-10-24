/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package User;

/**
 *
 * @author Brian
 */
public class Accounts {
    private String username;
    private String password;
    private String email;
    
    public Accounts(String username, String password, String email){
        this.username = username;
        this.password = password;
        this.email = email;
    }
    
    public Accounts(String password, String email){
        this.password = password;
        this.email = email;
    }
    
}
