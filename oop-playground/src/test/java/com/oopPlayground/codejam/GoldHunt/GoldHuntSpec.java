package com.oopPlayground.codejam.GoldHunt;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

public class GoldHuntSpec {

    @Before
    public void setup() {

    }

    @Test
    public void shouldMovePlayerToNewCell() {
        Board goldHuntBoard = mock(Board.class);
        Cell displacementCell = new Cell(0, 0, "displacement");
        Cell goldCell = new Cell(0, 0, "gold");
        given(goldHuntBoard.getCell(0, 0)).willReturn(displacementCell);
        given(goldHuntBoard.getDisplacementValues(displacementCell)).willReturn(new DisplacementValues(2, 2));
        Player player = new Player("1", 0, 0);
        given(goldHuntBoard.getCell(2, 2)).willReturn(goldCell);
        Hunt hunt = new Hunt(goldHuntBoard);
        hunt.addPlayer(player);
        hunt.start();
    }
}



