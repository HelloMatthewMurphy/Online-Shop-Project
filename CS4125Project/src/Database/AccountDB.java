/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import User.Account;
import User.Customer;
import User.Supervisor;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * A database that holds all users information
 * @author Brian
 * 
 */
public class AccountDB implements IDatabase {
    
    private String filename;
    private List<Account> accounts;
    
    /**
     * A constructor sets filename and a blank ArrayList for accounts
     */
    public AccountDB(){
        filename = "";
        accounts = new ArrayList<Account>();
    }
    /**
     * A constructor sets filename and a ArrayList for accounts
     * @param accounts An ArrayList of accounts
     */    
    public AccountDB(List<Account> accounts){
        filename = "";
        this.accounts = accounts;
    }
    /**
     *@param  file sets name of filename
     */ 
    @Override
    public void setFilename(String file){
        filename = file;
    }
    
    /**
     * saves Accounts to a CSV file
     * @throws IOException
     */ 
    @Override
    public void save() throws IOException{
        PrintWriter writer = new PrintWriter(new FileWriter(filename, false));	
        writer.write("Username,Password,Email\n\n");
        for (int i = 0; i < accounts.size();i++){
            writer.write(String.valueOf(accounts.get(i).getUsername()));
            writer.write(",");
            writer.write(String.valueOf(accounts.get(i).getPassword()));
            writer.write(",");
            writer.write(String.valueOf(accounts.get(i).getEmail()));
            writer.write(",");
            if(accounts.get(i) instanceof Supervisor){
                writer.write("S");
            }
            else if(accounts.get(i) instanceof Customer){
                writer.write("C");
            }
            writer.write("\n");
        }
        writer.close();
    }
    
     /**
     * Creates Accounts and adds them to a DB from a RegisteredUsers.csv
     * @throws IOException
     */ 
    @Override
    public void load() throws IOException {
        BufferedReader fileReader = new BufferedReader (new FileReader("RegisteredUsers.csv"));
        fileReader.readLine();
        fileReader.readLine();
        String fileLine;
        while ((fileLine = fileReader.readLine()) != null) {  
            String [] data = fileLine.split(",", -1);
            String username= data[0];
            String password = data[1];
            String email = data[2];
            String type = data[3];
            if (type.equals("S")){
                accounts.add(new Supervisor(username,password,email));
            }
            else if (type.equals("C")){
                accounts.add(new Customer(username,password,email));
            }
        }
        fileReader.close();
    }
    /**
     * 
     * @return accounts
     */
    public List<Account> getAccounts() {
        return accounts;
    }
}