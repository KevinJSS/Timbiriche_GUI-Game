/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataset;

import model.Player;

/**
 * @author Kevin Alvarado
 * @author Alina Rodriguez
 *
 * @version 23/11/2020
 */
public class PlayerList {

    private static Player[] playerList;
    private int playerCounter;

    public PlayerList() {
        playerList = new Player[100];
    }

    public void addPlayer(String playerID, double wonGames) {
        if (playerCounter == playerList.length) {
            increaseListSize();
        }
        playerList[playerCounter++] = new Player(playerID, wonGames);
    }

    private void increaseListSize() {
        Player[] temp = new Player[playerList.length * 2];
        for (int i = 0; i < playerList.length; i++) {
            temp[i] = playerList[i];
        }
        playerList = temp;
    }

    public void addPlayer(Player player) {
        playerList[playerCounter++] = player;
    }

    public Player getPlayer(int index) {
        return playerList[index];
    }

    public int getSize() {
        return playerCounter;
    }

    public String showPlayersList() {
        String list = "";
        for (Player player : playerList) {
            if (player != null) {
                list += player + "\n\n";
            } else {
                break;
            }
        }
        return list;
    }
}
