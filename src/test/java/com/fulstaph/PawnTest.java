package com.fulstaph;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PawnTest {

    @Test
    public void testPawnValidSingleStepForward() {
        Piece[][] board = new Piece[8][8];
        Position currentPosition = new Position(5, 3);
        Pawn whitePawn = new Pawn(PieceColor.WHITE, currentPosition);

        Position newPosition = new Position(6, 3);

        assertTrue(whitePawn.isValidMove(newPosition, board));
    }

    @Test
    public void testPawnValidDoubleStepFromStartingPosition() {
        Piece[][] board = new Piece[8][8];
        Position currentPosition = new Position(1, 3);
        Pawn whitePawn = new Pawn(PieceColor.WHITE, currentPosition);

        Position newPosition = new Position(3, 3);

        assertTrue(whitePawn.isValidMove(newPosition, board));
    }

    @Test
    public void testPawnInvalidDoubleStepNotFromStartingPosition() {
        Piece[][] board = new Piece[8][8];
        Position currentPosition = new Position(5, 3);
        Pawn whitePawn = new Pawn(PieceColor.WHITE, currentPosition);

        Position newPosition = new Position(3, 3);

        assertFalse(whitePawn.isValidMove(newPosition, board));
    }

    @Test
    public void testPawnCaptureDiagonalEnemyPiece() {
        Piece[][] board = new Piece[8][8];
        Position currentPosition = new Position(3, 3);
        Pawn whitePawn = new Pawn(PieceColor.WHITE, currentPosition);

        Piece blackPiece = new Pawn(PieceColor.BLACK, new Position(4, 4));
        board[4][4] = blackPiece;

        Position newPosition = new Position(4, 4);

        assertTrue(whitePawn.isValidMove(newPosition, board));
    }

    @Test
    public void testPawnCannotCaptureSameColorPiece() {
        Piece[][] board = new Piece[8][8];
        Position currentPosition = new Position(6, 3);
        Pawn whitePawn = new Pawn(PieceColor.WHITE, currentPosition);

        Piece whitePiece = new Pawn(PieceColor.WHITE, new Position(5, 4));
        board[5][4] = whitePiece;

        Position newPosition = new Position(5, 4);

        assertFalse(whitePawn.isValidMove(newPosition, board));
    }

    @Test
    public void testPawnCannotMoveForwardIntoOccupiedSquare() {
        Piece[][] board = new Piece[8][8];
        Position currentPosition = new Position(6, 3);
        Pawn whitePawn = new Pawn(PieceColor.WHITE, currentPosition);

        Piece blackPiece = new Pawn(PieceColor.BLACK, new Position(5, 3));
        board[5][3] = blackPiece;

        Position newPosition = new Position(5, 3);

        assertFalse(whitePawn.isValidMove(newPosition, board));
    }

    @Test
    public void testPawnInvalidMoveBackwards() {
        Piece[][] board = new Piece[8][8];
        Position currentPosition = new Position(6, 3);
        var blackPawn = new Pawn(PieceColor.BLACK, currentPosition);

        Position newPosition = new Position(7, 3);

        assertFalse(blackPawn.isValidMove(newPosition, board));
    }

    @Test
    public void testPawnInvalidHorizontalMove() {
        Piece[][] board = new Piece[8][8];
        Position currentPosition = new Position(6, 3);
        Pawn whitePawn = new Pawn(PieceColor.WHITE, currentPosition);

        Position newPosition = new Position(6, 4);

        assertFalse(whitePawn.isValidMove(newPosition, board));
    }
}