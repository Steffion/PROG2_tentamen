package nl.Steffion.Hangman;

import java.util.Random;

import nl.Steffion.Hangman.player.Player;
import nl.Steffion.Hangman.player.PlayerComputer;
import nl.Steffion.Hangman.player.PlayerHuman;

/**
 * The Match class.
 * This class requests the names and tells what player starts.
 * 
 * @author Steffion (Stef de Goey) 2016
 *
 */

public class Match {
	private int		charachterDifficulty;
	private Player	player1;
	private Player	player2;
					
	/**
	 * Get the length of the words used in the game.
	 * Referred as 'difficulty'.
	 * 
	 * @return length of word
	 */
	public int getCharachterDifficulty() {
		return charachterDifficulty;
	}
	
	/**
	 * Request names from players and request the difficulty.
	 */
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

		/*
		 * Ask with how many characters the player wants to play with.
		 */
		System.out.print("Met hoeveel karakters wil je het spel spelen? [10|11|12|13]: ");
		while (true) {
			switch (io.readInput()) {
				case "10":
					charachterDifficulty = 10;
					break;
				case "11":
					charachterDifficulty = 11;
					break;
				case "12":
					charachterDifficulty = 12;
					break;
				case "13":
					charachterDifficulty = 13;
					break;
				default:
					System.out.println("*** Vul alstublieft 10, 11, 12 of 13 in! ***");
					continue;
			}

			player1.getGame().setCharachterDifficulty(charachterDifficulty);
			player2.getGame().setCharachterDifficulty(charachterDifficulty);
			break;
		}
	}
	
	/**
	 * Resets the match.
	 * When you want to play another match.
	 */
	public void reset() {
		player1.reset();
		player2.reset();
		player1.getGame().setCharachterDifficulty(charachterDifficulty);
		player2.getGame().setCharachterDifficulty(charachterDifficulty);
	}
	
	/**
	 * Starts the match.
	 */
	public void start() {
		/*
		 * Choose random player to begin.
		 */
		Random random = new Random();

		System.out.print("De loting is verricht: ");
		if (random.nextBoolean()) {
			System.out.println(player1.getName() + " begint.");
			player1.playGame();
			System.out.println("Nu is het de beurt aan: " + player2.getName());
			player2.playGame();
		} else {
			System.out.println(player2.getName() + " begint.");
			player2.playGame();
			System.out.println("Nu is het de beurt aan: " + player1.getName());
			player1.playGame();
		}

		/*
		 * Display winner and their score.
		 */
		Player winner;
		String score = player1.getScore() + "-" + player2.getScore();

		if (player1.getScore() == player2.getScore()) {
			System.out.println("Er is geen winnaar! Er is gelijk gespeeld met " + score);
			return;
		} else if (player1.getScore() > player2.getScore()) {
			winner = player1;
		} else {
			winner = player2;
		}

		System.out.println("Speler " + winner.getName() + " heeft gewonnen met " + score);
	}

}
