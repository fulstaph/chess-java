package com.fulstaph;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class KingTest {

    /**
     * Test class for the King piece's `isValidMove` method.
     * The method determines if a given move is valid for a King
     * based on chess rules. Each test covers a single specific scenario
     * to ensure clarity and focus.
     */

    @Test
    public void testValidStraightMove() {
        PieceColor kingColor = PieceColor.WHITE;
        Position startPosition = new Position(4, 4);
        King king = new King(kingColor, startPosition);

        Position newPosition = new Position(4, 5);
        Piece[][] board = new Piece[8][8];

        assertTrue(king.isValidMove(newPosition, board),
                "King should be able to move one square horizontally");
    }

    @Test
    public void testValidDiagonalMove() {
        PieceColor kingColor = PieceColor.WHITE;
        Position startPosition = new Position(4, 4);
        King king = new King(kingColor, startPosition);

        Position newPosition = new Position(5, 5);
        Piece[][] board = new Piece[8][8];

        assertTrue(king.isValidMove(newPosition, board),
                "King should be able to move one square diagonally");
    }

    @Test
    public void testInvalidMoveOutOfRange() {
        PieceColor kingColor = PieceColor.WHITE;
        Position startPosition = new Position(4, 4);
        King king = new King(kingColor, startPosition);

        Position newPosition = new Position(6, 4);
        Piece[][] board = new Piece[8][8];

        assertFalse(king.isValidMove(newPosition, board),
                "King should not be able to move more than one square");
    }

    @Test
    public void testInvalidMoveSameSpot() {
        PieceColor kingColor = PieceColor.WHITE;
        Position startPosition = new Position(4, 4);
        King king = new King(kingColor, startPosition);

        Position newPosition = new Position(4, 4);
        Piece[][] board = new Piece[8][8];

        assertFalse(king.isValidMove(newPosition, board),
                "King should not be able to stay in the same position");
    }

    @Test
    public void testInvalidMoveOutsideBoard() {
        PieceColor kingColor = PieceColor.WHITE;
        Position startPosition = new Position(0, 0);
        King king = new King(kingColor, startPosition);

        Position newPosition = new Position(-1, 0);
        Piece[][] board = new Piece[8][8];

        assertFalse(king.isValidMove(newPosition, board),
                "King should not be able to move outside the board");
    }

    @Test
    public void testValidCaptureOpponentPiece() {
        PieceColor kingColor = PieceColor.WHITE;
        Position startPosition = new Position(4, 4);
        King king = new King(kingColor, startPosition);

        Position newPosition = new Position(4, 5);
        Piece[][] board = new Piece[8][8];
        board[4][5] = new Pawn(PieceColor.BLACK, newPosition);

        assertTrue(king.isValidMove(newPosition, board),
                "King should be able to capture an opponent's piece");
    }

    @Test
    public void testInvalidMoveFriendlyPieceAtDestination() {
        PieceColor kingColor = PieceColor.WHITE;
        Position startPosition = new Position(4, 4);
        King king = new King(kingColor, startPosition);

        Position newPosition = new Position(4, 5);
        Piece[][] board = new Piece[8][8];
        board[4][5] = new Pawn(PieceColor.WHITE, newPosition);

        assertFalse(king.isValidMove(newPosition, board),
                "King should not be able to move to a square occupied by a friendly piece");
    }
}