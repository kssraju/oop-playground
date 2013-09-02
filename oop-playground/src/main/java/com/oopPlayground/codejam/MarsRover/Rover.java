package com.oopPlayground.codejam.MarsRover;

public class Rover {
    private Bearing currentBearing;
    private InstructionGuide guide;
    private int maxX;
    private int maxY;

    public Rover(Bearing bearing, InstructionGuide guide, int maxX, int maxY) {
        this.currentBearing = bearing;
        this.guide = guide;
        this.maxX = maxX;
        this.maxY = maxY;
    }

    public Bearing getCurrentBearing() {
        return currentBearing;
    }

    public void execute(InstructionType... instructions) {
        for (InstructionType instructionType : instructions) {
            Instruction instruction = this.guide.getInstruction(instructionType);
            Bearing newBearings = instruction.execute(this.currentBearing);
            this.currentBearing.update(newBearings.getX(), newBearings.getY(), newBearings.getDirection());
        }
    }
}
