package com.oopPlayground.codejam.MarsRover;

public class MoveOneStepInstruction extends MoveInstruction{
    @Override
    protected Bearing moveBy(Bearing bearing) {
        return bearing;
    }
}
