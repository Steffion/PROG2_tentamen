package nl.Steffion.Hangman.game;

import java.util.Random;

import nl.Steffion.Hangman.ConsoleIO;
import nl.Steffion.Hangman.player.Player;

public class GameComputer extends Game {

	private char nextGuess() {
		Random random = new Random();
		
		while (true) {
			char randomChar = Character.toChars(random.nextInt(('Z' + 1) - 'A') + 'A')[0];
			if (guessedCharacters.contains(randomChar)) {
				continue;
			}

			return randomChar;
		}
	}

	@Override
	public void playGame(Player player) {
		ConsoleIO io = new ConsoleIO();
		
		for (int i = charachterDifficulty; i > 0; i--) {
			word = word + ".";
		}

		System.out.println("Neem een woord van " + charachterDifficulty + " letters in gedachten en druk op <ENTER>");
		io.readInput();
		
		while ((getAmountOfWrongGuesses() < 10) && !wordHasBeenGuessed()) {
			char character = nextGuess();
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

		for (char character2 : word.toCharArray()) {
			if (character2 == '.') {
			}
		}
		
		if (wordHasBeenGuessed()) {
			System.out.println("Het woord is geraden.");
		} else {
			printWord();
			printWrongGuesses();
			printGallow();
			System.out.println("De computer hebt te vaak fout gegokt.");
		}
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
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
