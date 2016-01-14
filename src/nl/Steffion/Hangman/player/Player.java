package nl.Steffion.Hangman.player;

import nl.Steffion.Hangman.game.Game;

public abstract class Player {
	private String name;

	public abstract Game getGame();
	
	public String getName() {
		return name;
	}
	
	public abstract int getScore();
	
	public abstract void playGame();

	public abstract void reset();
	
	public void setName(String name) {
		this.name = name;
	}

}
