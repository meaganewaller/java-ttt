package com.ttt;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import com.ttt.mocks.AIMock;
import com.ttt.mocks.MockBufferedReader;
import com.ttt.mocks.MockCommandLine;
import com.ttt.mocks.MockOutputStream;
import com.ttt.mocks.MockPrintStream;


public class GameTest {
	OutputStream outputStream = new MockOutputStream();
	MockPrintStream printStream = new MockPrintStream(outputStream);
	MockCommandLine ui;
	Game game;
	
	@Before
	public void setUp() {
		ui = new MockCommandLine();
		printStream.setStringHistory(new ArrayList<String>());
		ui.setOutput(printStream);
		game = new Game(ui);
	}
	
	@Test
	public void gameHasBoardSpaces() throws IOException {
		game.startGame();
		assertEquals("---------", game.getBoard().getSpaces());
	}
	
	@Test
	public void gameHasFirstPlayer() throws IOException {
		game.startGame();
		assertEquals('X', game.getFirstPlayer().getMarker());
		assertTrue(game.getFirstPlayer().isHuman());
	}

	
	@Test	
	public void gameHasSecondPlayer() throws IOException {
		game.startGame();
		assertEquals('O', game.getSecondPlayer().getMarker());
		assertTrue(game.getFirstPlayer().isHuman());
	}
	
	@Test
	public void hasUI() throws IOException {
		game.startGame();
		assertEquals(ui, game.getUI());
	}
	
	@Test
	public void canStartGame() throws IOException {
		game.startGame();
		assertEquals(game.getFirstPlayer().getMarker(), 'X');
		assertEquals(game.getSecondPlayer().getMarker(), 'O');
		assertEquals(game.getBoard().getSize(), 3);
	}
	
	// Not sure about this one
	/*@Test
	public void makesMoves() throws IOException {
		game.startGame();
		MockBufferedReader bufferedReader = new MockBufferedReader(new InputStreamReader(ui.input));
		ui.setBufferedReader(bufferedReader);
		bufferedReader.setInputHistory(new ArrayList<String>(Arrays.asList("1")));
		game.makePlayerMoves();
		assertEquals("O--------", game.getBoard().getSpaces());
	}
	*/
	
	@Test
	public void makeAIMoves() throws IOException {
		game.startGame();
		AIMock ai = new AIMock('X');
		game.makePlayerMove(ai);
		assertEquals("X---------", game.getBoard().getSpaces());
	}
	
	@Test
	public void hasBoardRules() throws IOException {
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
	
	@Test
	public void returnsFalseIfSpaceNotTaken() throws IOException {
		Board board = new Board(3);
		game.startGame();
		assertFalse(game.isSpaceTaken(1));
	}
	
	@Test
	public void returnsTrueIfSpaceTaken() throws IOException {
		Board board = new Board(3);
		AIMock ai = new AIMock('X');
		game.startGame();
		game.makePlayerMove(ai);
		assertTrue(game.isSpaceTaken(1));
	}
}
