package com.ttt;

import static org.junit.Assert.*;

import org.junit.Test;

public class BoardTest {
	
	@Test
	public void hasASize() {
		Board board = new Board(3);
		assertEquals(3, board.getSize());
	}
	
	@Test
	public void hasSpaces() {
		Board board = new Board(3);
		assertEquals("---------", board.getSpaces());
	}
	
	@Test
	public void setsXMove() {
		Board board = new Board(3);
		board.setMove('X', 5);
		assertEquals("----X----", board.getSpaces());
	}
}
