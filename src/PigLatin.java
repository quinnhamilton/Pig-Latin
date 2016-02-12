import java.util.Scanner;

/**
 * 
 */

/**
 * @author Harley Quinn 
 * 		   Purpose: Create an application that can translate words
 *         into Pig Latin. This application accepts all letters, uppercase and
 *         lowercase, and also accepts ' for users translating contractions.
 *
 */
public class PigLatin {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		final String vowels = "aeiouAEIOU"; // this sets the vowel letters aeiouAEIOU. The location of a vowel controls the Translator.
		String contin = "y";
		System.out.println("Welcome to the Pig Latin Translator!");
		System.out.println("");

		while (contin.matches("^[yY]$")) { // the user can enter an upper or lowercase y/Y to continue
			System.out.println("Please enter the word you'd like to translate into Pig Latin: ");
			String word = scanner.next(); // accepts the single word from the user
										
			if (!word.matches("[a-zA-Z']+")) { // checks to make sure user only entered letters or ' for contractions
				System.out.println("Invalid entry. Please only enter letters a-z or A-Z.");
				continue;
			}
			
			String beforeVowel = "";
			int cut = 0;
			word = word.toLowerCase(); // converts all characters in user input to lowercase letters
			while (cut < word.length() && !vowels.contains("" + word.charAt(cut))) { //THE Pig Latin translator
																						
				beforeVowel += word.charAt(cut);
				cut++;
			}
			if (cut == 0) {
				cut = 0;
				word += "w";
			}
			System.out.println(word.substring(cut) + beforeVowel + "ay");
			System.out.println();
			System.out.print("Continue? (y/n): "); // asks if the user would like to continue								
			contin = scanner.next();
			if (contin.matches("^[nN]$")) {
				System.out.println("Goodbye!");
			} else
				System.out.println("Wait, did you want to continue? (y/n) ");
			contin = scanner.next();

		}

		scanner.close();

	}

}
