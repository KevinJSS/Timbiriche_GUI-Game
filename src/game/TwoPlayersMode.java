/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import javax.swing.JLabel;
import model.Player;

/**
 *
 * @author kalva
 */
public class TwoPlayersMode extends GameMode {

    private Player player2;

    public TwoPlayersMode(GameBoard board, Player player1, Player player2) {
        super(board, player1);
        player2.setPlayerSymbol(randomSymbol());
        this.player2 = player2;
    }

    /**
     * Method to get a header for the game board with the player's symbol, ID
     * and score
     *
     * @return the header string
     */
    @Override
    public String gameBoardHeader() {
        return super.gameBoardHeader()
                + "(" + player2.getGameScore() + ") " + player2.getPlayerID()
                + " [" + player2.getPlayerSymbol() + "]\n\n";
    }

    /**
     * This method adds a line to the board using other methods. First it finds
     * the position of the quadrant and the line to be added, makes sure that
     * the position is available, if it is, it adds the line. It also checks if
     * the quadrant is now full, in that case, the player's symbol is added on
     * the quadrant, increases their score and gives them another turn. If not,
     * it changes turns
     *
     */
    public boolean[] addLine(int row, int column) {
        GameBoard board = getBoard();
        boolean lineAdded = false;
        boolean wonQuadrant = false;

        if (board.isAvailable(row, column)) {
            board.addLine(row, column);
            int wonQuadrants = board.fillFullQuadrants(playersTurnSymbol());
            
            if (wonQuadrants != 0) {
                getPlayerBySymbol(playersTurnSymbol()).increaseScore(wonQuadrants);
                wonQuadrant = true;
                
            } else {
               nextPlayer();
            }
            lineAdded = true;
        }
        return new boolean[] {lineAdded, wonQuadrant};
    }
    
    /**
     * This method prints the result of the game, if a certain player wins, or
     * if it was a tie, depending on the score
     */
    public String gameResult() {
        Player winner = getWinner();

        if (winner != null) {
            winner.addNewVictory(1);
            return ("\n*-*-| PARTIDA GANADA |-*-*\n"+ winner.getPlayerSymbol() + ":\n" + winner);
        } else {
            tiedGame();
            return ("\n---*| EMPATE |*---\n" + getPlayer1() + "\n\n" + player2);
        }
    }

    /**
     * Method to check wich player won a game by comparing their scores
     *
     * @return the player with the highest score or null for a tie
     */
    private Player getWinner() {
        Player player1 = getPlayer1();

        if (player1.getGameScore() > player2.getGameScore()) {
            return player1;
        }
        if (player2.getGameScore() > player1.getGameScore()) {
            return player2;
        }
        return null; //TIE
    }

    /**
     * Method to add half a point to each player's victories. It's used in case
     * of a tie
     */
    private void tiedGame() {
        getPlayer1().addNewVictory(0.5);
        player2.addNewVictory(0.5);
    }

    /**
     * Method to return the player comparing it with the symbol given
     *
     * @param symbol the player's symbol to compare
     * @return the player
     */
    private Player getPlayerBySymbol(String symbol) {
        return (getPlayer1().getPlayerSymbol().equals(symbol)) ? getPlayer1() : player2;
    }
}
