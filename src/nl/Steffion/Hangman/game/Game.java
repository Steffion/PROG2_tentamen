package nl.Steffion.Hangman.game;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Game {

	private ArrayList<Character>	guessedCharacters;
	private String					word;
									
	public Game() {
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
	
}
