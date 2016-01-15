package nl.Steffion.Hangman.game;

/**
 * This class is used to display the gallow.
 * 
 * @author Steffion (Stef de Goey) 2016
 *
 */

public class Gallow {
	
	/**
	 * Display the gallow.
	 * The state has to be between 1 and 10.
	 * 
	 * @param state - int between 1 and 10
	 */
	public void printGallow(int state) {
		if (state < 0 || state > 10) {
			System.out.println("Invalid state, state must be between 0 and 10!");
			return;
		}
		
		switch(state) {
			case 0:
				System.out.println("     ");
				System.out.println("     ");
				System.out.println("     ");
				System.out.println("     ");
				System.out.println("     ");
				System.out.println("|____");
				break;
			case 1:
				System.out.println("     ");
				System.out.println("|    ");
				System.out.println("|    ");
				System.out.println("|    ");
				System.out.println("|    ");
				System.out.println("|____");
				break;
			case 2:
				System.out.println("____ ");
				System.out.println("|    ");
				System.out.println("|    ");
				System.out.println("|    ");
				System.out.println("|    ");
				System.out.println("|____");
				break;
			case 3:
				System.out.println("____ ");
				System.out.println("|/   ");
				System.out.println("|    ");
				System.out.println("|    ");
				System.out.println("|    ");
				System.out.println("|____");
				break;
			case 4:
				System.out.println("____ ");
				System.out.println("|/ | ");
				System.out.println("|    ");
				System.out.println("|    ");
				System.out.println("|    ");
				System.out.println("|____");
				break;
			case 5:
				System.out.println("____ ");
				System.out.println("|/ | ");
				System.out.println("|  O ");
				System.out.println("|    ");
				System.out.println("|    ");
				System.out.println("|____");
				break;
			case 6:
				System.out.println("____ ");
				System.out.println("|/ | ");
				System.out.println("|  O ");
				System.out.println("|  | ");
				System.out.println("|    ");
				System.out.println("|____");
				break;
			case 7:
				System.out.println("____ ");
				System.out.println("|/ | ");
				System.out.println("|  O ");
				System.out.println("| /| ");
				System.out.println("|    ");
				System.out.println("|____");
				break;
			case 8:
				System.out.println("____ ");
				System.out.println("|/ | ");
				System.out.println("|  O ");
				System.out.println("| /|\\");
				System.out.println("|    ");
				System.out.println("|____");
				break;
			case 9:
				System.out.println("____ ");
				System.out.println("|/ | ");
				System.out.println("|  O ");
				System.out.println("| /|\\");
				System.out.println("| /  ");
				System.out.println("|____");
				break;
			case 10:
				System.out.println("____ ");
				System.out.println("|/ | ");
				System.out.println("|  O ");
				System.out.println("| /|\\");
				System.out.println("| / \\");
				System.out.println("|____");
				break;
				
		}
	}
	
}
