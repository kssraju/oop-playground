package com.oopPlayground.CodeJam.GoldHunt;

public class Player {

    private String id;
    private int currentXCoordinate;
    private int currentYCoordinate;

    public Player(String id, int currentXCoordinate, int currentYCoordinate) {
        this.id = id;
        this.currentXCoordinate = currentXCoordinate;
        this.currentYCoordinate = currentYCoordinate;
    }

    public String getId() {
        return id;
    }

    public int getCurrentYCoordinate() {
        return currentYCoordinate;
    }

    public int getCurrentXCoordinate() {
        return currentXCoordinate;
    }

    public void move(int moveXByValue, int moveYByValue) {
        this.currentXCoordinate += moveXByValue;
        this.currentYCoordinate += moveYByValue;
    }
}

