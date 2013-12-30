package com.ttt;

import java.io.IOException;

public class GameRunner {
	public static void main(String[] args) throws IOException {
		CommandLine ui = new CommandLine();
		Game game = new Game(ui);
		game.playGame();
	}

}
