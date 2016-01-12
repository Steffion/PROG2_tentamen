package nl.Steffion.Hangman;

import java.util.Random;

import nl.Steffion.Hangman.player.Player;
import nl.Steffion.Hangman.player.PlayerComputer;
import nl.Steffion.Hangman.player.PlayerHuman;

public class Match {
	private Player	player1;
	private Player	player2;

	public void init() {
		ConsoleIO io = new ConsoleIO();

		/*
		 * Ask name of first player, or initiate as computer player.
		 */
		System.out.print("Geef de naam van speler 1 (of C voor een computer): ");
		while (true) {
			String answer = io.readInput();

			if ((answer == null) || answer.isEmpty()) {
				System.out.println("*** Please enter something! ***");
				continue;
			} else if (answer.equalsIgnoreCase("C")) {
				player1 = new PlayerComputer();
				player1.setName("Computer");
			} else {
				player1 = new PlayerHuman();
				player1.setName(answer);
			}
			
			break;
		}

		/*
		 * Ask name of second player, or initiate as computer player.
		 */
		System.out.print("Geef de naam van speler 2 (of C voor een computer): ");
		while (true) {
			String answer = io.readInput();

			if ((answer == null) || answer.isEmpty()) {
				System.out.println("*** Vul alstublieft iets in! ***");
				continue;
			} else if (answer.equalsIgnoreCase("C")) {
				player2 = new PlayerComputer();
				player2.setName("Computer");

				if (player1.getName().equals("Computer")) {
					player1.setName("Computer (1)");
					player2.setName("Computer (2)");
				}
			} else {
				player2 = new PlayerHuman();
				player2.setName(answer);
			}
			
			break;
		}
	}

	public void start() {
		/*
		 * Choose random player to begin.
		 */
		Random random = new Random();
		
		System.out.print("De loting is verricht: ");
		if (random.nextBoolean()) {
			System.out.println(player1.getName() + " begint.");
			player1.playGame();
		} else {
			System.out.println(player1.getName() + " begint.");
			player1.playGame();
		}
	}
}
