package com.oopPlayground.CodeJam.GoldHunt;

public class Board {
    private DisplacementMap cellDisplacementMap;
    private Cell[][] cells;

    public Board(Cell[][] cells, DisplacementMap cellDisplacementMap) {
        this.cellDisplacementMap = cellDisplacementMap;
        this.cells = cells;
    }

    public Cell getCell(int x, int y) {
        return cells[x][y];
    }

    public DisplacementValues getDisplacementValues(Cell cell) {
        return cellDisplacementMap.getValues(cell);
    }
}

