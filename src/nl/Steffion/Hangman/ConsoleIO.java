package nl.Steffion.Hangman;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Requests input from user in the console.
 * 
 * @author Steffion (Stef de Goey) 2016
 *
 */

public class ConsoleIO {
	BufferedReader br;

	public ConsoleIO() {
		br = new BufferedReader(new InputStreamReader(System.in));
	}

	/**
	 * Request console input from user.
	 * @return string input from console.
	 */
	public String readInput() {
		try {
			return br.readLine();
		} catch (IOException e) {
			System.out.println("IOException: " + e.getLocalizedMessage() + ". Contact the developer for asstiance!");
			return "IOException";
		}
	}
}
