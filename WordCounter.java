import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Scanner;

public class WordCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a list of words separated by whitespace:");
        String input = scanner.nextLine();

        // Split the input into an array of words
        String[] words = input.split("\\s+");

        // Create a HashMap to store word counts
        Map<String, Integer> wordCountMap = new HashMap<>();

        // Count the occurrences of each word
        for (String word : words) {
            // Remove punctuation (optional)
            word = word.replaceAll("[^a-zA-Z]", "").toLowerCase();

            // Update the word count in the map
            if (wordCountMap.containsKey(word)) {
                wordCountMap.replace(word, wordCountMap.get(word) + 1);
            } else {
                wordCountMap.put(word,1);
            }
        }

        // Print the word counts
        System.out.println("Word Counts:");
        Set<String> set = wordCountMap.keySet();
        for (String key : set) {
            System.out.println(key + ": " + wordCountMap.get(key));
        }

        scanner.close();
    }
}