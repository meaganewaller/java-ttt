package com.ttt;

import static org.junit.Assert.*;

import org.junit.Test;

public class GameTest {
	@Test
	public void hasABoard() {
		Game game = new Game("---------");
		assertEquals("---------", game.board());
	}

}
