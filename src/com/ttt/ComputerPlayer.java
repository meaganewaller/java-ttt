package com.ttt;

public class ComputerPlayer implements Player {
	public char marker;
	
	public ComputerPlayer(char marker) {
		this.marker = marker;
	}
	
	public char getMarker() {
		return marker;
	}
	
	public boolean isHuman() {
		return false;
	}
	
	public Board move(Board board, int index) {
		UnbeatableAI ai = new UnbeatableAI(marker);
		int move = ai.findMove(board);
		board.setMove(marker, move);
		return board;
	}

	

}
