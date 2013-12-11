package com.ttt;

import static org.junit.Assert.*;

import java.util.ArrayList;

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
	public void canGetSpaces() {
		assertEquals("---------", board.getSpaces());
	}
	
	@Test
	public void setsXMove() {
		board.setMove('X', 5);
		assertEquals("----X----", board.getSpaces());
	}
	
	@Test
	public void setsOMove() {
		board.setMove('O', 1);
		assertEquals("O--------", board.getSpaces());
	}
	
	@Test
	public void canMakeMultipleMoves() {
		int[] moves = { 4, 5, 6 };
		board.setMoves('X', moves);
		assertEquals("---XXX---", board.getSpaces());
	}
	
	@Test
	public void returnsTheEmptySpace() {
		board.setMoves('X', new int[] { 1, 2, 3, 4, 5, 6, 7, 8 });
		ArrayList moveList = new ArrayList() {};
		moveList.add(9);
		assertEquals(moveList, board.getEmptySpaces());

	}
}
