package com.oopPlayground.codejam.MarsRover;

public abstract class RotateInstruction extends Instruction{

    @Override
    public Bearing execute(Bearing bearing) {
        return rotateBy(bearing);
    }

    protected abstract Bearing rotateBy(Bearing bearing);
}

