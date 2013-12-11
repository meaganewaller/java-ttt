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
		ArrayList<Integer> emptySpaces = new ArrayList<Integer>() {};
		emptySpaces.add(9);
		assertEquals(emptySpaces, board.getEmptySpaces());
	}
	
	@Test
	public void returnsMultipleEmptySpaces() {
		board.setMoves('X', new int[] {1, 2, 3});
		ArrayList<Integer> emptySpaces = new ArrayList<Integer>() {};
		emptySpaces.add(4);
		emptySpaces.add(5);
		emptySpaces.add(6);
		emptySpaces.add(7);
		emptySpaces.add(8);
		emptySpaces.add(9);
		assertEquals(emptySpaces, board.getEmptySpaces());
	}
	
	@Test
	public void returnsEmptyListWhenNoEmptySpaces() {
		board.setMoves('O', new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9} );
		ArrayList<Integer> emptySpaces = new ArrayList<Integer>() {};
		assertEquals(emptySpaces, board.getEmptySpaces());
	}
	
	@Test
	public void canUndoAMove() {
		board.setMove('X', 1);
		board.undoMove(1);
		assertEquals("---------", board.getSpaces());
	}
}
