package com.ttt;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class HumanPlayerTest {
	HumanPlayer human;
	
	@Before
	public void setUp() {
		human = new HumanPlayer('X');
	}

	@Test
	public void playerIsHuman() {
		assertEquals(true, human.isHuman());
	}
	
	@Test
	public void getMarker() {
		assertEquals('X', human.getMarker());
	}
	
	@Test
	public void makesMove() {
		Board board = new Board(3);
		board = human.move(board, 1);
		assertEquals("X--------", board.getSpaces());
	}
	

}
