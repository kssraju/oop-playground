package com.oopPlayground.codejam.MarsRover;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

public class MarsRoverSpec {

    InstructionGuide instructionGuide;
    Instruction lookLeftInstruction;
    Instruction lookRightInstruction;
    Instruction moveInstruction;
    Rover rover;

    @Before
    public void setup() {
        instructionGuide = mock(InstructionGuide.class);
        lookLeftInstruction = mock(RotateInstruction.class);
        lookRightInstruction = mock(RotateInstruction.class);
        moveInstruction = mock(MoveInstruction.class);
        given(instructionGuide.getInstruction(InstructionType.L)).willReturn(lookLeftInstruction);
        given(instructionGuide.getInstruction(InstructionType.R)).willReturn(lookRightInstruction);
        given(instructionGuide.getInstruction(InstructionType.M)).willReturn(moveInstruction);
    }

    @Test
    public void shouldLookLeft() {
        int x = 0;
        int y = 0;
        DirectionType direction = DirectionType.N;
        Bearing bearing = new Bearing(x, y, direction);
        Bearing newBearing = new Bearing(x, y, DirectionType.W);
        given(lookLeftInstruction.execute(bearing)).willReturn(newBearing);
        rover = new Rover(bearing, instructionGuide, 0, 0);

        rover.execute(InstructionType.L);

        Assert.assertEquals(DirectionType.W, rover.getCurrentBearing().getDirection());
    }

    @Test
    public void shouldLookLeftThenRightAndMoveOneStep() {
        int x = 0;
        int y = 0;
        DirectionType direction = DirectionType.N;
        Bearing bearing = new Bearing(x, y, direction);
        given(lookLeftInstruction.execute(bearing)).willReturn(new Bearing(x, y, DirectionType.W));
        given(lookRightInstruction.execute(bearing)).willReturn(new Bearing(x, y, DirectionType.N));
        given(moveInstruction.execute(bearing)).willReturn(new Bearing(x, y + 1, DirectionType.N));
        rover = new Rover(bearing, instructionGuide, 0, 0);

        rover.execute(InstructionType.L, InstructionType.R, InstructionType.M);

        Assert.assertEquals(DirectionType.N, rover.getCurrentBearing().getDirection());
        Assert.assertEquals(y + 1, rover.getCurrentBearing().getY());
    }
}
