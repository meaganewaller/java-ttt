package com.ttt.mocks;

import com.ttt.Board;
import com.ttt.Player;

public class AIMock implements Player {
	private char marker;
	
	public AIMock(char marker) {
		this.marker = marker;
	}
	
	public char getMarker() {
		return marker;
	}
	
	public boolean isHuman() {
		return false;
	}
	
	public Board move(Board board, int index) {
		board.setSpaces("X---------");
		return board;
	}

}
