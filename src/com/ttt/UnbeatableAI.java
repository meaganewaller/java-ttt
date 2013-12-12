package com.ttt;

public class UnbeatableAI implements AI {

	private char marker;
	public UnbeatableAI(char marker) {
		this.marker = marker;
	}
	
	public int findMove(Board board) {
		return 0;
	}
	
	public int findValue(Board board) {
		return 100;
	}
	

}
