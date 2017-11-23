/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MenuUI;

import Control.Login;
import Database.AccountDB;
import Database.DBControler;
import User.Account;
import User.AccountFactory;
import User.Customer;
import User.Supervisor;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import Services.Shop;
import ThirdParty.CreditCardCo;
import ThirdParty.Delivery.BasicDelivery;
import ThirdParty.Delivery.Delivery;
import ThirdParty.Delivery.MoneySaver;
import ThirdParty.Delivery.Premium;
import java.util.Map;
import java.util.Map.Entry;
import javax.swing.JOptionPane;

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
        db.load();
        users = db.getAccounts();
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
                    for(int i = 0; i < users.size();i++){
                        if (users.get(i).getEmail().equals(email)){
                            if(users.get(i) instanceof Customer){
                                Shop s = Shop.getInstance();
                                s.setAccount((Customer)users.get(i));
                                showCustomerMenu();
                            }
                            else if(users.get(i) instanceof Supervisor){
                                showSupervisorMenu();
                            }
                        }
                    }

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
                AccountFactory factory = new AccountFactory();
                users.add((Customer)factory.createAccount("customer", username, password, email));
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
    public void showCustomerMenu() throws IOException, InterruptedException{
       System.out.println("Welcome " + username);
       System.out.println("L)ogout");
       System.out.println("C)heck Stock");
       System.out.println("B)uy Items");
       String input = scan.nextLine();
       
       if(input.equals("L")){
           System.out.println("Thanks for visiting, see you next time");
           System.out.println("\n");
           System.out.println("\n");
           System.out.println("\n");
           TimeUnit.SECONDS.sleep(2);
           startSession();
       }
       if(input.equals("C")){
           System.out.println("A)scending");
           System.out.println("D)escending");
           input = scan.nextLine();
           Shop s = Shop.getInstance();
          
           if(input.equals("A")){
               ArrayList<Entry<String,Integer>> list = (ArrayList<Entry<String,Integer>>) s.getSortedStock(Shop.SortOrder.QUANTITY_ASC);
               for(Entry<String,Integer> entry : list){
                   System.out.println(entry.getKey());
               }
           }
           else if (input.equals("D")){
                ArrayList<Entry<String,Integer>> list = (ArrayList<Entry<String,Integer>>) s.getSortedStock(Shop.SortOrder.QUANTITY_DESC);
               for(Entry<String,Integer> entry : list){
                   System.out.println(entry.getKey());
               }  
           }
       }
    }
    
    public void showSupervisorMenu() throws InterruptedException, IOException{
        System.out.println("Welcome " + username);
        System.out.println("I AM A BANANANANA");
        System.out.println("L)ogout");
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        
        if (input.equals("L")){
            System.out.println("See you next time!");
            TimeUnit.SECONDS.sleep(2);
            startSession();
        }
        
    }
    
    public static void buyItemFromShop(String pickedItem){
        Shop s = Shop.getInstance();
        ArrayList<Map.Entry<String,Integer>> list = (ArrayList<Map.Entry<String,Integer>>) s.getSortedStock(Shop.SortOrder.NAME_ASC);
        double price = 0;
        int amountWanted = 0;
        int amountAvailable = 0;
        boolean donePickingamount = false;
        for(int j = 0; j < list.size(); j++){
            if(list.get(j).getKey().equals(pickedItem)){
               amountAvailable = list.get(j).getValue();
            }
        }
        
        //Getting amount user wants
        while(!donePickingamount){
            Object howMuchWanted = JOptionPane.showInputDialog(null, 
                                                       "There are " + amountAvailable + " " + pickedItem + "'s left in stock. How many would you like?", 
                                                       "Stock", 
                                                        JOptionPane.QUESTION_MESSAGE, 
                                                        null,
                                                        null, 
                                                        null);
            amountWanted = Integer.parseInt(howMuchWanted.toString());
            if(amountWanted <= amountAvailable)
                donePickingamount = true;
            else
                JOptionPane.showMessageDialog(null,
                                            "You can not buy that much, you can get a maximum of " + amountAvailable + ".",
                                            "You cant have that much " + pickedItem + "'s",
                                            JOptionPane.WARNING_MESSAGE);
        }
        price += DBControler.getInstance().getStockItemDB().getStockItemByName(pickedItem).getPrice() * amountWanted;
        
        //Getting delevery type
        Delivery delivery = null;
        boolean validD = false;
        while(validD == false){
            String[] delvTypesStrings = {"Slow", "Regular", "Premium"};
            Object delvTypes = JOptionPane.showInputDialog(null, 
                                                   "What type of Delivery would you like?", 
                                                   "Stock", 
                                                    JOptionPane.QUESTION_MESSAGE, 
                                                    null,
                                                    delvTypesStrings, 
                                                    delvTypesStrings[2]);
            String pickedDelv = delvTypes.toString();

            switch (pickedDelv) {
                case "Slow":
                    delivery = new MoneySaver(new BasicDelivery());
                    validD = true;
                    break;
                case "Regular":
                    delivery = new BasicDelivery();
                    validD = true;
                    break;
                case "Premium":
                    delivery = new Premium(new BasicDelivery());
                    validD = true;
                    break;
                default:
                    break;
            }
            price += delivery.getPrice();
            //delivery.getDays();
        }
        CreditCardCo credit = new CreditCardCo();
        System.out.println(s.getAccount().getUsername()+"Qwerty");
        if(!pickedItem.equals("")){
            s.makePurchase(DBControler.getInstance().getStockItemDB().getStockItemByName(pickedItem), amountWanted, s.getAccount().getUsername());
            credit.makePurchase(s.getAccount(), price);
            JOptionPane.showMessageDialog(null,
                                            "Thanks for buying " + amountWanted + " " + pickedItem + "'s.\n" +
                                                    "They will take " + delivery.getDays() + " day's to arrive!\n" +
                                                    "The total cost was €" + price + ".",
                                            "Purchase Complete!!!",
                                            JOptionPane.PLAIN_MESSAGE);
        }
    }
        
}
