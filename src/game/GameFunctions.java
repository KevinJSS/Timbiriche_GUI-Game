/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

/**
 *
 * @author kalva
 */
public interface GameFunctions {
    
    //void printGameResult();

    boolean wonGame();

    boolean[] addLine(int row, int column);
    
    String gameResult();
}
