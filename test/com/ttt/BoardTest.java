package com.ttt;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BoardTest {
	Board board;

	@Before
	public void setUp() {
		board = new Board(3);
	}
	
	@Test
	public void hasASize() {
		assertEquals(3, board.getSize());
	}
	
	@Test
	public void hasSpaces() {
		assertEquals("---------", board.getSpaces());
	}
	
	@Test
	public void setsXMove() {
		board.setMove('X', 5);
		assertEquals("----X----", board.getSpaces());
	}
}
