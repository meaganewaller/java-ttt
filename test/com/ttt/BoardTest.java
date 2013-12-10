package com.ttt;

import static org.junit.Assert.*;

import org.junit.Test;

public class BoardTest {
	@Test
	public void hasASize() {
		Board board = new Board(3);
		assertEquals(3, board.getSize());
	}

}
