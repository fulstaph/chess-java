package com.fulstaph;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RookTest {

    /**
     * Test class for the Rook class.
     * The isValidMove method determines if a move to a new position on the board is valid for the Rook.
     * Each test case ensures that the behavior of the isValidMove method aligns with the rules governing Rook movement.
     */

    @Test
    void testValidVerticalMove() {
        // Arrange
        Position startPosition = new Position(4, 4);
        Rook rook = new Rook(PieceColor.WHITE, startPosition);
        Position newPosition = new Position(7, 4); // New position is vertically aligned

        Piece[][] board = new Piece[8][8]; // Empty board setup

        // Act
        boolean result = rook.isValidMove(newPosition, board);

        // Assert
        assertTrue(result, "Rook should be able to move vertically.");
    }

    @Test
    void testValidHorizontalMove() {
        // Arrange
        Position startPosition = new Position(4, 4);
        Rook rook = new Rook(PieceColor.WHITE, startPosition);
        Position newPosition = new Position(4, 7); // New position is horizontally aligned

        Piece[][] board = new Piece[8][8]; // Empty board setup

        // Act
        boolean result = rook.isValidMove(newPosition, board);

        // Assert
        assertTrue(result, "Rook should be able to move horizontally.");
    }

    @Test
    void testInvalidDiagonalMove() {
        // Arrange
        Position startPosition = new Position(4, 4);
        Rook rook = new Rook(PieceColor.WHITE, startPosition);
        Position newPosition = new Position(6, 6); // New position is diagonally aligned

        Piece[][] board = new Piece[8][8]; // Empty board setup

        // Act
        boolean result = rook.isValidMove(newPosition, board);

        // Assert
        assertFalse(result, "Rook should not be able to move diagonally.");
    }

    @Test
    void testBlockedPathHorizontal() {
        // Arrange
        Position startPosition = new Position(4, 4);
        Rook rook = new Rook(PieceColor.WHITE, startPosition);
        Position newPosition = new Position(4, 7); // Horizontally aligned

        Piece[][] board = new Piece[8][8];
        board[4][5] = new Rook(PieceColor.WHITE, new Position(4, 5)); // Block the path

        // Act
        boolean result = rook.isValidMove(newPosition, board);

        // Assert
        assertFalse(result, "Rook should not be able to move horizontally if the path is blocked.");
    }

    @Test
    void testBlockedPathVertical() {
        // Arrange
        Position startPosition = new Position(4, 4);
        Rook rook = new Rook(PieceColor.WHITE, startPosition);
        Position newPosition = new Position(7, 4); // Vertically aligned

        Piece[][] board = new Piece[8][8];
        board[5][4] = new Rook(PieceColor.BLACK, new Position(5, 4)); // Block the path

        // Act
        boolean result = rook.isValidMove(newPosition, board);

        // Assert
        assertFalse(result, "Rook should not be able to move vertically if the path is blocked.");
    }

    @Test
    void testCaptureOpponent() {
        // Arrange
        Position startPosition = new Position(4, 4);
        Rook rook = new Rook(PieceColor.WHITE, startPosition);
        Position newPosition = new Position(4, 6); // Horizontally aligned

        Piece[][] board = new Piece[8][8];
        board[4][6] = new Rook(PieceColor.BLACK, new Position(4, 6)); // Opponent piece to capture

        // Act
        boolean result = rook.isValidMove(newPosition, board);

        // Assert
        assertTrue(result, "Rook should be able to capture an opponent's piece.");
    }
}