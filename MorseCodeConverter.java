import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/**
 * Converter Utility class
 * 
 * @author Jessica Park
 */
public class MorseCodeConverter {
	private static MorseCodeTree morseCodeTree = new MorseCodeTree();

	/*
	 * constructor
	 */
	public MorseCodeConverter() {
		
	}
	
	/*
	 * Converts a file of morse code into English
	 * Each letter delimited by a space (' '). Each word delimited by a '/'.
	 * @param codeFile name of the File that contains morse code
	 * @return the English translation of the file
	 * @throws FileNotFoundException
	 */
	public static String convertToEnglish(File codeFile) throws FileNotFoundException {
		StringBuilder result = new StringBuilder();
		Scanner scanner = new Scanner(codeFile);
		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();
			result.append(convertToEnglish(line)).append(" ");
		}
		scanner.close();
		return result.toString().trim();
	}
	
	/*
	 * Converts morse code into English
	 * @param code the Morse code
	 * @return the English translation
	 */
	public static String convertToEnglish(String code) {
		StringBuilder result = new StringBuilder();
		String[] words = code.split(" / ");
		for (String word : words) {
			String[] letters = word.split(" ");
			for (String letter : letters) {
				result.append(morseCodeTree.fetch(letter));
			}
			result.append(" ");
		}
		return result.toString().trim();)
	}
	
	/*
	 * Returns a string with all the data in the tree in LNR using the toArrayList method in MorseCodeTree
	 * @return the data in the tree in LNR order separated by a space
	 */
	public static String printTree() {
		ArrayList<String> list = morseCodeTree.toArrayList();
		return String.join(" ", list);
	}
	
}
