package nl.Steffion.Hangman.game;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

import nl.Steffion.Hangman.ConsoleIO;
import nl.Steffion.Hangman.player.Player;

public class GameComputer extends Game {
	private HashMap<String, Boolean> words;

	public GameComputer() {
		words = new HashMap<String, Boolean>();
	}
	
	private void initWords() {
		File wordsFile = new File("resource" + File.separator + "woordenlijst_" + charachterDifficulty + ".txt");

		try {
			Scanner wordsList = new Scanner(wordsFile);

			while (wordsList.hasNext()) {
				words.put(wordsList.nextLine(), true);
			}

			wordsList.close();
		} catch (FileNotFoundException e) {
			System.out.println(
					"FileNotFoundException: " + e.getLocalizedMessage() + ". Contact the developer for asstiance!");
			System.exit(1);
		}
	}
	
	private char nextGuess() {
		for (String word : words.keySet()) {
			if (words.get(word) == false) {
				continue;
			}
			
			if (!word.matches(this.word.replaceAll("\\.", ".*[^-" + getWrongGuessedCharacters() + "]"))) {
				words.put(word, false);
			}
		}
		
		for (String word : words.keySet()) {
			if (words.get(word) == false) {
				continue;
			}
			
			for (char character : word.toCharArray()) {
				if (!guessedCharacters.contains(character)) {
					return character;
				}
			}
		}

		System.out.println("De computer denkt dat je vals speelt! Hij geeft het op...");
		System.exit(1);
		return '-';
	}
	
	@Override
	public void playGame(Player player) {
		ConsoleIO io = new ConsoleIO();
		initWords();

		for (int i = charachterDifficulty; i > 0; i--) {
			word = word + ".";
		}
		
		System.out.println("Neem een woord van " + charachterDifficulty + " letters in gedachten en druk op <ENTER>");
		io.readInput();

		while ((getAmountOfWrongGuesses() < 10) && !wordHasBeenGuessed()) {
			char character = nextGuess();
			printLastWordRemaining();
			printWord();
			printWrongGuesses();
			printGallow();
			
			System.out.print(player.getName() + " raadt een " + character + ". Op welke plaats(en) staat die letter? ");

			while (true) {
				String answer = io.readInput();
				String[] answers = answer.split(" ");

				if ((answer == null) || answer.isEmpty()) {
					System.out.println("*** Vul alstublieft iets in! ***");
					continue;
				}

				boolean valid = true;
				int occurrence = answers.length;

				for (String index : answers) {
					if (index.equals("*")) {
						occurrence = 0;
						break;
					}

					try {
						int number = Integer.parseInt(index);

						if ((number < 1) || (number > charachterDifficulty)) {
							System.out.println("*** Je hebt een getal ingevuld die buiten de grenzen valt! (1-"
									+ charachterDifficulty + ") ***");
							valid = false;
							break;
						}

						if (guessedCharacters.contains(word.toCharArray()[number - 1])) {
							System.out.println("*** Deze plek is al ingevuld! (" + number + ")");
							valid = false;
						}
					} catch (NumberFormatException e) {
						System.out.println("*** Vul een geldige getallen reeks in! ***");
						valid = false;
						break;
					}
				}

				if (!valid) {
					continue;
				}
				
				String dynamicText = (occurrence > 0 ? occurrence + " keer" : "niet");
				System.out.println("De letter " + character + " komt " + dynamicText + " in het woord voor.");

				if (occurrence > 0) {
					for (String index : answers) {
						try {
							int number = Integer.parseInt(index);
							
							word = word.substring(0, number - 1) + character + word.substring(number);
						} catch (NumberFormatException e) {
							System.out.println("NumberFormatException: " + e.getLocalizedMessage()
									+ ". Contact the developer for asstiance!");
							System.exit(1);
						}
					}
				}
				
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
			System.out.println("De computer heeft te vaak fout gegokt, je was hem te slim af!");
		}

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void printLastWordRemaining() {
		int wordsRemaining = 0;
		String lastWordRemaining = "";
		for (String word : words.keySet()) {
			if (words.get(word) == true) {
				wordsRemaining++;
				lastWordRemaining = word;

				if (wordsRemaining > 1) {
					return;
				}
			}
		}

		System.out.println("Er is maar één woord meer moglijk: " + lastWordRemaining);
	}
	
	@Override
	public void printWord() {
		System.out.println(word);
	}

	@Override
	public boolean wordHasBeenGuessed() {
		for (char character2 : word.toCharArray()) {
			if (character2 == '.') {
				return false;
			}
		}

		return true;
	}
	
}
