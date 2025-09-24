package com.fulstaph;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class QueenTest {

    /**
     * Extended tests for the isValidMove method in the Queen class.
     * These tests ensure further coverage of specific edge cases and scenarios
     * for the Queen's valid movement capabilities.
     */

    @Test
    void testMoveToSamePosition() {
        Position initialPosition = new Position(4, 4);
        Queen queen = new Queen(PieceColor.WHITE, initialPosition);
        Piece[][] board = new Piece[8][8];
        Position newPosition = new Position(4, 4);

        boolean result = queen.isValidMove(newPosition, board);

        assertFalse(result, "The Queen should not be able to move to its current position.");
    }

    @Test
    void testPathBlockedByOpponentPieceOnVerticalMove() {
        Position initialPosition = new Position(2, 2);
        Queen queen = new Queen(PieceColor.WHITE, initialPosition);
        Piece[][] board = new Piece[8][8];
        board[4][2] = new Pawn(PieceColor.BLACK, new Position(4, 2));
        Position newPosition = new Position(6, 2);

        boolean result = queen.isValidMove(newPosition, board);

        assertFalse(result, "The Queen should not be able to skip over an opponent's piece on a vertical move.");
    }

    @Test
    void testPathBlockedByOpponentPieceOnDiagonalMove() {
        Position initialPosition = new Position(1, 1);
        Queen queen = new Queen(PieceColor.WHITE, initialPosition);
        Piece[][] board = new Piece[8][8];
        board[3][3] = new Pawn(PieceColor.BLACK, new Position(3, 3));
        Position newPosition = new Position(5, 5);

        boolean result = queen.isValidMove(newPosition, board);

        assertFalse(result, "The Queen should not be able to skip over an opponent's piece on a diagonal move.");
    }

    @Test
    void testCaptureOpposingPieceAtEndOfPath() {
        Position initialPosition = new Position(3, 3);
        Queen queen = new Queen(PieceColor.WHITE, initialPosition);

        Piece[][] board = new Piece[8][8];
        board[6][3] = new Pawn(PieceColor.BLACK, new Position(6, 3));
        Position newPosition = new Position(6, 3);

        boolean result = queen.isValidMove(newPosition, board);

        assertTrue(result, "The Queen should be able to capture an opposing piece at the destination of the path.");
    }

    @Test
    void testPathBlockedByOwnPieceAfterCapture() {
        Position initialPosition = new Position(2, 2);
        Queen queen = new Queen(PieceColor.WHITE, initialPosition);

        Piece[][] board = new Piece[8][8];
        board[4][4] = new Pawn(PieceColor.BLACK, new Position(4, 4));
        board[5][5] = new Pawn(PieceColor.WHITE, new Position(5, 5));
        Position newPosition = new Position(5, 5);

        boolean result = queen.isValidMove(newPosition, board);

        assertFalse(result, "The Queen should not be able to move past a captured piece if blocked by its own piece.");
    }

    @Test
    void testInvalidMoveOutsideAllowedPatterns() {
        Position initialPosition = new Position(4, 4);
        Queen queen = new Queen(PieceColor.WHITE, initialPosition);

        Piece[][] board = new Piece[8][8];
        Position newPosition = new Position(6, 5); // Not a straight or diagonal move

        boolean result = queen.isValidMove(newPosition, board);

        assertFalse(result, "The Queen should only be allowed to move in straight lines or diagonals.");
    }

    @Test
    void testBoardEdgeMoveTopLeft() {
        Position initialPosition = new Position(7, 7);
        Queen queen = new Queen(PieceColor.WHITE, initialPosition);
        Piece[][] board = new Piece[8][8];
        Position newPosition = new Position(0, 0);

        boolean result = queen.isValidMove(newPosition, board);

        assertTrue(result, "The Queen should be able to move from bottom right to top left on a diagonal.");
    }

    @Test
    void testBoardEdgeMoveBottomRight() {
        Position initialPosition = new Position(0, 0);
        Queen queen = new Queen(PieceColor.WHITE, initialPosition);
        Piece[][] board = new Piece[8][8];
        Position newPosition = new Position(7, 7);

        boolean result = queen.isValidMove(newPosition, board);

        assertTrue(result, "The Queen should be able to move from top left to bottom right on a diagonal.");
    }

    @Test
    void testInvalidMoveOutOfBoardNegativeRow() {
        Position initialPosition = new Position(2, 2);
        Queen queen = new Queen(PieceColor.WHITE, initialPosition);
        Piece[][] board = new Piece[8][8];
        Position newPosition = new Position(-1, 2); // Outside board

        boolean result = queen.isValidMove(newPosition, board);

        assertFalse(result, "The Queen should not be able to move out of the board (negative row).");
    }

    @Test
    void testInvalidMoveOutOfBoardNegativeColumn() {
        Position initialPosition = new Position(2, 2);
        Queen queen = new Queen(PieceColor.WHITE, initialPosition);
        Piece[][] board = new Piece[8][8];
        Position newPosition = new Position(2, -1); // Outside board

        boolean result = queen.isValidMove(newPosition, board);

        assertFalse(result, "The Queen should not be able to move out of the board (negative column).");
    }

    @Test
    void testInvalidMoveOutOfBoardExceedsMaxBounds() {
        Position initialPosition = new Position(7, 7);
        Queen queen = new Queen(PieceColor.WHITE, initialPosition);
        Piece[][] board = new Piece[8][8];
        Position newPosition = new Position(8, 8); // Exceeds board bounds

        boolean result = queen.isValidMove(newPosition, board);

        assertFalse(result, "The Queen should not be able to move outside the board boundaries.");
    }

    @Test
    void testValidLongDiagonalMoveWithClearPath() {
        Position initialPosition = new Position(0, 0);
        Queen queen = new Queen(PieceColor.WHITE, initialPosition);

        Piece[][] board = new Piece[8][8];
        Position newPosition = new Position(7, 7);

        boolean result = queen.isValidMove(newPosition, board);

        assertTrue(result, "The Queen should be able to move from one edge to another in a clear diagonal.");
    }
}