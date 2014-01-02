package com.ttt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;


public class CommandLine implements UserInterface {
	PrintStream output = System.out;
	InputStream input = System.in;
	BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(input));
	Validations validate = new Validations();

	public int size;
	
	public void setOutput(PrintStream output) {
		this.output = output;
	}
	
	public void setBufferedReader(BufferedReader bufferedReader) {
		this.bufferedReader = bufferedReader;
	}

	@Override
	public void welcomeMessage() {
		output.println("Welcome to Tic Tac Toe");
	}

	@Override
	public void endGame() {
		output.println("Good bye.");
	}

	@Override
	public void displayBoard(Board board) {
		for(int index=1; index < board.getSpaces().length() + 1; index++) {
			if(board.getSpaces().charAt(index-1) == '-') output.print(" " + index + " ");
			else output.print(" " + board.getSpaces().charAt(index - 1) + " ");
			
			if(index % board.getSize() == 0) output.println();
		}
		output.println();
	}

	@Override
	public void displayResult(String result) {
		if(result.equals("tie")) output.println("Game over. It's a tie");
		else output.println("Game over. " + result + " won");
	}

	@Override
	public String askFirstPlayerOption() throws IOException {
		askPlayerOption("one");
		String userInput = getPlayerInput();
		while(invalidPlayerOptionInput(userInput)) {
			output.println("Please enter correct player type('h' or 'c'): ");
			userInput = getPlayerInput();
		}
		return userInput;
	}

	@Override
	public String askSecondPlayerOption() throws IOException {
		askPlayerOption("two");
		String userInput = getPlayerInput();
		while(invalidPlayerOptionInput(userInput)) {
			output.println("Please enter correct player type('h' or 'c'):");
			userInput = getPlayerInput();
		}
		return userInput;
	}
	
	@Override
	public int askBoardSize() throws NumberFormatException, IOException {
		output.println("Enter board size(3 or 4): ");
		String userInput = getPlayerInput();
		int boardSize = validate.boardSize(userInput);
		while(invalidBoardSize(boardSize)) {
			output.println("Enter the board size(3 or 4): ");
			userInput = getPlayerInput();
		}
		this.size = boardSize;
		return boardSize;
	}
	
	public String getPlayerInput() throws IOException {
		return bufferedReader.readLine();
	}

	public boolean invalidPlayerOptionInput(String input) {
		return validate.isPlayerOptionInvalid(input);
	}
	
	public boolean invalidBoardSize(int size) {
		return validate.isBoardSizeInvalid(size);
	}

	@Override
	public int askPlayerMove() throws NumberFormatException, IOException {
		output.println("Enter your move: ");
		String userInput = getPlayerInput();
		int move = validate.parsePlayerMove(userInput);
		while(invalidPlayerMove(move)) {
			output.println("Please enter a valid move: ");
			userInput = getPlayerInput();
		}	
		return move;
	}

	
	public boolean invalidPlayerMove(int move) {
		return validate.isPlayerMoveInvalid(move);
	}
	

	@Override
	public boolean askPlayAgain() throws IOException {
		askUserPlayAgain();
		String userInput = getPlayerInput().toLowerCase();
		return validate.isUserPlayingAgain(userInput);
	}
	
	public void askUserPlayAgain() {
		output.println("Press 'y' to play again, press anything else to quit");
	}
	
	public void askPlayerOption(String player) {
		output.println("Please choose player " + player + " type('h' or 'c'): ");
	}

	@Override
	public void enterValidMove() {
		output.println("Please enter a valid move");
	}
	
	
}
