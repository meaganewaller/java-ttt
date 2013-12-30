package com.ttt;

import java.util.Arrays;
import java.util.List;

public class Validations {
	public boolean isPlayerOptionInvalid(String input) { 
		if(input.equals("c") || input.equals("h")) return false;
		return true;
	}
	
	public int boardSize(String input) {
		return Integer.parseInt(input);
	}
	
	public boolean validBoardSize(int input) {
		if(input == 3 || input == 4) return true;
		return false;
	}
	
	public int parsePlayerMove(String input) {
		return Integer.parseInt(input);
	}
	
	public boolean isPlayerMoveValid(int move) {
		List<Integer> possibleMoves = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16);
		if(possibleMoves.contains(move))
			return true;
		return false;
	}
	
	public boolean isUserPlayingAgain(String input) {
		if(input.equals("y")) return true;
		return false;
	}

}
