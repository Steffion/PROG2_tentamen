package nl.Steffion.Hangman.player;

import nl.Steffion.Hangman.game.Game;

/**
 * 
 * @author Steffion (Stef de Goey) 2016
 *
 */

public abstract class Player {
	private String name;

	public abstract Game getGame();
	
	/**
	 * Returns the name of the player.
	 * 
	 * @return String with name
	 */
	public String getName() {
		return name;
	}
	
	public abstract int getScore();
	
	public abstract void playGame();

	public abstract void reset();
	
	/**
	 * Set the name of this player.
	 * 
	 * @param name - String with name
	 */
	public void setName(String name) {
		this.name = name;
	}

}
