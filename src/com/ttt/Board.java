package com.ttt;

import java.util.ArrayList;

public class Board {
	private int size;
	private String spaces = "";
	
	public Board(int size) {
		this.size = size;
		createSpaces();
	}
	
	public void createSpaces() {
		for(int i = 0; i < (size * size); i++) spaces += "-";
	}
	
	public void setMove(char marker, int move) {
		StringBuilder newSpaces = new StringBuilder(spaces);
		newSpaces.setCharAt(move - 1, marker);
		spaces = newSpaces.toString();
	}
	
	public void setMoves(char marker, int[] moves) {
		for (int move : moves) {
			StringBuilder newSpaces = new StringBuilder(spaces);
			newSpaces.setCharAt(move - 1, marker);
			spaces = newSpaces.toString();
		}
	}
	
	public ArrayList<Integer> getEmptySpaces() {
		ArrayList<Integer> emptySpaces = new ArrayList<Integer>(){};
		for(int index = 0; index < (size * size); index++)
			if ((spaces.charAt(index) == '-'))
				emptySpaces.add(index + 1);
		return emptySpaces;
	}
	
	public void undoMove(int index) {
		StringBuilder newSpaces = new StringBuilder(spaces);
		newSpaces.setCharAt(index-1, '-');
		spaces = newSpaces.toString();
	}
	
	public int getSize() {
		return size;
	}
	
	public String getSpaces() {
		return spaces;
	}
	
	public void setMove(char marker, String move) {
		if(!(move == ""))
			setMove(marker, Integer.parseInt(move));
	}
}
