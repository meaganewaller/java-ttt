package com.ttt;

import java.io.InputStreamReader;
import java.io.Reader;

public class GameRunner {
	public static void main(String[] args) {
		Reader reader = new InputStreamReader(System.in);
		CommandLine ui = new CommandLine(reader);
		Game game = new Game(ui);
		game.playGame();
	}

}
