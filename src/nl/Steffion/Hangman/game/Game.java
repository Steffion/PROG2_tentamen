package nl.Steffion.Hangman.game;

import java.util.ArrayList;

import nl.Steffion.Hangman.player.Player;

/**
 * 
 * @author Steffion (Stef de Goey) 2016
 *
 */

public abstract class Game {

	protected int					charachterDifficulty;
	private Gallow					gallow;
	protected ArrayList<Character>	guessedCharacters;
	protected String				word;
									
	public Game() {
		gallow = new Gallow();
		guessedCharacters = new ArrayList<Character>();
		word = "";
	}
	
	/**
	 * Add character that has been guessed to the ArrayList.
	 * 
	 * @param character- to be added character
	 */
	public void addGuessedCharacter(Character character) {
		guessedCharacters.add(character);
	}
	
	/**
	 * Returns the amount of wrong guessed characters.
	 * 
	 * @return amount wrong guessed characters
	 */
	public int getAmountOfWrongGuesses() {
		int amount = 0;
		for (Character character : guessedCharacters) {
			if (!word.contains(character.toString())) {
				amount++;
			}
		}
		
		return amount;
	}

	/**
	 * Returns a String of wrong guessed characters.
	 * 
	 * @return String with wrong guessed characters
	 */
	public String getWrongGuessedCharacters() {
		String chars = "";
		for (Character character : guessedCharacters) {
			if (!word.contains(character.toString())) {
				chars += character;
			}
		}

		return chars;
	}
	
	/**
	 * Play the game of player.
	 * @param player - player who's game it is about
	 */
	public abstract void playGame(Player player);

	/**
	 * Prints the gallow in the console.
	 */
	public void printGallow() {
		gallow.printGallow(getAmountOfWrongGuesses());
	}

	/**
	 * Prints the word in the console.
	 * Depending on who's game it is, it will either show or hide some characters.
	 */
	public abstract void printWord();

	/**
	 * Print amount of wrong guesses and the wrong guessed characters.
	 */
	public void printWrongGuesses() {
		boolean first = true;
		System.out.print("Aantal fouten: " + getAmountOfWrongGuesses());

		for (Character character : guessedCharacters) {
			if (!word.contains(character.toString())) {
				if (first) {
					System.out.print(" (");
					first = false;
				}

				System.out.print(character);
			}
		}
		
		System.out.println(first ? "" : ")");
	}

	/**
	 * Set the word length of the words.
	 * Also referred as difficulty.
	 * 
	 * @param charachterDifficulty - length of the words
	 */
	public void setCharachterDifficulty(int charachterDifficulty) {
		this.charachterDifficulty = charachterDifficulty;
	}

	/**
	 * Returns true when the words has been fully guessed.
	 * 
	 * @return boolean if word has been guessed
	 */
	public abstract boolean wordHasBeenGuessed();
	
}
