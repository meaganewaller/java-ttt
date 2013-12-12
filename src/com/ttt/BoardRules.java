package com.ttt;

public class BoardRules {
	private Board board;
	private int[][] winningCombos;
	
	public BoardRules(Board board) {
		this.board = board;
		generateWinningCombos();
	}
	
	public void generateWinningCombos() {
		int[][] horizontalWin = getHorizontalCombos();
		int[][] verticalWin = getVerticalCombos();
		int[][] diagonalWin = getDiagonalCombos();
		
		winningCombos = new int[(board.getSize() * 2) + 2][];
		
		System.arraycopy(horizontalWin, 0, winningCombos, verticalWin.length, horizontalWin.length);
		System.arraycopy(verticalWin, 0, winningCombos, 0, verticalWin.length);
		System.arraycopy(diagonalWin, 0, winningCombos, horizontalWin.length + verticalWin.length, diagonalWin.length);
	}
	
	public void setBoard(Board board) {
		this.board = board;
	}
	
	public Board getBoard() {
		return board;
	}
	
	public char winner() {
		String spaces ="";
		for(int[] combo : winningCombos) {
			for(int space : combo ) spaces += getSpace(space);
			if(spaces.equals("XXXX") || spaces.equals("XXX")) return spaces.charAt(0);
			if(spaces.equals("OOOO") || spaces.equals("OOO")) return spaces.charAt(0);
			spaces ="";
		}
		return ' ';
	}
	
	public boolean tie() {
		return !hasWinner() && fullBoard();
	}
	
	public boolean fullBoard() {
		for(int index=0; index< board.getSpaces().length(); index++)
			if(board.getSpaces().charAt(index) == '-')
				return false;
		return true;
	}
	
	public int[][] getWinningCombos() {
		return winningCombos;
	}
	
	public int[][] getHorizontalCombos() {
		int length = board.getSize();
		int[][] horizontal = new int[length][length];
		int count = 1;
		for(int row=0; row < length; row++) {
			for(int col=0; col < length; col++) {
				horizontal[row][col] = count;
				count++;
			}
		}
		return horizontal;
	}
	
	public int[][] getVerticalCombos() {
		int length = board.getSize();
		int[][] vertical = new int[length][length];
		int count = 1;
		for(int row=0; row < length; row++) {
			for(int col=0; col < length; col++) {
				vertical[col][row] = count;
				count++;
			}
		}
		return vertical;
	}
	

	
	public int[][] getDiagonalCombos() {
		int length = board.getSize();
		int[][] diagonal = new int[2][length];
		int leftDiagonalCount = 1;
		int rightDiagonalCount = length;
		for(int col=0; col < length; col++) {
			diagonal[0][col] = leftDiagonalCount;
			diagonal[1][col] = rightDiagonalCount;
			leftDiagonalCount += length + 1;
			rightDiagonalCount += length - 1;
		}
		return diagonal;
	}
	
	public boolean hasWinner() {
		String spaces = "";
		for (int[] winningCombo : winningCombos) {
			for(int combo : winningCombo) spaces += getSpace(combo);
			if(spaces.equals("XXXX") || spaces.equals("XXX")) return true;
			if(spaces.equals("OOOO") || spaces.equals("OOO")) return true;
			spaces = "";
		}
		return false;
	}
	
	public char getSpace(int space) {
		return board.getSpaces().charAt(space - 1);
	}
	
	public boolean isOver() {
		return tie() || hasWinner();
	}
	
	public char currentPlayer(String board) {
		int vacantSpaces = board.replaceAll("[-]", "").length();
		if(vacantSpaces % 2 == 0) return 'X';
		else return 'O';


	}

}
