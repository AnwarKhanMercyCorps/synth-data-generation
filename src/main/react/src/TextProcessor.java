import java.io.*;
import java.nio.file.*;
import java.util.*;
import org.json.JSONArray;
import org.json.JSONObject;

public class TextProcessor {

    public static void main(String[] args) throws IOException {
        String filePath = "C:\\exam\\synth-data-generation\\src\\main\\react\\src\\pg1342.txt"; 
        List<String> sentences = readSentences(filePath);
        
        JSONArray jsonArray = new JSONArray();
        
        for (String sentence : sentences) {
            String[] parts = splitSentence(sentence);
            if (parts.length > 1) {
                String generated = generateText(parts[0]);
                String pigLatin = convertToPigLatin(generated);
                
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("en", parts[0] + " " + parts[1]);
                jsonObject.put("piglatin", pigLatin);
                
                jsonArray.put(jsonObject);
            }
        }
        
        saveAsJson(jsonArray, "output.json");
    }

    private static List<String> readSentences(String filePath) throws IOException {
        String content = new String(Files.readAllBytes(Paths.get(filePath)));
        return Arrays.asList(content.split("(?<=[.!?])\\s+")); // Split by sentence-ending punctuation
    }

    private static String[] splitSentence(String sentence) {
        // Simple method to split into two parts (or however you choose)
        String[] parts = sentence.split("(?<=[.!?])\\s+", 2);
        return parts.length > 1 ? parts : new String[]{parts[0], ""};
    }

    private static String generateText(String part) {
        // Placeholder for generating text (simulate with a simple addition)
        return part + " [additional generated text...]";
    }

    private static String convertToPigLatin(String sentence) {
        String[] words = sentence.split(" ");
        StringBuilder pigLatin = new StringBuilder();
        
        for (String word : words) {
            if (word.length() > 0) {
                String pigWord = word.substring(1) + word.charAt(0) + "ay"; // Simple Pig Latin conversion
                pigLatin.append(pigWord).append(" ");
            }
        }
        
        return pigLatin.toString().trim();
    }

    private static void saveAsJson(JSONArray jsonArray, String fileName) throws IOException {
        try (FileWriter file = new FileWriter(fileName)) {
            file.write(jsonArray.toString(2)); // Pretty print with 2-space indent
            file.flush();
        }
    }
}
