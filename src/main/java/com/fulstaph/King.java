package com.fulstaph;

public class King extends Piece {
    public King(PieceColor color, Position position) {
        super(color, position);
    }

    @Override
    public boolean isValidMove(Position newPosition, Piece[][] board) {
        if (newPosition.isNotInBoard() || newPosition.equals(position)) {
            return false;
        }

        var rowDiff = Math.abs(newPosition.getRow() - position.getRow());
        var colDiff = Math.abs(newPosition.getColumn() - position.getColumn());

        // if more than one square away, it's not a valid move.
        if (rowDiff > 1 || colDiff > 1) {
            return false;
        }

        var isStraightMove = (rowDiff > 0 && colDiff == 0) || (rowDiff == 0 && colDiff > 0);
        var isDiagonalMove = rowDiff == colDiff;

        if (!isStraightMove && !isDiagonalMove) {
            return false;
        }

        var destinationPiece = board[newPosition.getRow()][newPosition.getColumn()];
        if (destinationPiece != null) {
            return destinationPiece.color != this.color;
        }

        return true;
    }
}
