package com.ttt.mocks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;

import com.ttt.Board;
import com.ttt.UserInterface;

public class MockCommandLine implements UserInterface {
	PrintStream output = System.out;
	public InputStream input = System.in;
	BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(input));
	public int size;
	
	public void setOutput(PrintStream output) {
		this.output = output;
	}
	
	public void setBufferedReader(BufferedReader bufferedReader) {
		this.bufferedReader = bufferedReader;
	}
	
	

	


	@Override
	public void welcomeMessage() {
		
	}

	@Override
	public void endGame() {
		
	}

	@Override
	public void displayBoard(Board board) {
		
	}

	@Override
	public void displayResult(String result) {
		
	}

	@Override
	public String askFirstPlayerOption() throws IOException {
		return "h";
	}

	@Override
	public String askSecondPlayerOption() throws IOException {
		return "h";
	}

	@Override
	public int askBoardSize() throws NumberFormatException, IOException {
		return 3;
	}

	@Override
	public int askPlayerMove() throws NumberFormatException, IOException {
		return Integer.parseInt(bufferedReader.readLine());
	}

	@Override
	public boolean askPlayAgain() throws IOException {
		return false;
	}

}
