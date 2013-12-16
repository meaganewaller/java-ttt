package com.ttt;

import java.util.Scanner;
import static java.lang.System.out;

public class CommandLine implements UserInterface {
	private Scanner input;
	public int size;
	
	public CommandLine(Readable reader) {
		input = new Scanner(reader);
	}

	@Override
	public void welcomeMessage() {
		out.println("Welcome to Tic Tac Toe");
		
	}

	@Override
	public void endGame() {
		out.println("Good bye.");
	}

	@Override
	public void displayBoard(Board board) {
		for(int index=1; index < board.getSpaces().length() + 1; index++) {
			if(board.getSpaces().charAt(index-1) == '-') System.out.print(" " + index + " ");
			else System.out.print(" " + board.getSpaces().charAt(index - 1) + " ");
			
			if(index % board.getSize() == 0) System.out.println();
		}
		
		System.out.println();
	}

	@Override
	public void displayResult(String result) {
		if(result.equals("tie")) out.println("Game over. It's a tie");
		else out.println("Game over. " + result + " won");
	}

	@Override
	public String askFirstPlayerOption() {
		askPlayerOption("one");
		String userInput = getPlayerOptionInput();
		while(invalidPlayerOptionInput(userInput)) {
			out.println("Please enter correct player type('h' or 'c'): ");
			userInput = getPlayerOptionInput();
		}
		return userInput;
	}

	@Override
	public String askSecondPlayerOption() {
		askPlayerOption("two");
		String userInput = getPlayerOptionInput();
		while(invalidPlayerOptionInput(userInput)) {
			out.println("Please enter correct player type('h' or 'c'):");
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
		out.println("Enter your move: ");
		while(!input.hasNextInt()) {
			out.println("Please enter a valid move: ");
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
			out.println("Please choose (y/n): ");
			userInput = input.nextLine().toLowerCase();
		}
		return userInput.equals("y");
	}
	
	public void askUserPlayAgain() {
		out.println("Would you like to play again? Y/N: ");
	}
	
	public void askPlayerOption(String player) {
		out.println("Please choose player " + player + " type('h' or 'c'): ");
	}
	
	@Override
	public int askBoardSize() {
		int userInput;
		out.println("Enter board size(3 or 4): ");
		while(!input.hasNextInt()) {
			out.println("Please enter the board size(3 or 4): ");
			input.next();
		}
		
		userInput = input.nextInt();
		while(userInput != 3 && userInput != 4) {
			out.println("Please enter board size(3 or 4): ");
			userInput = input.nextInt();
		}
		
		this.size = userInput;
		return userInput;
		
	}
	
	

}
