package com.ttt;

public interface Player {
	char getMarker();
	boolean isHuman();
	Board move(Board board, int index);
}
