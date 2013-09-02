package com.oopPlayground.codejam.MarsRover;

import java.util.Map;

public class InstructionGuide {
    private Map<InstructionType, Instruction> guide;

    public InstructionGuide(Map<InstructionType, Instruction> guide) {
        this.guide = guide;
    }

    public Instruction getInstruction(InstructionType instructionType) {
        return guide.get(instructionType);
    }
}
