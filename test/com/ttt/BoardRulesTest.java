package com.ttt;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BoardRulesTest {
	Board board;
	BoardRules boardRules;
	
	@Before
	public void setUp() {
		board = new Board(3);
		boardRules = new BoardRules(board);
	}

	@Test
	public void hasWinnerFalseAtStart() {
		assertEquals(false, boardRules.hasWinner());
	}
	
	@Test
	public void hasWinningCombos() {
		int[][] winningCombos = {{1, 4, 7}, {2, 5, 8}, {3, 6, 9},
								 {1, 2, 3}, {4, 5, 6}, {7, 8, 9},
								 {1, 5, 9}, {3, 5, 7}};
		boardRules.generateWinningCombos();
		assertArrayEquals(winningCombos, boardRules.getWinningCombos());
	}
	
	@Test
	public void hasWinningCombosForSize4() {
		Board fourBoard = new Board(4);
		BoardRules fourWinCombos = new BoardRules(fourBoard);
		int[][] winningCombos = {{1,5,9,13}, {2, 6, 10, 14}, {3, 7, 11, 15}, {4, 8, 12, 16}, 
								 {1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}, 
				                 {1, 6, 11, 16}, {4, 7, 10, 13}};
		assertArrayEquals(winningCombos, fourWinCombos.getWinningCombos());
	}
	
	@Test
	public void hasWinnerTrueWhenWinner() {
		int[] moves = {1,2,3};
		board.setMoves('X', moves);
		assertEquals(true, boardRules.hasWinner());
	}
	
	@Test
	public void hasWinnerSizeFour() {
		int[] moves = {1, 2, 3, 4};
		board.setMoves('X', moves);
		assertEquals(true, boardRules.hasWinner());
	}
	
	@Test
	public void getsWinner() {
		int[] moves = { 1, 2, 3};
		board.setMoves('X', moves);
		assertEquals('X', boardRules.winner());
	}
	
	@Test
	public void getsWinnerForSizeFour() {
		Board newBoard = new Board(4);
		BoardRules newRules = new BoardRules(newBoard);
		int[] moves = {1, 2, 3, 4};
		newBoard.setMoves('O', moves);
		assertEquals('O', newRules.winner());
	}
	
	@Test
	public void noWinner() {
		int[] moves = {1, 2};
		board.setMoves('X', moves);
		assertEquals(' ', boardRules.winner());
	}
	
	@Test
	public void findsXWinner() {
		int[] moves = {1, 2, 3};
		board.setMoves('X', moves);
		assertEquals('X', boardRules.winner());
	}
	
	@Test
	public void findsOWinner() {
		int[] moves = {1, 2, 3};
		board.setMoves('O', moves);
		assertEquals('O', boardRules.winner());
	}
	
	@Test
	public void boardIsNotFullAtStart() {
		assertEquals(false, boardRules.fullBoard());
	}
	
	@Test
	public void boardIsFull() {
		int[] movesForX = {1, 3, 5, 8};
		int[] movesForO = {2, 4, 6, 7, 9};
		board.setMoves('X', movesForX);
		board.setMoves('O', movesForO);
		assertEquals(true, boardRules.fullBoard());
	}

	@Test
	public void notATieAtStart() {
		assertEquals(false, boardRules.tie());
	}
	
	@Test
	public void findsTie() {
		int[] movesForX = {1, 3, 5, 8};
		int[] movesForO = {2, 4, 6, 7, 9};
		board.setMoves('X', movesForX);
		board.setMoves('O', movesForO);
		assertEquals(true, boardRules.tie());
	}
	
	@Test
	public void notOverAtStart() {
		assertEquals(false, boardRules.isOver());
	}
	
	@Test
	public void overWithWinner() {
		int[] moves = {1, 2, 3};
		board.setMoves('X', moves);
		assertEquals(true, boardRules.isOver());
	}
	
	@Test
	public void overWithTie() {
		int[] movesForX = {1, 3, 5, 8};
		int[] movesForO = {2, 4, 6, 7, 9};
		board.setMoves('X', movesForX);
		board.setMoves('O', movesForO);
		assertEquals(true, boardRules.isOver());
	}
	
	@Test
	public void setsBoard() {
		Board newBoard = new Board(3);
		boardRules.setBoard(newBoard);
		assertEquals(newBoard, boardRules.getBoard());
	}
	
	@Test
	public void getHorizontalWinningCombosSizeThree() {
		int[][] horizontal = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
		assertArrayEquals(horizontal, boardRules.getHorizontalCombos());
	}

	
	@Test
	public void getHorizontalWinningCombosSizeFour() {
		Board newBoard = new Board(4);
		boardRules.setBoard(newBoard);
		int[][] horizontal = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
		assertArrayEquals(horizontal, boardRules.getHorizontalCombos());
	}
	
	@Test
	public void getVerticalWinningCombosSizeThree() {
		int[][] vertical = {{1, 4, 7}, {2, 5, 8}, {3, 6, 9}};
		assertArrayEquals(vertical, boardRules.getVerticalCombos());
	}
	
	@Test
	public void getVerticalWinningCombosSizeFour() {
		Board newBoard = new Board(4);
		boardRules.setBoard(newBoard);
		int[][] vertical = {{1, 5, 9, 13}, {2, 6, 10, 14}, {3, 7, 11, 15}, {4, 8, 12, 16}};
		assertArrayEquals(vertical, boardRules.getVerticalCombos());
	}
	
	@Test
	public void getDiagonalSizeThree() {
		int[][] diagonal = {{1, 5, 9}, {3, 5, 7}};
		assertArrayEquals(diagonal, boardRules.getDiagonalCombos());
	}
	
	@Test
	public void getDiagonalSizeFour() {
		Board newBoard = new Board(4);
		boardRules.setBoard(newBoard);
		int[][] diagonal = {{1, 6, 11, 16}, {4, 7, 10, 13}};
		assertArrayEquals(diagonal, boardRules.getDiagonalCombos());
	}
	
	@Test
	public void hasTheCorrectPlayersTurn() {
		assertEquals('X', boardRules.currentPlayer("---------"));
	}
	
	@Test
	public void hasCorrectPlayersTurnSizeFor() {
		Board newBoard = new Board(4);
		boardRules.setBoard(newBoard);
		assertEquals('X', boardRules.currentPlayer("----------------"));
	}
	
	@Test
	public void returnsCorrectPlayerTurnDuringGame() {
		assertEquals('O', boardRules.currentPlayer("-X-------"));
	}
	
	@Test
	public void returnsCorrectPlayerTurnDuringGameSizeFour() {
		Board newBoard = new Board(4);
		boardRules.setBoard(newBoard);
		assertEquals('O', boardRules.currentPlayer("X---O--X--------"));
	}
}


