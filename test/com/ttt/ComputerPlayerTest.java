package com.ttt;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ComputerPlayerTest {
	ComputerPlayer cpu;
	
	@Before
	public void setUp() {
		cpu = new ComputerPlayer('O');
		
	}

	@Test
	public void computerNotHuman() {
		assertFalse(cpu.isHuman());
	}
	
	@Test
	public void computerHasMarker() {
		assertEquals('O', cpu.getMarker());
	}
	
	@Test
	public void makesMove() {
		Board board = new Board(3);
		board = cpu.move(board, 5);
		assertEquals("O--------", board.getSpaces());
	}

}
