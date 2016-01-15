package nl.Steffion.Hangman.player;

import nl.Steffion.Hangman.game.Game;
import nl.Steffion.Hangman.game.GameHuman;

/**
 * 
 * @author Steffion (Stef de Goey) 2016
 *
 */

public class PlayerHuman extends Player {
	private GameHuman game;
	
	public PlayerHuman() {
		game = new GameHuman();
	}
	
	@Override
	public Game getGame() {
		return game;
	}
	
	@Override
	public int getScore() {
		return 10 - game.getAmountOfWrongGuesses();
	}

	@Override
	public void playGame() {
		game.playGame(this);
	}

	@Override
	public void reset() {
		game = new GameHuman();
	}

}
