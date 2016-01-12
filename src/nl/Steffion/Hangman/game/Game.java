package nl.Steffion.Hangman.game;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Game {
	
	private Gallow					gallow;
	private ArrayList<Character>	guessedCharacters;
	private String					word;

	public Game() {
		gallow = new Gallow();
		guessedCharacters = new ArrayList<Character>();
	}
	
	public void addGuessedCharacter(Character character) {
		guessedCharacters.add(character);
	}
	
	public void chooseRandomWord() {
		// Get all words and put them in an ArrayList.
		ArrayList<String> words = new ArrayList<String>();
		File wordsFile = new File("resource" + File.separator + "woordenlijst_12.txt");

		try {
			Scanner wordsList = new Scanner(wordsFile);

			while (wordsList.hasNext()) {
				words.add(wordsList.nextLine());
			}

			wordsList.close();
		} catch (FileNotFoundException e) {
			System.out.println(e.getLocalizedMessage() + " Contact the developer for asstiance!");
			System.exit(1);
		}
		
		// Get a random word from the list.
		Random random = new Random();
		word = words.get(random.nextInt(words.size() - 1));
	}
	
	public int getAmountOfWrongGuessedCharacters() {
		int amount = 0;
		for (Character character : guessedCharacters) {
			if (!word.contains(character.toString())) {
				amount++;
			}
		}

		return amount;
	}

	public Gallow getGallow() {
		return gallow;
	}

	public ArrayList<Character> getGuessedCharacters() {
		return guessedCharacters;
	}

	public String getWord() {
		return word;
	}

	public void printWord() {
		for (char character : word.toCharArray()) {
			if (guessedCharacters.contains(character)) {
				System.out.print(character);
			} else {
				System.out.print(".");
			}
		}

		System.out.println();
	}
	
	public void printWrongGuesses() {
		boolean first = true;
		System.out.print("Aantal fouten: " + getAmountOfWrongGuessedCharacters());

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
}
