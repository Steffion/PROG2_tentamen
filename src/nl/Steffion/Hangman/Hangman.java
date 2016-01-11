package nl.Steffion.Hangman;

import java.util.Random;

import nl.Steffion.Hangman.player.PlayerComputer;
import nl.Steffion.Hangman.player.PlayerHuman;

public class Hangman {

	private Match match;

	public Hangman() {
		match = new Match();
	}

	public void play() {
		System.out.println("Welkom bij Galgje!");
		System.out.println();

		ConsoleIO io = new ConsoleIO();
		
		/*
		 * Ask name of first player, or initiate as computer player.
		 */
		System.out.print("Geef de naam van speler 1 (of C voor een computer): ");
		boolean validAnswerGiven = false;
		while (!validAnswerGiven) {
			String answer = io.readInput();
			
			if ((answer == null) || answer.isEmpty()) {
				System.out.println("*** Please enter something! ***");
				continue;
			} else if (answer.equalsIgnoreCase("C")) {
				match.setPlayer1(new PlayerComputer());
				match.getPlayer1().setName("Computer");
			} else {
				match.setPlayer1(new PlayerHuman());
				match.getPlayer1().setName(answer);
			}
			
			validAnswerGiven = true;
		}
		
		/*
		 * Ask name of second player, or initiate as computer player.
		 */
		System.out.print("Geef de naam van speler 2 (of C voor een computer): ");
		validAnswerGiven = false;
		while (!validAnswerGiven) {
			String answer = io.readInput();
			
			if ((answer == null) || answer.isEmpty()) {
				System.out.println("*** Vul alstublieft iets in! ***");
				continue;
			} else if (answer.equalsIgnoreCase("C")) {
				match.setPlayer2(new PlayerComputer());
				match.getPlayer2().setName("Computer");
				
				if (match.getPlayer1().getName().equals("Computer")) {
					match.getPlayer1().setName("Computer (1)");
					match.getPlayer2().setName("Computer (2)");
				}
			} else {
				match.setPlayer2(new PlayerHuman());
				match.getPlayer2().setName(answer);
			}
			
			validAnswerGiven = true;
		}
		
		/*
		 * Choose random player to begin.
		 */
		Random random = new Random();
		
		System.out.print("De loting is verricht: ");
		if (random.nextBoolean()) {
			System.out.println(match.getPlayer1().getName() + " begint.");
			match.getPlayer1().playGame();
		} else {
			System.out.println(match.getPlayer2().getName() + " begint.");
			match.getPlayer2().playGame();
		}
	}

	public void playAgain() {
	
	}

}
