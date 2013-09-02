package com.oopPlayground.codejam.MarsRover;

public abstract class MoveInstruction extends Instruction {
    @Override
    public Bearing execute(Bearing bearing) {
        return moveBy(bearing);
    }

    protected abstract Bearing moveBy(Bearing bearing);
}

