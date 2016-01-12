package nl.Steffion.Hangman;

public class Hangman {
	
	private Match match;
	
	public Hangman() {
		match = new Match();
	}
	
	public void play() {
		System.out.println("Welkom bij Galgje!");
		System.out.println();
		
		match.init();
		match.start();
	}
	
	public void playAgain() {

	}
	
}
