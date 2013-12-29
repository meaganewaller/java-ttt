package com.ttt;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.Reader;
import java.io.StringReader;

import org.junit.Before;
import org.junit.Test;

import com.ttt.mocks.MockOutputStream;
import com.ttt.mocks.MockPrintStream;

public class CommandLineTest {
	OutputStream outputStream  = new MockOutputStream();
	MockPrintStream printStream = new MockPrintStream(outputStream);
	CommandLine ui;
	
	@Test
	public void displaysWelcomeMessage() {
	}
	
	/*
	
	@Before
	public void initialize() {
		System.setOut(new PrintStream(output));
		Reader reader = new StringReader("3\n4\n5\n6");
		ui = new CommandLine(reader);
	}
	
	@Test 
	public void displaysWelcomeMessage() {
		ui.welcomeMessage();
		assertEquals("Welcome to Tic Tac Toe\n", output.toString());
	}
	
	@Test
	public void displaysEndGameMessage() {
		ui.endGame();
		assertEquals("Good bye.\n", output.toString());
	}
	
	@Test
	public void asksFirstPlayer() {
		ui.askPlayerOption("one");
		assertEquals("Please choose player one type('h' or 'c'): \n", output.toString());
	}
	
	@Test
	public void asksSecondPlayer() {
		ui.askPlayerOption("two");
		assertEquals("Please choose player two type('h' or 'c'): \n", output.toString());
	}
	
	@Test
	public void askForBoardSize() {
		ui.askBoardSize();
		assertEquals("Enter board size(3 or 4): \n", output.toString());
	}

	@Test
	public void cantEnterWrongSizeBoard() {
		Reader reader = new StringReader("1\n4\n");
		CommandLine ui = new CommandLine(reader);
		assertEquals(4, ui.askBoardSize());
	}
	
	@Test
	public void readsUserInputForGettingPlayerOptions() {
		assertTrue(ui.getPlayerOptionInput().matches("3"));
	}
	
	@Test
	public void readsUserInputForGettingBoardSize() {
		System.out.println(ui.getBoardOptionInput());
		assertTrue(ui.getBoardOptionInput().matches("4"));
	}
	
	@Test
	public void firstPlayerComputer() {
		Reader reader = new StringReader("c\n");
		CommandLine ui = new CommandLine(reader);
		assertEquals("c", ui.askFirstPlayerOption());
	}
	
	@Test
	public void firstPlayerHuman() {
		Reader reader = new StringReader("h\n");
		CommandLine ui = new CommandLine(reader);
		assertEquals("h", ui.askFirstPlayerOption());
	}
	
	@Test
	public void dealsWithInvalidFirstPlayerInput() {
		Reader reader = new StringReader("t\nh\n");
		CommandLine ui = new CommandLine(reader);
		assertEquals("h", ui.askFirstPlayerOption());
	}
	
	@Test
	public void asksSecondPlayerHumanOption() {
		Reader reader = new StringReader("h\n");
		CommandLine ui = new CommandLine(reader);
		assertEquals("h", ui.askSecondPlayerOption());
	}
	
	@Test
	public void askSecondPlayerAIOption() {
		Reader reader = new StringReader("c\n");
		CommandLine ui = new CommandLine(reader);
		assertEquals("c", ui.askSecondPlayerOption());
	}
	
	@Test
	public void noInvalidInputSecondPlayer() {
		Reader reader = new StringReader("q\nh\n");
		CommandLine ui = new CommandLine(reader);
		assertEquals("h", ui.askSecondPlayerOption());
	}
	
	@Test
	public void askForMove() {
		Reader reader = new StringReader("t\n3\n");
		CommandLine ui = new CommandLine(reader);
		assertEquals(3, ui.askPlayerMove());
	}
	
	@Test
	public void playerCanPlayAgain() {
		Reader reader = new StringReader("Y\n");
		CommandLine ui = new CommandLine(reader);
		assertEquals(true, ui.askPlayAgain());
	}
	
	@Test
	public void asksForPlayersMove() {
		ui.askPlayerMove();
		assertEquals("Enter your move: \n", output.toString());
	}
	
	@Test
	public void displaysBoard() {
		Board board = new Board(3);
		ui.displayBoard(board);
		assertTrue(output.toString().contains("1"));
		assertTrue(output.toString().contains("2"));
		assertTrue(output.toString().contains("3"));
		assertTrue(output.toString().contains("4"));
		assertTrue(output.toString().contains("5"));
		assertTrue(output.toString().contains("6"));
		assertTrue(output.toString().contains("7"));
		assertTrue(output.toString().contains("8"));
		assertTrue(output.toString().contains("9"));
	}
	
	@Test
	public void displaysBoardWithMoves() {
		Board board = new Board(3);
		board.setMove('X', 1);
		ui.displayBoard(board);
		assertFalse(output.toString().contains("1"));
	}
	
	@Test
	public void displaysResultOfGame() {
		ui.displayResult("tie");
		assertEquals("Game over. It's a tie\n", output.toString());
	}
	
	@Test
	public void displayResultForWinner() {
		ui.displayResult("X");
		assertEquals("Game over. X won\n", output.toString());
	}
	
	
	

	

	
*/
}
