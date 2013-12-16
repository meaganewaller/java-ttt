package com.ttt;

public interface UserInterface {
	void welcomeMessage();
	void endGame();
	void displayBoard(Board board);
	void displayResult(String result);
	
	String askFirstPlayerOption();
	String askSecondPlayerOption();
	String getPlayerOptionInput();
	String getBoardOptionInput();
	
	int askBoardSize();
	int askPlayerMove();
	
	boolean askPlayAgain();

}
