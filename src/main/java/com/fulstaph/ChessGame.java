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
        var kingPosition = findKingPosition(kingColor);
        var otherColor = kingColor == PieceColor.WHITE ? PieceColor.BLACK : PieceColor.WHITE;
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                var piece = board.getPiece(new Position(row, col));
                if (piece != null && piece.getColor() == otherColor) {
                    if (piece.isValidMove(kingPosition, board.getBoard())) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private Position findKingPosition(PieceColor color) {
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                var position = new Position(row, col);
                var piece = board.getPiece(position);

                if (piece != null && piece.getColor() == color && piece instanceof King) {
                    return position;
                }
            }
        }

        throw new RuntimeException("King not found?");
    }

    public boolean isCheckmate(PieceColor kingColor) {
        return false;
    }

    private boolean wouldBeInCheckAfterMove(PieceColor kingColor, Position from, Position to) {
        return false;
    }
}
