package nl.Steffion.Hangman.player;

import nl.Steffion.Hangman.ConsoleIO;
import nl.Steffion.Hangman.game.Game;

public class PlayerHuman extends Player {

	@Override
	public void playGame() {
		Game game = getGame();
		game.chooseRandomWord();

		ConsoleIO io = new ConsoleIO();

		while (game.getAmountOfWrongGuesses() < 10 && !game.wordHasBeenGuessed()) {
			game.printWord();
			game.printWrongGuesses();
			game.printGallow();
			
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

				if (game.getGuessedCharacters().contains(character)) {
					System.out.println("*** Je hebt al eerder deze letter gebruikt! ***");
					continue;
				}
				
				int occurrence = 0;
				for (char wordCharacter : game.getWord().toCharArray()) {
					if (wordCharacter == character) {
						occurrence++;
					}
				}

				String dynamicText = (occurrence > 0 ? occurrence + " keer " : "niet ");
				System.out.println("De letter " + character + " komt " + dynamicText + "in het woord voor.");
				
				try {
					Thread.sleep(1500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
						
				game.addGuessedCharacter(character);
				break;
			}
		}
		
	}

}
