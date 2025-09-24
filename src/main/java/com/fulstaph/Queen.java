package com.fulstaph;

public class Queen extends Piece {
    public Queen(PieceColor color, Position position) {
        super(color, position);
    }

    @Override
    public boolean isValidMove(Position newPosition, Piece[][] board) {
        if (!newPosition.isInBoard() || newPosition.equals(position)) {
            return false;
        }

        return (new Bishop(color, position).isValidMove(newPosition, board)) || // hack? :)
                (new Rook(color, position).isValidMove(newPosition, board));
    }
}
