package com.fulstaph;

public class Pawn extends Piece {
    public Pawn(PieceColor color, Position position) {
        super(color, position);
    }

    @Override
    public boolean isValidMove(Position newPosition, Piece[][] board) {
        int forwardDirection = color == PieceColor.WHITE ? 1 : -1;
        int rowDiff = (newPosition.getRow() - position.getRow()) * forwardDirection;
        int colDiff = newPosition.getColumn() - position.getColumn();

        // forward move
        if (rowDiff == 1 && colDiff == 0 && board[newPosition.getRow()][newPosition.getColumn()] == null) {
            return true; // one square
        }

        // two-step move from starting position
        boolean isStartingPosition = (color == PieceColor.WHITE && position.getRow() == 1) ||
                (color == PieceColor.BLACK && position.getColumn() == 6);

        if (colDiff == 0 && rowDiff == 2 && isStartingPosition &&
                board[newPosition.getRow()][newPosition.getColumn()] == null) {
            // check if the square inbetween for blocking pieces
            int middleRow = position.getRow() + forwardDirection;
            if (board[middleRow][newPosition.getColumn()] == null ) {
               return true;
            }
        }

        // diagonal capture
        if (Math.abs(colDiff) == 1 && rowDiff == 1 &&
            board[newPosition.getRow()][newPosition.getColumn()] != null && // target square empty
            board[newPosition.getRow()][newPosition.getColumn()].color != this.color) { // target square piece isn't on our team
            return true; // capture opponent's piece
        }

        return false;
    }
}
