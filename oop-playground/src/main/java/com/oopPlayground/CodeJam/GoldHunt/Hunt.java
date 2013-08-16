package com.oopPlayground.CodeJam.GoldHunt;

import java.util.ArrayList;
import java.util.List;

public class Hunt {
    List<Player> players;
    Board board;

    public Hunt(Board board) {
        this.players = new ArrayList<>();
        this.board = board;
    }

    public void addPlayer(Player player) {
        this.players.add(player);
    }

    public void removePlayer(Player player) {
        this.players.remove(player);
    }

    public void start() {
        Player winningPlayer = move();
        if (winningPlayer != null) {
            //Winner
        }
    }

    public Player move() {
        List<Player> trappedPlayers = new ArrayList<>();
        for (Player player : players) {
            Cell cell = board.getCell(player.getCurrentXCoordinate(), player.getCurrentYCoordinate());
            //Gold
            if (cell.getType().equals("Gold")) {
                return player;
            }
            //Trap
            else if (cell.getType().equals("Trap")) {
                trappedPlayers.add(player);
            }
            //Displacement
            else {
                DisplacementValues displacementValues = board.getDisplacementValues(cell);
                player.move(displacementValues.getX(), displacementValues.getY());
            }
        }
        removeInactivePlayers(trappedPlayers);
        if (players.size() == 0) {
            return null;
        }
        move();
        return null;
    }

    private void removeInactivePlayers(List<Player> trappedPlayers) {
        for (Player inactivePlayer : trappedPlayers) {
            removePlayer(inactivePlayer);
        }
    }
}
