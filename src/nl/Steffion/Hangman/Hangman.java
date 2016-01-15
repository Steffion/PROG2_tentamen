package nl.Steffion.Hangman;

/**
 * The main class for the game.
 * 
 * @author Steffion (Stef de Goey) 2016
 *
 */

public class Hangman {
	
	private Match match;
	
	public Hangman() {
		match = new Match();
	}
	
	/**
	 * Starts the game.
	 */
	public void play() {
		System.out.println("Welkom bij Galgje!");
		System.out.println();
		
		match.init();
		match.start();
		
		while (true) {
			ConsoleIO io = new ConsoleIO();
			
			System.out.println("Wil je nog een keer spelen (ja/nee)?");
			switch (io.readInput()) {
				case "ja":
					System.out.println();
					playAgain();
					continue;
				case "nee":
					System.out.println();
					System.out.println("Bedankt voor het spelen van Galgje.");
					System.out.println("Hopelijk tot een volgende keer!");
					System.exit(0);
					break;
				default:
					System.out.println("*** Geef alstublieft een geldig antwoord! (ja/nee) ***");
					continue;
			}

			break;
		}
	}
	
	/**
	 * Reset game and starts the game.
	 */
	public void playAgain() {
		match.reset();
		match.start();
	}

}
