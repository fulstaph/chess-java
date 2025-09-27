package com.fulstaph;

public class Knight extends Piece {

    public Knight(PieceColor color, Position position) {
        super(color, position);
    }

    @Override
    public boolean isValidMove(Position newPosition, Piece[][] board) {
        if (newPosition.isNotInBoard() || newPosition.equals(position)) {
            return false;
        }

        var rowDiff = Math.abs(newPosition.getRow() - position.getRow());
        var colDiff = Math.abs(newPosition.getColumn() - position.getColumn());

        if (rowDiff == 1 || rowDiff == 2) {
            if (rowDiff == 1 && colDiff != 2) {
                return false;
            }

            if (rowDiff == 2 && colDiff != 1) {
                return false;
            }
        } else {
            return false;
        }

        var destinationPiece = board[newPosition.getRow()][newPosition.getColumn()];
        if (destinationPiece != null) {
            return destinationPiece.getColor() != this.getColor();
        }

        return true;
    }
}
