package com.ttt;

import java.util.ArrayList;

public class UnbeatableAI implements AI {
	private BoardRules boardRules;
	private char marker;
	private int MAX_SCORE = 100;
	private int MIN_SCORE = -100;
	private int TIED_SCORE = 0;


	public UnbeatableAI(char marker) {
		this.marker = marker;
	}
	
	public int findMove(Board board) {
		char opponentMarker = getOpponentMarker(marker);
		int bestScore = MIN_SCORE;
		int bestSpace = 0;
		
		ArrayList<Integer> emptySpaces = board.getEmptySpaces();
		for(Integer emptySpace : emptySpaces) {
			board.setMove(marker, emptySpace);
			int score = miniMax(board, opponentMarker, 0, -1, false, MIN_SCORE, MAX_SCORE);

			board.undoMove(emptySpace);
			if(score > bestScore) {
				bestScore = score;
				bestSpace = emptySpace;
			}
		}
		return bestSpace;
	}
	
	public int findValue(Board board) {
		return miniMax(board, getOpponentMarker(marker), 0, -1, false, MIN_SCORE, MAX_SCORE);
	}
	
	private char getOpponentMarker(char marker) {
		if(marker == 'X') return 'O';
		else return 'X';
	}

	private int miniMax(Board board, char marker, int depth, int color, boolean max, int alpha, int beta) {
		char opponentMarker = getOpponentMarker(marker);
		boardRules = new BoardRules(board);
		if(boardRules.isOver() || depth == 7) return getBoardScore(board, depth, marker) * color;
		else if(max) {
			ArrayList<Integer> emptySpaces = board.getEmptySpaces();
			for(Integer emptySpace : emptySpaces) {
				board.setMove(marker, emptySpace);
				alpha = Math.max(alpha, miniMax(board, opponentMarker, depth + 1, -color, !max, alpha, beta));
				board.undoMove(emptySpace);
				if(alpha >= beta) break;
			}
			return alpha;
		} else {
			ArrayList<Integer> emptySpaces = board.getEmptySpaces();
			for(Integer emptySpace : emptySpaces) {
				board.setMove(marker, emptySpace);
				beta = Math.min(beta, miniMax(board, opponentMarker, depth + 1, -color, !max, alpha, beta));
				board.undoMove(emptySpace);
				if(alpha >= beta) break;
			}
			return beta;
		}
	}

	private int getBoardScore(Board board, int depth, char marker) {
		boardRules = new BoardRules(board);
		if (boardRules.winner() == marker) return MAX_SCORE + depth;
		else if (boardRules.tie()) return TIED_SCORE;
		else return MIN_SCORE + depth;
	}

	
	

}
