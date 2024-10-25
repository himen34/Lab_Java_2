package com.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The TextProcessor class provides functionality to process a given text,
 * specifically sorting words that start with vowels based on their second letter,
 * while keeping other words and punctuation in their original positions.
 */
public class TextProcessor {

    private StringBuilder text;

    /**
     * Constructs a TextProcessor with the given text.
     *
     * @param text The text to be processed. Must not be null or empty and should contain only English letters.
     * @throws IllegalArgumentException if the input text is null, empty, or contains non-English characters.
     */
    public TextProcessor(StringBuilder text) throws IllegalArgumentException {
        if (text == null) {
            throw new IllegalArgumentException("Text cannot be null.");
        }

        if (text.length() == 0) {
            throw new IllegalArgumentException("Input text cannot be empty.");
        }

        if (!isEnglishText(text)) {
            throw new IllegalArgumentException("Input text must contain only English alphabet characters.");
        }

        this.text = text;
    }

    /**
     * Sorts words in the text that start with vowels based on their second letter,
     * keeping other words and punctuation in their original positions.
     *
     * @return A StringBuilder containing the text with sorted vowel words.
     */
    public StringBuilder sortWordsStartingWithVowels() {
        List<StringBuilder> words = splitIntoWordsAndPunctuation(text);
        List<StringBuilder> vowelWords = new ArrayList<>();

        // Collect words starting with vowels
        for (StringBuilder word : words) {
            if (word.length() > 0 && isVowel(word.charAt(0))) {
                vowelWords.add(word);
            }
        }

        // Sort filtered vowel words by the second letter
        Collections.sort(vowelWords, (o1, o2) -> {
            if (o1.length() < 2 && o2.length() < 2) return 0;
            if (o1.length() < 2) return 1;
            if (o2.length() < 2) return -1;
            return Character.compare(o1.charAt(1), o2.charAt(1));
        });
        

        // Rebuild the original text, replacing vowel words with sorted ones
        StringBuilder result = new StringBuilder();
        int vowelIndex = 0; // Index for sorted vowel words

        for (StringBuilder word : words) {
            if (word.length() > 0 && isVowel(word.charAt(0))) {
                result.append(vowelWords.get(vowelIndex++)); // Replace with sorted vowel word
            } else {
                result.append(word); // Keep punctuation and consonants as is
            }
        }

        return result;
    }

    /**
     * Splits the input text into words and punctuation, preserving the delimiters.
     *
     * @param text The text to be split.
     * @return A list of StringBuilders, each representing a word or punctuation.
     */
    private List<StringBuilder> splitIntoWordsAndPunctuation(StringBuilder text) {
        List<StringBuilder> words = new ArrayList<>();
        StringBuilder current = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (Character.isLetterOrDigit(ch) || ch == '\'') {
                current.append(ch);
            } else {
                if (current.length() > 0) {
                    words.add(new StringBuilder(current));
                    current.setLength(0);
                }
                words.add(new StringBuilder().append(ch)); // Add punctuation or whitespace as a separate element
            }
        }

        if (current.length() > 0) {
            words.add(current);
        }

        return words;
    }

    /**
     * Checks if a character is a vowel.
     *
     * @param ch The character to be checked.
     * @return true if the character is a vowel, false otherwise.
     */
    private boolean isVowel(char ch) {
        char lowerCh = Character.toLowerCase(ch);
        return lowerCh == 'a' || lowerCh == 'e' || lowerCh == 'i' || lowerCh == 'o' || lowerCh == 'u';
    }

    /**
     * Validates if the input text contains only English letters, spaces, and common punctuation.
     *
     * @param text The text to be validated.
     * @return true if the text contains only English alphabet characters and punctuation, false otherwise.
     */
    private boolean isEnglishText(StringBuilder text) {
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (!Character.isLetter(ch) && !Character.isWhitespace(ch) && ",.!?()\"'-".indexOf(ch) == -1) {
                return false;
            }
        }
        return true;
    }    
    
}

