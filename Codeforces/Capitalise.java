import java.util.Scanner;

public class Capitalise {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the input word
        String word = scanner.nextLine();

        // Capitalize the word
        String capitalizedWord = capitalize(word);

        // Output the capitalized word
        System.out.println(capitalizedWord);

        scanner.close();
    }

    public static String capitalize(String word) {
        if (word == null || word.isEmpty()) {
            return word; // Return the word as is if it's null or empty
        }

        // Convert the first character to uppercase and concatenate with the rest of the string
        return Character.toUpperCase(word.charAt(0)) + word.substring(1);
    }
}
