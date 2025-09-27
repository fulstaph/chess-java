package com.fulstaph;

public class Position {
    private int row;
    private int column;

    public Position(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public boolean isNotInBoard() {
        return row < 0 || row >= 8 || column < 0 || column >= 8;
    }

    public boolean equals(Position other) {
        return row == other.row && column == other.column;
    }
}
