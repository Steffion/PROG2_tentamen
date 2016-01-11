package nl.Steffion.Hangman.player;

public abstract class Player {
	private String name;
	
	public String getName() {
		return name;
	}
	
	public abstract void playGame();
	
	public void setName(String name) {
		this.name = name;
	}

}
