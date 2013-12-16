package com.ttt;

import java.util.Hashtable;

public class Game {
	private Board board;
	private Player firstPlayer, secondPlayer;
	private UserInterface ui;
	private BoardRules boardState;

	public Game(UserInterface ui) {
		this.ui = ui;
	}
	
	public Game(UserInterface ui, Hashtable<String, String> config) {
		this.ui = ui;
		board = new Board(Integer.parseInt(config.get("boardSize")));
		board.setSpaces(config.get("board"));
		boardState = new BoardRules(board);
		firstPlayer = getPlayer(config.get("firstPlayer"), 'X');
		secondPlayer = getPlayer(config.get("secondPlayer"), 'O');
	}
	
	public Board getBoard() {
		return board;
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
	
	public void askFirstPlayer() {
		String first = ui.askFirstPlayerOption();
		firstPlayer = getPlayer(first, 'X');
	}
	
	public void askSecondPlayer() {
		String second = ui.askSecondPlayerOption();
		secondPlayer = getPlayer(second, 'O');
	}
	
	public Player getPlayer(String input, char marker) {
		Player player;
		if(input.equals("h")) player = new HumanPlayer(marker);
		else player = new ComputerPlayer(marker);
		return player;
	}
	
	public void askBoardSize() {
		int boardSize=  ui.askBoardSize();
		board = new Board(boardSize);
		boardState = new BoardRules(board);
	}
	
	public void startGame() {
		ui.welcomeMessage();
		askSettings();
		ui.displayBoard(board);
	}
	
	public void askSettings() {
		askFirstPlayer();
		askSecondPlayer();
		askBoardSize();
	}
	
	public void endGame() {
		ui.displayResult(result());
		ui.displayBoard(board);
		if(ui.askPlayAgain()) {
			playGame();
		}
		ui.endGame();
	}

	private String result() {
		if(boardState.tie()) return "tie";
		else return String.valueOf(boardState.winner());
	}
	
	public void playGame() {
		startGame();
		while(!boardState.isOver()) makePlayerMoves();
		endGame();
	}
	
	public void makePlayerMoves() {
		if(makePlayerMove(firstPlayer) && !boardState.isOver()) {
			ui.displayBoard(board);
			makePlayerMove(secondPlayer);
		}
		if(!boardState.isOver()) ui.displayBoard(board);
	}
	
	public boolean makePlayerMove(Player player) {
		if(player.isHuman()) {
			board = player.move(board, ui.askPlayerMove());
		} else {
			board = player.move(board,  0);
		}
		return true;
	}
	
	public BoardRules getBoardRules() {
		return boardState;
	}
	
	private void makeMove(Player player, String move) {
		if(player.isHuman()) board = player.move(board, Integer.parseInt(move));
		else board = player.move(board, 0);
	}
	
	public static Board playGame(UserInterface ui, Hashtable<String, String> config, String move) {
		Game game = new Game(ui, config);
		Player player = currentPlayer(game);
		if(game.board.isEmpty() && player.isHuman()) {
			game.board.setMove(player.getMarker(), move);
		} else if(game.getBoardRules().isOver()) {
			game.ui.displayResult(game.result());
		} else {
			game.makeMove(player, move);
			if(game.getBoardRules().isOver()) {
				game.ui.displayResult(game.result());
			}
		}
		return game.getBoard();
	}
	
	private static Player currentPlayer(Game game) {
		char marker = game.getBoardRules().currentPlayer(game.board.getSpaces());
		if(marker == 'X') return game.firstPlayer;
		else return game.secondPlayer;
	}

}
