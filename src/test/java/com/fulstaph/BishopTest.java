package com.fulstaph;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BishopTest {

    @Test
    void testValidDiagonalMoveUpRight() {
        PieceColor color = PieceColor.WHITE;
        Position startPosition = new Position(2, 2);
        Position targetPosition = new Position(4, 4);
        Piece[][] board = new Piece[8][8];

        Bishop bishop = new Bishop(color, startPosition);

        assertTrue(bishop.isValidMove(targetPosition, board), "Bishop should be able to move diagonally up-right.");
    }

    @Test
    void testValidDiagonalMoveDownRight() {
        PieceColor color = PieceColor.BLACK;
        Position start = new Position(3, 3);
        Position target = new Position(1, 5); // down-right
        Piece[][] board = new Piece[8][8];

        Bishop bishop = new Bishop(color, start);

        assertTrue(bishop.isValidMove(target, board), "Bishop should be able to move diagonally down-right.");
    }

    @Test
    void testValidDiagonalMoveDownLeft() {
        PieceColor color = PieceColor.BLACK;
        Position startPosition = new Position(4, 4);
        Position targetPosition = new Position(2, 2);
        Piece[][] board = new Piece[8][8];

        Bishop bishop = new Bishop(color, startPosition);

        assertTrue(bishop.isValidMove(targetPosition, board), "Bishop should be able to move diagonally down-left.");
    }

    @Test
    void testValidDiagonalMoveUpLeft() {
        PieceColor color = PieceColor.WHITE;
        Position start = new Position(1, 5);
        Position target = new Position(3, 3); // up-left
        Piece[][] board = new Piece[8][8];

        Bishop bishop = new Bishop(color, start);

        assertTrue(bishop.isValidMove(target, board), "Bishop should be able to move diagonally up-left.");
    }

    @Test
    void testInvalidHorizontalMove() {
        PieceColor color = PieceColor.WHITE;
        Position startPosition = new Position(3, 3);
        Position targetPosition = new Position(3, 5);
        Piece[][] board = new Piece[8][8];

        Bishop bishop = new Bishop(color, startPosition);

        assertFalse(bishop.isValidMove(targetPosition, board), "Bishop should not be able to move horizontally.");
    }

    @Test
    void testInvalidVerticalMove() {
        PieceColor color = PieceColor.BLACK;
        Position startPosition = new Position(3, 3);
        Position targetPosition = new Position(5, 3);
        Piece[][] board = new Piece[8][8];

        Bishop bishop = new Bishop(color, startPosition);

        assertFalse(bishop.isValidMove(targetPosition, board), "Bishop should not be able to move vertically.");
    }

    @Test
    void testMoveBlockedByPiece() {
        PieceColor color = PieceColor.WHITE;
        Position startPosition = new Position(2, 2);
        Position targetPosition = new Position(4, 4);
        Piece[][] board = new Piece[8][8];
        board[3][3] = new Pawn(PieceColor.BLACK, new Position(3, 3));

        Bishop bishop = new Bishop(color, startPosition);

        assertFalse(bishop.isValidMove(targetPosition, board), "Bishop should not be able to jump over other pieces.");
    }
}