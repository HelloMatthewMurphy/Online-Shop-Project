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
 *
 * @author Brian
 */
public class AccountDB implements IDatabase {
    
    private String filename;
    private List<Account> accounts;
    
    public AccountDB(){
        filename = "";
        accounts = new ArrayList<Account>();
    }
    
    public AccountDB(List<Account> accounts){
        filename = "";
        this.accounts = accounts;
    }
    
    @Override
    public void setFilename(String file){
        filename = file;
    }
    
    @Override
    public void save() throws IOException{
        PrintWriter writer = new PrintWriter(new FileWriter(filename, false));	
        System.out.println("hI :)");
        writer.write("Username,Password,Email\n\n");
        System.out.println(accounts.size());
        for (int i = 0; i < accounts.size();i++){
            System.out.println(i);
            writer.write(String.valueOf(accounts.get(i).getUsername()));
            writer.write(",");
            writer.write(String.valueOf(accounts.get(i).getPassword()));
            writer.write(",");
            writer.write(String.valueOf(accounts.get(i).getEmail()));
            writer.write("\n");
        }
        writer.close();
    }
    
    @Override
    public void load() throws IOException {
        System.out.println("running");
        BufferedReader fileReader = new BufferedReader (new FileReader("RegisteredUsers.csv"));
        BufferedReader fileReader2 = new BufferedReader (new FileReader("Supervisors.csv"));
        fileReader.readLine();
        fileReader.readLine();
        String fileLine;
        //hotelData = new HashMap<String,ArrayList<RoomInfo>>();
        while ((fileLine = fileReader.readLine()) != null) {  
            String [] data = fileLine.split(",", -1);
            String username= data[0];
            String  password = data[1];
            String email = data[2];
            accounts.add(new Customer(username,password,email));
        }
        fileReader.close();

        fileReader2.readLine();
        fileReader2.readLine();
        String fileLine1;
        while((fileLine1 = fileReader2.readLine()) != null){
            String [] data = fileLine1.split(",",-1);
            String username = data[0];
            String password = data[1];
            String email = data[2];
        }
        fileReader2.close();
    }
    
    public List<Account> getAccounts() {
        return accounts;
    }
}
