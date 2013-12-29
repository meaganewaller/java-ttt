package com.ttt;

import java.io.IOException;

public class Game {
	private Board board;
	private Player firstPlayer, secondPlayer;
	private UserInterface ui;
	private BoardRules boardRules;

	public Game(UserInterface ui) {
		this.ui = ui;
	}
	
	public void playGame() throws IOException {
		startGame();
		while(!boardRules.isOver()) makePlayerMoves();
		endGame();
	}
	
	public void startGame() throws IOException {
		ui.welcomeMessage();
		askSettings();
		ui.displayBoard(board);
	}
	
	public void makePlayerMoves() throws NumberFormatException, IOException {
		if(makePlayerMove(firstPlayer) && !boardRules.isOver()) {
			ui.displayBoard(board);
			makePlayerMove(secondPlayer);
		}
		if(!boardRules.isOver()) ui.displayBoard(board);
	}
	
	public boolean makePlayerMove(Player player) throws NumberFormatException, IOException {
		if(player.isHuman()) {
			board = player.move(board, ui.askPlayerMove());
		} else {
			board = player.move(board,  0);
		}
		return true;
	}
	
	public void askSettings() throws IOException {
		askFirstPlayer();
		askSecondPlayer();
		askBoardSize();
	}
	
	public void askFirstPlayer() throws IOException {
		String first = ui.askFirstPlayerOption();
		firstPlayer = getPlayer(first, 'X');
	}
	
	public void askSecondPlayer() throws IOException {
		String second = ui.askSecondPlayerOption();
		secondPlayer = getPlayer(second, 'O');
	}
	
	public void askBoardSize() throws NumberFormatException, IOException {
		int boardSize=  ui.askBoardSize();
		board = new Board(boardSize);
		boardRules = new BoardRules(board);
	}
	
	public Player getPlayer(String input, char marker) {
		Player player;
		if(input.equals("h")) player = new HumanPlayer(marker);
		else player = new ComputerPlayer(marker);
		return player;
	}
	
	public void endGame() throws IOException {
		ui.displayResult(result());
		ui.displayBoard(board);
		if(ui.askPlayAgain()) {
			playGame();
		}
		ui.endGame();
	}

	private String result() {
		if(boardRules.tie()) return "tie";
		else return String.valueOf(boardRules.winner());
	}
	
	public Board getBoard() {
		return board;
	}
	
	public BoardRules getBoardRules() {
		return boardRules;
	}
	
	public Player getFirstPlayer() {
		return firstPlayer;
	}
	
	public Player getSecondPlayer() {
		return secondPlayer;
	}
	
	public UserInterface getUI() {
		return ui;
	}

}
