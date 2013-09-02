package com.oopPlayground.codejam.GoldHunt;

import java.util.Map;

public class DisplacementMap {
    Map<Cell, DisplacementValues> displacementCards;

    public DisplacementMap(Map<Cell, DisplacementValues> displacementCards) {
        this.displacementCards = displacementCards;
    }

    public DisplacementValues getDisplacement(Cell cell){
        return displacementCards.get(cell);
    }

    public DisplacementValues getValues(Cell cell) {
        return displacementCards.get(cell);
    }
}
