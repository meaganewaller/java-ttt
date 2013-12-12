package com.ttt;


public class HumanPlayer implements Player {
	private char marker;
	
	public HumanPlayer(char marker) {
		this.marker = marker;
	}
	
	public boolean isHuman() {
		return true;
	}
	
	public char getMarker() {
		return marker;
	}
	
	public Board move(Board board, int index) {
		board.setMove(marker, index);
		return board;
	}
	
	

}
