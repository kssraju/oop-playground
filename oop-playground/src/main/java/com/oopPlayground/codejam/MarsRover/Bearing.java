package com.oopPlayground.codejam.MarsRover;

public class Bearing {
    private int x;
    private int y;
    private DirectionType direction;

    public Bearing(int x, int y, DirectionType direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public void update(int x, int y, DirectionType direction){
        updateX(x);
        updateY(y);
        updateDirection(direction);
    }

    public void updateX(int x) {
        this.x = x;
    }

    public void updateY(int y) {
        this.y = y;
    }

    public void updateDirection(DirectionType direction) {
        this.direction = direction;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public DirectionType getDirection() {
        return this.direction;
    }
}
