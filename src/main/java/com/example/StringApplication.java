package com.example;


/**
 * The StringApplication class demonstrates the usage of the TextProcessor class.
 * It processes a given text to sort words starting with vowels and displays the
 * original and processed text.
 */
public class StringApplication {

    /**
     * The main method is the entry point of the application.
     * It initializes the input text, creates a TextProcessor instance,
     * and prints the sorted result.
     *
     * @param args Command-line arguments (not used in this application).
     */
    public static void main(String[] args) {
        // Initialize the input text to be processed
        StringBuilder text = new StringBuilder("Apple opera echo ape eagle ultra element object. Words starting with consonants, as well as punctuation, remain the same(oaw!).");

        try {
            // Create a TextProcessor instance with the input text
            TextProcessor textProcessor = new TextProcessor(text);

            System.out.println();
            System.out.println("Input text:     " + text);

            // Process the text to sort words starting with vowels
            StringBuilder sortedWords = textProcessor.sortWordsStartingWithVowels();

            System.out.println("Sorted words:   " + sortedWords);
            System.out.println();
        } catch (IllegalArgumentException e) {
            System.out.println();
            System.err.println("Input validation error: " + e.getMessage());
            System.out.println();
        } catch (Exception e) {
            System.out.println();
            System.err.println("An unexpected error occurred: " + e.getMessage());
            System.out.println();
        }
    }
}


