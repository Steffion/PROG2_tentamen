package nl.Steffion.Hangman.game;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import nl.Steffion.Hangman.ConsoleIO;
import nl.Steffion.Hangman.player.Player;

/**
 * 
 * @author Steffion (Stef de Goey) 2016
 *
 */

public class GameHuman extends Game {
	
	/**
	 * Chooses a random word and puts it in the word String.
	 */
	private void chooseRandomWord() {
		// Get all words and put them in an ArrayList.
		ArrayList<String> words = new ArrayList<String>();
		File wordsFile = new File("resource" + File.separator + "woordenlijst_" + charachterDifficulty + ".txt");
		
		try {
			Scanner wordsList = new Scanner(wordsFile);
			
			while (wordsList.hasNext()) {
				words.add(wordsList.nextLine());
			}
			
			wordsList.close();
		} catch (FileNotFoundException e) {
			System.out.println("FileNotFoundException: " + e.getLocalizedMessage() + ". Contact the developer for asstiance!");
			System.exit(1);
		}

		// Get a random word from the list.
		Random random = new Random();
		word = words.get(random.nextInt(words.size() - 1));
	}
	
	@Override
	public void playGame(Player player) {
		chooseRandomWord();
		ConsoleIO io = new ConsoleIO();
		
		while ((getAmountOfWrongGuesses() < 10) && !wordHasBeenGuessed()) {
			printWord();
			printWrongGuesses();
			printGallow();

			System.out.print("Geef de letter die je wilt raden: ");
			
			while (true) {
				String answer = io.readInput();

				if ((answer == null) || answer.isEmpty()) {
					System.out.println("*** Vul alstublieft iets in! ***");
					continue;
				} else if (answer.length() > 1) {
					System.out.println("*** Graag één letter invoeren! ***");
					continue;
				} else if (!answer.matches("[A-Za-z]")) {
					System.out.println("*** Vul een geldige letter in! ***");
					continue;
				}
				
				char character = answer.toUpperCase().charAt(0);
				
				if (guessedCharacters.contains(character)) {
					System.out.println("*** Je hebt al eerder deze letter gebruikt! ***");
					continue;
				}

				int occurrence = 0;
				for (char wordCharacter : word.toCharArray()) {
					if (wordCharacter == character) {
						occurrence++;
					}
				}
				
				String dynamicText = (occurrence > 0 ? occurrence + " keer" : "niet");
				System.out.println("De letter " + character + " komt " + dynamicText + " in het woord voor.");

				try {
					Thread.sleep(1500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				guessedCharacters.add(character);
				break;
			}
		}

		if (wordHasBeenGuessed()) {
			System.out.println("Het woord is geraden: " + word);
		} else {
			printWord();
			printWrongGuesses();
			printGallow();
			System.out.println("Je hebt te vaak fout gegokt, het woord was: " + word);
		}

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Override
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
	
	@Override
	public boolean wordHasBeenGuessed() {
		for (char character : word.toCharArray()) {
			if (!guessedCharacters.contains(character)) {
				return false;
			}
		}

		return true;
	}
	
}
