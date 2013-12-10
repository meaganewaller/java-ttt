package com.ttt;

import static org.junit.Assert.*;

import org.junit.Test;

public class BoardTest {

	@Test
	public void hasASize() {
		Board board = new Board();
		assertEquals(3, board.size);
	}
	
	@Test
	public void setsBoardSpaces() {
		Board board = new Board();
		int[] space = { 2, 2};
		assertEquals(0, board.spaceValue(space));
		board.setSpaceValue(space, 1);
		assertEquals(1, board.spaceValue(space));
	}
	

}
