package com.ttt;

import java.io.IOException;

public interface UserInterface {
	void welcomeMessage();
	void endGame();
	void displayBoard(Board board);
	void displayResult(String result);
	
	String askFirstPlayerOption() throws IOException;
	String askSecondPlayerOption() throws IOException;
	String getPlayerOptionInput() throws IOException;
	String getBoardOptionInput() throws IOException;
	
	int askBoardSize() throws NumberFormatException, IOException;
	int askPlayerMove() throws NumberFormatException, IOException;
	
	boolean askPlayAgain() throws IOException;

}
