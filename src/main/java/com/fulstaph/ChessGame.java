package com.fulstaph;

public class ChessGame {
    private ChessBoard board;
    private boolean isWhiteTurn;

    public ChessGame() {
        this.board = new ChessBoard();
    }

    public boolean makeMove(Position start, Position end) {
        var movingPiece = board.getPiece(start);

        if (movingPiece == null || movingPiece.getColor() != (isWhiteTurn ? PieceColor.WHITE : PieceColor.BLACK)) {
            return false;
        }

        if (movingPiece.isValidMove(end, board.getBoard())) {
            board.movePiece(start, end);
            isWhiteTurn = !isWhiteTurn;
            return true;
        }

        return false;
    }

    public boolean isInCheck(PieceColor kingColor) {
        return false;
    }

    private Position findKingPosition(PieceColor color) {
        return null;
    }

    public boolean isCheckmate(PieceColor kingColor) {
        return false;
    }

    private boolean wouldBeInCheckAfterMove(PieceColor kingColor, Position from, Position to) {
        return false;
    }
}
