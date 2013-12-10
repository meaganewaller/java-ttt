package com.ttt;

public class Board {
	int size;
	int[][] spaceValues;
	
	public Board() {
		size = 3;
		spaceValues = new int[size][size];
	}
	
	public int spaceValue(int[] space) {
		return spaceValues[space[0]][space[1]];
	}
	
	public void setSpaceValue(int[] space, int value) {
		spaceValues[space[0]][space[1]] = value;
	}
	
	
	
}
