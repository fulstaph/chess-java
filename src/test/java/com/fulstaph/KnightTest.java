package com.fulstaph;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KnightTest {

    /**
     * Tests for the `isValidMove` method in the `Knight` class.
     * The method checks if a knight's move is valid given a new position and the current game board.
     */

    @Test
    void testValidMoveLShape() {
        // Arrange
        Position startPosition = new Position(4, 4);
        Knight knight = new Knight(PieceColor.WHITE, startPosition);
        Position targetPosition = new Position(2, 5);
        Piece[][] board = new Piece[8][8];

        // Act
        boolean result = knight.isValidMove(targetPosition, board);

        // Assert
        assertTrue(result, "Knight should be able to move in an L-shape.");
    }

    @Test
    void testInvalidMoveStraightLine() {
        // Arrange
        Position startPosition = new Position(4, 4);
        Knight knight = new Knight(PieceColor.WHITE, startPosition);
        Position targetPosition = new Position(4, 6);
        Piece[][] board = new Piece[8][8];

        // Act
        boolean result = knight.isValidMove(targetPosition, board);

        // Assert
        assertFalse(result, "Knight should not be able to move in a straight line.");
    }

    @Test
    void testInvalidMoveOutOfBounds() {
        // Arrange
        Position startPosition = new Position(0, 0);
        Knight knight = new Knight(PieceColor.WHITE, startPosition);
        Position targetPosition = new Position(1, 1);
        Piece[][] board = new Piece[8][8];

        // Act & Assert
        assertFalse(knight.isValidMove(targetPosition, board), "Moves outside the board should throw an exception.");
    }

    @Test
    void testMoveToOccupiedPositionBySameColor() {
        // Arrange
        Position startPosition = new Position(4, 4);
        Knight knight = new Knight(PieceColor.WHITE, startPosition);
        Position targetPosition = new Position(2, 5);
        Piece[][] board = new Piece[8][8];
        board[2][5] = new Pawn(PieceColor.WHITE, targetPosition);

        // Act
        boolean result = knight.isValidMove(targetPosition, board);

        // Assert
        assertFalse(result, "Knight should not be able to move to a position occupied by a piece of the same color.");
    }

    @Test
    void testMoveToOccupiedPositionByOpponent()  {
        // Arrange
        Position startPosition = new Position(4, 4);
        Knight knight = new Knight(PieceColor.WHITE, startPosition);
        Position targetPosition = new Position(2, 5);
        Piece[][] board = new Piece[8][8];
        board[2][5] = new Pawn(PieceColor.BLACK, targetPosition);

        // Act
        boolean result = knight.isValidMove(targetPosition, board);

        // Assert
        assertTrue(result, "Knight should be able to move to a position occupied by an opponent's piece.");
    }

    @Test
    void testMoveNotInLShapePattern() {
        // Arrange
        Position startPosition = new Position(4, 4);
        Knight knight = new Knight(PieceColor.WHITE, startPosition);
        Position targetPosition = new Position(5, 5);
        Piece[][] board = new Piece[8][8];

        // Act
        boolean result = knight.isValidMove(targetPosition, board);

        // Assert
        assertFalse(result, "Knight should only be able to move in an L-shape pattern.");
    }
}