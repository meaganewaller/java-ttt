package com.ttt;

import static org.junit.Assert.*;

import org.junit.Test;

public class BoardRulesTest {

	@Test
	public void hasWinnerFalseAtStart() {
		Board board = new Board(3);
		BoardRules boardRules = new BoardRules(board);
		assertEquals(false, boardRules.hasWinner());
	}

}
