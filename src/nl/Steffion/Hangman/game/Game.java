package nl.Steffion.Hangman.game;

import java.util.ArrayList;

import nl.Steffion.Hangman.player.Player;

public abstract class Game {

	protected int					charachterDifficulty;
	private Gallow					gallow;
	protected ArrayList<Character>	guessedCharacters;
	protected String				word;
									
	public Game() {
		word = "";
		gallow = new Gallow();
		guessedCharacters = new ArrayList<Character>();
	}
	
	public void addGuessedCharacter(Character character) {
		guessedCharacters.add(character);
	}
	
	public int getAmountOfWrongGuesses() {
		int amount = 0;
		for (Character character : guessedCharacters) {
			if (!word.contains(character.toString())) {
				amount++;
			}
		}
		
		return amount;
	}
	
	public abstract void playGame(Player player);

	public void printGallow() {
		gallow.printGallow(getAmountOfWrongGuesses());
	}

	public abstract void printWord();

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

	public void setCharachterDifficulty(int charachterDifficulty) {
		this.charachterDifficulty = charachterDifficulty;
	}

	public abstract boolean wordHasBeenGuessed();
	
}
