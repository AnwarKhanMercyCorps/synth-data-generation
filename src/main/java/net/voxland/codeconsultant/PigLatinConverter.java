package src.main.java.net.voxland.codeconsultant;
//Add Create a library that can convert normal English text into PigLatin

import java.util.Arrays;

public class PigLatinConverter {
    public String convertToPigLatin(String inputText) {
        if (inputText == null || inputText.isEmpty()) {
            return inputText; // Handle null or empty input
        }
        
        String[] words = inputText.split("\\s+");
        StringBuilder convertedText = new StringBuilder();

        for (String word : words) {
            convertedText.append(convertWord(word)).append(" ");
        }

        return convertedText.toString().trim();
    }

    private String convertWord(String word) {
        if (startsWithVowel(word)) {
            return word + "way";
        } else if (startsWithConsonants(word)) {
            return moveConsonantsToEnd(word);
        }
        return word + "ay"; // Default case
    }

    private boolean startsWithVowel(String word) {
        return word.length() > 0 && "AEIOUaeiou".indexOf(word.charAt(0)) != -1;
    }

    private boolean startsWithConsonants(String word) {
        return word.length() > 1 && !startsWithVowel(word);
    }

    private String moveConsonantsToEnd(String word) {
        String consonants = "";
        while (word.length() > 0 && !startsWithVowel(word)) {
            consonants += word.charAt(0);
            word = word.substring(1);
        }
        return word + consonants + "ay";
    }
}
