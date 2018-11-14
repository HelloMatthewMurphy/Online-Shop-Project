/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs4125project;

import Database.DBControler;
import MenuUI.MainMenuUI;
import java.io.IOException;

/**
 *
 * @author Matthew Murphy
 */
public class CS4125Project {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     * @throws java.lang.InterruptedException
     */
    public static void main(String[] args) throws IOException, InterruptedException {
        DBControler.getInstance().load(DBControler.ALL_DB);
        // TODO code application logic here
        MainMenuUI menu = new MainMenuUI();
        menu.run();
    }
}
