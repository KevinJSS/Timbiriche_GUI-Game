/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import model.Player;

/**
 *
 * @author kalva
 */
public abstract class GameMode implements GameFunctions {

    private static String[] PLAYERS_SYMBOLS;
    private static int playersTurn;
    private GameBoard board;
    private Player player1;

    public GameMode(GameBoard board, Player player1) {
        PLAYERS_SYMBOLS = new String[] {"J1", "J2"};
        player1.setPlayerSymbol(randomSymbol());
        this.board = board;
        this.player1 = player1;
    }
    
    public GameBoard getBoard() {
        return board;
    }
    
    public Player getPlayer1() {
        return player1;
    }
    
    public int getPlayersTurn() {
        return playersTurn;
    }
    
    protected void nextPlayer() {
        playersTurn++;
    }
    
    protected String randomSymbol() {
        int randomNumber = (int) (Math.floor(Math.random() * 2));
        String symbol = PLAYERS_SYMBOLS[randomNumber];
        PLAYERS_SYMBOLS[randomNumber] = null;

        if (symbol != null) {
            return symbol;
        } else {
            return randomSymbol();
        }
    }
    
    public String gameBoardHeader() {
             return ("[" + player1.getPlayerSymbol() + "] " + player1.getPlayerID() + " (" + player1.getGameScore() + ") : ");
    }
    
    public String playersTurnSymbol() {
        return ((playersTurn % 2) == 0) ? "J1" : "J2";
    }
    
    @Override
    public boolean wonGame() {
        return board.fullBoard();
    }
}
