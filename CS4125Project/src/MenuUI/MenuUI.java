/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MenuUI;

import Control.Login;
import Database.AccountDB;
import User.Account;
import User.Customer;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Brian
 */
public class MenuUI {
    private Scanner scan;
    private AccountDB db;
    private List<Account> users;
    private String username;
    private String password;
    private String email;
    
    public MenuUI() throws IOException{
        scan = new Scanner(System.in);
        users = new ArrayList<Account>();
        db = new AccountDB(users);
        users = db.load();
        username = "";
        password = "";
        email = "";
    }
    
    public void startSession() throws IOException, InterruptedException{
        
       System.out.println("Welcome to Silian Shops!");
        System.out.println("L)ogin");
        System.out.println("R)egister");
        String choice = scan.nextLine();
        boolean validCommand = false;
        while (validCommand == false){
        if(!(choice.equals("L") || choice.equals("R")) ){
            System.out.println("Error, Type 'L' for Login or 'R' for Register");
            choice = scan.nextLine();
        }
        else validCommand = true;
        }
        
        if(choice.equals("L")){
            boolean bool =false;
            while(bool == false){
            System.out.println("Enter your email please:");
            String email = scan.nextLine();
            System.out.println("Enter your password please:");
            String password = scan.nextLine();
            bool = Login.getInstance().Validate(email, password); 
            if (bool == true){
                showMenu();
            }
            }
            
        }
        else {
            boolean valid = false;
            while (valid == false){
                System.out.println("Enter your username");
                username = scan.nextLine();
                System.out.println("Enter your password");
                password = scan.nextLine();
                System.out.println("Enter your email address");
                email = scan.nextLine();
                    if(users.isEmpty()){
                        valid = true;
                    }
                    else
                        for(int i = 0; i < users.size();i++){
                            if(username.equals(users.get(i).getUsername()) || email.equals(users.get(i).getEmail())){
                                System.out.println("Error, invalid username or email\n");
                                System.out.println("Please enter details again");
                            }
                            else valid = true;

                        }
            }  
                users.add(new Customer(username, password, email));
                 for(int i = 0; i < users.size();i++){
                 //System.out.println(users.get(i).getUsername());
                // System.out.println(users.size());
                }
                try{
                db.save();
                System.out.println("You've been successfully registered!");
                System.out.println("\n");
                System.out.println("\n");
                System.out.println("\n");
                TimeUnit.SECONDS.sleep(2);
                
                startSession();
                }catch(IOException e){
                    
                }
            
            
        }
    }
    public void showMenu() throws IOException, InterruptedException{
       System.out.println("Welcome " + username);
       System.out.println("L)ogout");
       String input = scan.nextLine();
       
       if(input.equals("L")){
           System.out.println("Thanks for visiting, see you next time");
           System.out.println("\n");
           System.out.println("\n");
           System.out.println("\n");
           TimeUnit.SECONDS.sleep(2);
           startSession();
       }
    }
    
    
        
}
