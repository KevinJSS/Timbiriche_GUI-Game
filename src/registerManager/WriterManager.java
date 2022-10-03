/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registerManager;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import main.Menu;

/**
 *
 * @author kalva
 */
public class WriterManager {
    
    private BufferedWriter writer;
    
    private void open(String fileName) throws IOException {
        writer = new BufferedWriter(new FileWriter(fileName));
    }
    
    private void writeAll() throws IOException {
        for (int i = 0; i < Menu.playerList.getSize(); i++) {
            writer.write(Menu.playerList.getPlayer(i).toFileString() + "\n");
        }
    }
    
    private void close() throws IOException {
        writer.close();
    }
    
    public void writeFile(String fileName) throws IOException {
        open(fileName);
        writeAll();
        close();
    }
}
