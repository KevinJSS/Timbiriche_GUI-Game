package main;

import dataset.PlayerList;
import java.io.IOException;
import registerManager.ReaderManager;
import views.MenuFrame;

/**
 * This is the main class of the game, it runs the menu from the Menu class and
 * interacts directly with the user
 *
 * @author Kevin Alvarado
 * @author Alina Rodriguez
 *
 * @version 23/11/2020
 */
public class Menu {
    
    public static final String FILE_NAME = "files/PlayerRegister.txt";
    public static PlayerList playerList = new PlayerList();
    

    public static void showMenu() {
        
        ReaderManager reader = new ReaderManager();  
        try {
            reader.readFile(FILE_NAME);
            
        } catch (IOException ex) {
            System.err.println("Error IOException al leer el archivo");
            System.err.println(ex.getMessage());
            ex.printStackTrace();
        }

        MenuFrame menu = new MenuFrame();
        menu.setVisible(true);
    }
}
