package com.ttt;

import static org.junit.Assert.*;

import org.junit.Test;

public class ComputerPlayerTest {

	@Test
	public void computerNotHuman() {
		ComputerPlayer cpu = new ComputerPlayer('O');
		assertFalse(cpu.isHuman());
	}
	
	@Test
	public void computerHasMarker() {
		ComputerPlayer cpu = new ComputerPlayer('O');
		assertEquals('O', cpu.getMarker());
	}
	
	@Test
	public void makesMove() {
		ComputerPlayer cpu = new ComputerPlayer('O');
		Board board = new Board(3);
		board = cpu.move(board, 5);
		assertEquals("O--------", board.getSpaces());
	}

}
