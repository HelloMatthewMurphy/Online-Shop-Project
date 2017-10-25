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
public class Account {
    private String username;
    private String password;
    private String email;
    
    public Account(String username, String password, String email){
        this.username = username;
        this.password = password;
        this.email = email;
    }
    
    public Account(String password, String email){
        this.password = password;
        this.email = email;
    }
    
    public String getEmail(){
        return email;
    }
    
    public String getPassword(){
        return password;
    }
    
}
