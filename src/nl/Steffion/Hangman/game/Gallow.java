package nl.Steffion.Hangman.game;

public class Gallow {
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
