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

}
