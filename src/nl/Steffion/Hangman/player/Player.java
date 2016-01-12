package nl.Steffion.Hangman.player;

import nl.Steffion.Hangman.game.Game;

public abstract class Player {
	private Game	game;
	private String	name;
					
	public Player() {
		game = new Game();
	}
	
	public Game getGame() {
		return game;
	}
	
	public String getName() {
		return name;
	}
	
	public int getScore() {
		return 10 - game.getAmountOfWrongGuesses();
	}

	public abstract void playGame();

	public void reset() {
		game = new Game();
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public void setName(String name) {
		this.name = name;
	}

}
