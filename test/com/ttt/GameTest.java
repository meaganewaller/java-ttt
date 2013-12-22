package com.ttt;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.Reader;
import java.io.StringReader;

import org.junit.Before;
import org.junit.Test;

import com.ttt.mocks.AIMock;
import com.ttt.mocks.MockUI;

public class GameTest {
	Game game;
	MockUI ui;
	
	@Before
	public void setUp() {
		Reader reader = new StringReader("1\n2\n");
		ui = new MockUI(reader);
		game = new Game(ui);
	}
	
	@Test
	public void gameHasBoardSpaces() {
		game.startGame();
		assertEquals("---------", game.getBoard().getSpaces());
	}
	
	@Test
	public void gameHasFirstPlayer() {
		game.startGame();
		assertEquals('X', game.getFirstPlayer().getMarker());
		assertTrue(game.getFirstPlayer().isHuman());
	}
	
	@Test
	public void gameHasSecondPlayer() {
		game.startGame();
		assertEquals('O', game.getSecondPlayer().getMarker());
		assertTrue(game.getFirstPlayer().isHuman());
	}
	
	@Test
	public void hasUI() {
		game.startGame();
		assertEquals(ui, game.getUI());
	}
	
	@Test
	public void startGame() {
		game.startGame();
		assertEquals(game.getFirstPlayer().getMarker(), 'X');
		assertEquals(game.getSecondPlayer().getMarker(), 'O');
		assertEquals(game.getBoard().getSize(), 3);
	}
	
	@Test
	public void endsGame() {
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		System.setOut(new PrintStream(output));
		game.startGame();
		game.endGame();
	}
	
	@Test
	public void makesPlayerMoves() {
		game.startGame();
		game.makePlayerMoves();
		assertEquals("XO-------", game.getBoard().getSpaces());
	}
	
	@Test
	public void makeAIMoves() {
		game.startGame();
		AIMock ai = new AIMock('X');
		game.makePlayerMove(ai);
		assertEquals("X---------", game.getBoard().getSpaces());
	}
	
	@Test
	public void hasBoardRules() {
		game.startGame();
		assertEquals(game.getBoardRules().getClass(), BoardRules.class);
	}
	
	@Test
	public void hasComputerPlayer() {
		Player player = game.getPlayer("c", 'X');
		assertEquals('X', player.getMarker());
		assertEquals(false, player.isHuman());
	}
	
	@Test
	public void hasHumanPlayer() {
		Player player = game.getPlayer("h", 'X');
		assertEquals(true, player.isHuman());
	}
}

	
