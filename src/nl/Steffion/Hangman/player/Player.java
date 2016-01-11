package nl.Steffion.Hangman.player;

import nl.Steffion.Hangman.game.Game;

public abstract class Player {
	private Game	game;
	private String	name;
					
	public Game getGame() {
		return game;
	}

	public String getName() {
		return name;
	}

	public abstract void playGame();
	
	public void setGame(Game game) {
		this.game = game;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
}
