/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registerManager;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import main.Menu;

/**
 *
 * @author kalva
 */
public class ReaderManager {
    
    private BufferedReader reader;
    
    private void open(String fileName) throws FileNotFoundException {
        reader = new BufferedReader(new FileReader(fileName));
    }
    
    private void readAll() throws IOException {
        String line = reader.readLine(); //When there isn't more, returns null
        String[] data;
        
        while (line != null) {
            data = line.split("-");
            Menu.playerList.addPlayer(data[0], Double.parseDouble(data[1]));
            line = reader.readLine();
        }
    }
    
    private void close() throws IOException {
        reader.close();
    }
    
    public void readFile(String fileName) throws IOException {
        open(fileName);
        readAll();
        close();
    }
}
