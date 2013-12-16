package com.ttt.mocks;

import java.util.Scanner;

import com.ttt.Board;
import com.ttt.UserInterface;

public class MockUI implements UserInterface {
	public Scanner input;
	
	public MockUI(Readable reader) {
		input = new Scanner(reader);
	}
	
	public void welcomeMessage() {
	}
	
	public void endGame() {
	}
	
	public String askFirstPlayerOption() {
		return "h";
	}
	
	public String askSecondPlayerOption() {
		return "h";
	}
	
	public int askBoardSize() {
		return 3;
	}
	
	public String getPlayerOptionInput() {
		return "";
	}
	
	public String getBoardOptionInput() {
		return "";
	}
	
	public boolean askPlayAgain() {
		return false;
	}
	
	public int askPlayerMove() {
		return Integer.parseInt(input.nextLine());
	}
	
	public void displayBoard(Board board) {
	}
	
	public void displayResult(String result) {
		
	}

	

}
