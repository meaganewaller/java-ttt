package com.ttt;

public class Game {
	private char[] board;

	public Game(String board) {
		this.board = board.toCharArray();
	}
	
	public String board() {
		return new String(board);
	}
	

}
