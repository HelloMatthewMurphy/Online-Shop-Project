/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import Control.Login;
import User.Account;
import User.Customer;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Brian
 */
public class AccountDB {
    private String filename;
    private List<Account> accounts;
    
    public AccountDB(){
        filename = "";
        accounts = new ArrayList<Account>();
    }
    
    public AccountDB(List<Account> accounts){
        this.accounts = accounts;
    }
    
    public Account Login(Login login){
        return new Account(login.getEmail(),login.getPassword());
    }
    
    public void setFileName(String file){
        filename = file;
    }
    
    public void save() throws IOException{
        PrintWriter writer = new PrintWriter(new FileWriter("RegisteredUsers.csv", false));	
		writer.write("Username");
		writer.write(",");
		writer.write("Password");
		writer.write(",");
		writer.write("Email"); 
                writer.write("\n");
                writer.write("");
                writer.write("\n");
                    for (int i = 0; i < accounts.size();i++){
                        writer.write(String.valueOf(accounts.get(i).getUsername()));
                        writer.write(",");
                        writer.write(String.valueOf(accounts.get(i).getPassword()));
                        writer.write(",");
                        writer.write(String.valueOf(accounts.get(i).getEmail()));
                        writer.write("\n");
                    }
                    writer.close();
    }
    
    public List<Account> load() throws FileNotFoundException, IOException{
        try{
        BufferedReader fileReader = new BufferedReader (new FileReader("RegisteredUsers.csv"));
        BufferedReader fileReader2 = new BufferedReader (new FileReader("Supervisors.csv"));
		fileReader.readLine();
		fileReader.readLine();
		String fileLine;
		//hotelData = new HashMap<String,ArrayList<RoomInfo>>();
		String username = "";
                String password = "";
                String email = "";
		while ((fileLine = fileReader.readLine()) != null) {
			String [] data = fileLine.split(",", -1);
			username= data[0];
                        System.out.println(username);
			password = data[1];
                        System.out.println(password);
			email = data[2];
			accounts.add(new Customer(username,password,email));
			}
			fileReader.close();
                        
                fileReader2.readLine();
                fileReader2.readLine();
                String fileLine1 = "";
                String username1 = "";
                String password1 = "";
                String email1 = "";
                while((fileLine1 = fileReader2.readLine()) != null){
                    
                }
             }			
                            
			catch (Exception ex){
			ex.printStackTrace();
                        }
		
                       return accounts;
    }
}
