package com.ttt;

import java.io.PrintStream;
import java.util.Scanner;

import static java.lang.System.out;

public class CommandLine implements UserInterface {
	private Scanner input;
	PrintStream output = System.out;
	public int size;
	
	public CommandLine(Readable reader) {
		input = new Scanner(reader);
	}
	
	public void setOutput(PrintStream output) {
		this.output = output;
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
	public String askFirstPlayerOption() {
		askPlayerOption("one");
		String userInput = getPlayerOptionInput();
		while(invalidPlayerOptionInput(userInput)) {
			output.println("Please enter correct player type('h' or 'c'): ");
			userInput = getPlayerOptionInput();
		}
		return userInput;
	}

	@Override
	public String askSecondPlayerOption() {
		askPlayerOption("two");
		String userInput = getPlayerOptionInput();
		while(invalidPlayerOptionInput(userInput)) {
			output.println("Please enter correct player type('h' or 'c'):");
			userInput = getPlayerOptionInput();
		}
		return userInput;
	}
	
	public boolean invalidPlayerOptionInput(String input) {
		return !input.toLowerCase().equals("h") && !input.toLowerCase().equals("c");
	}

	@Override
	public String getPlayerOptionInput() {
		return input.nextLine();
	}

	@Override
	public String getBoardOptionInput() {
		return input.nextLine();
	}

	@Override
	public int askPlayerMove() {
		output.println("Enter your move: ");
		while(!input.hasNextInt()) {
			output.println("Please enter a valid move: ");
			input.next();
		}
		int userInput = input.nextInt();
		return userInput;
	}
	

	@Override
	public boolean askPlayAgain() {
		askUserPlayAgain();
		String userInput = input.nextLine().toLowerCase();
		while(!userInput.equals("n") && !userInput.equals("y")) {
			output.println("Please choose (y/n): ");
			userInput = input.nextLine().toLowerCase();
		}
		return userInput.equals("y");
	}
	
	public void askUserPlayAgain() {
		output.println("Would you like to play again? Y/N: ");
	}
	
	public void askPlayerOption(String player) {
		output.println("Please choose player " + player + " type('h' or 'c'): ");
	}
	
	@Override
	public int askBoardSize() {
		int userInput;
		output.println("Enter board size(3 or 4): ");
		while(!input.hasNextInt()) {
			out.println("Please enter the board size(3 or 4): ");
			input.next();
		}
		
		userInput = input.nextInt();
		while(userInput != 3 && userInput != 4) {
			output.println("Please enter board size(3 or 4): ");
			userInput = input.nextInt();
		}
		
		this.size = userInput;
		return userInput;
		
	}
}
