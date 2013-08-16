package com.oopPlayground.CodeJam.GoldHunt;

public class Cell {
    private int x;
    private int y;

    private String type;

    public Cell(int x, int y, String type) {
        this.x = x;
        this.y = y;
        this.type = type;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getType() {
        return type;
    }
}