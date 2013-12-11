package com.ttt;

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
	
	public int getSize() {
		return size;
	}
	
	public String getSpaces() {
		return spaces;
	}
}
