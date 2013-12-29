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
		String userInput = getPlayerOptionInput();
		while(invalidPlayerOptionInput(userInput)) {
			output.println("Please enter correct player type('h' or 'c'): ");
			userInput = getPlayerOptionInput();
		}
		return userInput;
	}

	@Override
	public String askSecondPlayerOption() throws IOException {
		askPlayerOption("two");
		String userInput = getPlayerOptionInput();
		while(invalidPlayerOptionInput(userInput)) {
			output.println("Please enter correct player type('h' or 'c'):");
			userInput = getPlayerOptionInput();
		}
		return userInput;
	}
	
	@Override
	public int askBoardSize() throws NumberFormatException, IOException {
		output.println("Enter board size(3 or 4): ");
		String userInput = bufferedReader.readLine();
		int boardSize = validate.boardSize(userInput);
		if(!validate.validBoardSize(boardSize))
			output.println("Enter the board size(3 or 4): ");
			userInput = bufferedReader.readLine();
		this.size = boardSize;
		return boardSize;
	}
	
	public boolean invalidPlayerOptionInput(String input) {
		return validate.isPlayerOptionInvalid(input);
	}

	@Override
	public String getPlayerOptionInput() throws IOException {
		return bufferedReader.readLine();
	}

	@Override
	public String getBoardOptionInput() throws IOException {
		return bufferedReader.readLine();
	}

	@Override
	public int askPlayerMove() throws NumberFormatException, IOException {
		output.println("Enter your move: ");
		String userInput = bufferedReader.readLine();
		int move = validate.parsePlayerMove(userInput);
		while(!validPlayerMove(move)) {
			output.println("Please enter a valid move: ");
			userInput = getPlayerMove();
		}	
		return move;
	}

	
	public boolean validPlayerMove(int move) {
		return validate.isPlayerMoveValid(move);
	}
	
	public String getPlayerMove() throws IOException {
		return bufferedReader.readLine();
	}
	

	@Override
	public boolean askPlayAgain() throws IOException {
		askUserPlayAgain();
		String userInput = bufferedReader.readLine().toLowerCase();
		while(!validate.isUserPlayingAgain(userInput)) {
			output.println("Please choose (y/n): ");
			userInput = bufferedReader.readLine().toLowerCase();
		}
		return userInput.equals("y");
	}
	
	public void askUserPlayAgain() {
		output.println("Would you like to play again? Y/N: ");
	}
	
	public void askPlayerOption(String player) {
		output.println("Please choose player " + player + " type('h' or 'c'): ");
	}
	
	
}
