package com.fulstaph;

public class Bishop extends Piece {

    public Bishop(PieceColor color, Position position) {
        super(color, position);
    }

    @Override
    public boolean isValidMove(Position newPosition, Piece[][] board) {
        // If it's horizontal or vertical, it's not a valid move.
        if (position.getRow() == newPosition.getRow() || position.getColumn() == newPosition.getColumn()) {
            return false;
        }

        var rowDiff = Math.abs(newPosition.getRow() - position.getRow());
        var colDiff = Math.abs(newPosition.getColumn() - position.getColumn());

        if (rowDiff != colDiff) { // if not diagonal, it's not a valid move.
            return false;
        }

        var rowStep = newPosition.getRow() > position.getRow() ? 1 : -1; // vertical direction
        var colStep = newPosition.getColumn() > position.getColumn() ? 1 : -1; // horizontal direction
        var steps = rowDiff - 1; // number of vertical steps to check

        for (int i = 1; i <= steps; i++) {
            if (board[position.getRow() + rowStep * i][position.getColumn() + colStep * i] != null) {
                return false;
            }
        }

        var destinationPiece = board[newPosition.getRow()][newPosition.getColumn()];

        if (destinationPiece != null) {
            return destinationPiece.getColor() != color;
        }

        return true;
    }
}
