/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MenuUI;

import Control.Login;
import java.util.Scanner;

/**
 *
 * @author Brian
 */
public class MenuUI {
    private Scanner scan;
    
    public MenuUI(){
        scan = new Scanner(System.in);
    }
    
    public void startSession(){
       System.out.println("Welcome to Silian Shops!");
        System.out.println("L)ogin");
        System.out.println("R)egister");
        String choice = scan.nextLine();
        if(!(choice.equals("L") || choice.equals("R")) ){
            System.out.println("Error, Type 'L' for Login or 'R' for Register");
            choice = scan.nextLine();
        }
        else if(choice.equals("L")){
            System.out.println("Enter your email please:");
            String email = scan.nextLine();
            System.out.println("Enter your password please:");
            String password = scan.nextLine();
            Login login = new Login(email,password);
            boolean bool = login.Validate();
        }
    }
    
    
        
}
