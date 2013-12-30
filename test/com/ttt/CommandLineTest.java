package com.ttt;


import static org.junit.Assert.*;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import com.ttt.mocks.MockBufferedReader;
import com.ttt.mocks.MockOutputStream;
import com.ttt.mocks.MockPrintStream;

public class CommandLineTest {
	OutputStream outputStream  = new MockOutputStream();
	MockPrintStream printStream = new MockPrintStream(outputStream);
	CommandLine ui;
	
	@Before
	public void setUp() {
		ui = new CommandLine();
		printStream.setStringHistory(new ArrayList<String>());
		ui.setOutput(printStream);
	}
	
	@Test
	public void displaysWelcomeMessage() {
		ui.welcomeMessage();
		assertEquals("Welcome to Tic Tac Toe", printStream.lastOutput());
	}
	
	@Test
	public void itPrintsEndMessage() {
		ui.endGame();
		assertEquals("Good bye.", printStream.lastOutput());
	}
	
	@Test
	public void itDisplaysTheBoard() {
		Board board = new Board(3);
		ui.displayBoard(board);
		assertEquals(" 9 ", printStream.lastOutput());
	}
	
	@Test
	public void displaysResultForXWin() {
		ui.displayResult("X");
		assertEquals("Game over. X won", printStream.lastOutput());
	}
	
	@Test
	public void displayResultForOWin() {
		ui.displayResult("O");
		assertEquals("Game over. O won", printStream.lastOutput());
	}
	
	@Test
	public void diplaysResultForTie() {
		ui.displayResult("tie");
		assertEquals("Game over. It's a tie", printStream.lastOutput());
	}
	
	@Test
	public void asksPlayerForFirstPlayer() throws IOException {
		MockBufferedReader bufferedReader = new MockBufferedReader(new InputStreamReader(ui.input));
		ui.setBufferedReader(bufferedReader);
		bufferedReader.setInputHistory(new ArrayList<String>(Arrays.asList("h")));
		ui.askFirstPlayerOption();
		assertEquals("h", bufferedReader.readLine());
	}
	
	@Test
	public void asksPlayerForSecondPlayer() throws IOException {
		MockBufferedReader bufferedReader = new MockBufferedReader(new InputStreamReader(ui.input));
		ui.setBufferedReader(bufferedReader);
		bufferedReader.setInputHistory(new ArrayList<String>(Arrays.asList("c")));
		ui.askSecondPlayerOption();
		assertEquals("c", bufferedReader.readLine());
	}
	
	@Test
	public void asksPlayerForBoardSize() throws NumberFormatException, IOException {
		MockBufferedReader bufferedReader = new MockBufferedReader(new InputStreamReader(ui.input));
		ui.setBufferedReader(bufferedReader);
		bufferedReader.setInputHistory(new ArrayList<String>(Arrays.asList("3")));
		ui.askBoardSize();
		assertEquals("3", bufferedReader.readLine());
	}
	
	@Test
	public void returnsTrueIfInvalidPlayer() {
		assertTrue(ui.invalidPlayerOptionInput("g"));
	}
	
	@Test
	public void returnsFalseIfValidPlayer() {
		assertFalse(ui.invalidPlayerOptionInput("c"));
	}
	
	@Test
	public void returnsTrueIfInvalidBoardSize() {
		assertTrue(ui.invalidBoardSize(5));
	}
	
	@Test
	public void returnsFalseIfValidBoardSize() {
		assertFalse(ui.invalidBoardSize(3));
	}
	
	@Test
	public void getsPlayerInput() throws IOException {
		MockBufferedReader bufferedReader = new MockBufferedReader(new InputStreamReader(ui.input));
		ui.setBufferedReader(bufferedReader);
		bufferedReader.setInputHistory(new ArrayList<String>(Arrays.asList("3")));
		ui.getPlayerInput();
		assertEquals("3", bufferedReader.readLine());
	}
	
	@Test
	public void getsPlayerMove() throws NumberFormatException, IOException {
		MockBufferedReader bufferedReader = new MockBufferedReader(new InputStreamReader(ui.input));
		ui.setBufferedReader(bufferedReader);
		bufferedReader.setInputHistory(new ArrayList<String>(Arrays.asList("3")));
		ui.askPlayerMove();
		assertEquals("3", bufferedReader.readLine());
	}
	
	@Test
	public void returnsFalseIfValidMove() {
		assertFalse(ui.invalidPlayerMove(5));
	}
	
	@Test
	public void askUsersForPlayAgain() throws IOException {
		MockBufferedReader bufferedReader = new MockBufferedReader(new InputStreamReader(ui.input));
		ui.setBufferedReader(bufferedReader);
		bufferedReader.setInputHistory(new ArrayList<String>(Arrays.asList("n")));
		ui.askPlayAgain();
		assertEquals("n", bufferedReader.readLine());
	}
	
	@Test
	public void printsMessageToUserToPlayAgain() {
		ui.askUserPlayAgain();
		assertEquals("Press 'y' to play again, press anything else to quit", printStream.lastOutput());
	}
	
	@Test
	public void displaysMessageForPlayerOption() {
		ui.askPlayerOption("one");
		assertEquals("Please choose player one type('h' or 'c'): ", printStream.lastOutput());
	}
}
