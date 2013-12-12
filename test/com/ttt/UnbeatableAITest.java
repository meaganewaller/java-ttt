package com.ttt;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class UnbeatableAITest {
	Board board;
	UnbeatableAI ai;
	
	@Before
	public void setUp() {
		board = new Board(3);
		ai = new UnbeatableAI('O');
	}
	
	@Test
	public void minimaxReturns100() {
		int[] moves = {1,2,3};
		board.setMoves('O', moves);
		assertEquals(100, ai.findValue(board));
	}
	
	@Test
	public void returnsNegative100ForLosing() {
		int[] moves = {1, 2, 3};
		board.setMoves('X', moves);
		assertEquals(-100, ai.findValue(board));
	}
	
	@Test
	public void returns0ForTie() {
		int[] xMoves = {1, 3, 5, 8};
		int[] oMoves = {2, 4, 6, 7, 9};
		board.setMoves('O', oMoves);
		board.setMoves('X', xMoves);
		assertEquals(0, ai.findValue(board));
	}
	
	@Test
	public void caculatesLossAfterMove() {
		int[] xMoves = {1, 3, 7, 8};
		int[] oMoves = {2, 4, 5};
		board.setMoves('X', xMoves);
		board.setMoves('O', oMoves);
		assertEquals(-99, ai.findValue(board));
	}
	
	@Test
	public void returnsWinningMove() {
		int[] xMoves = {1, 3, 7, 9};
		int[] oMoves = {4, 5};
		board.setMoves('X', xMoves);
		board.setMoves('O', oMoves);
		assertEquals(6, ai.findMove(board));
	}
	
	@Test
	public void makesGoodMove() {
		int[] xMoves = {1, 5};
		int[] oMoves = {9};
		board.setMoves('X', xMoves);
		board.setMoves('O', oMoves);
		assertEquals(3, ai.findMove(board));
	}
	
	@Test
	public void makesValidMove() {
		board.setMove('X', 1);
		assertEquals(5, ai.findMove(board));
	}

}
