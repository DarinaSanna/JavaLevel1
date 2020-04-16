import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class FrequencyAnalysis {
    public static void main (String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(
                new FileReader("Cell.txt")
        );
        HashMap<Character, Integer> analysisResults = new HashMap<>();
        HashMap<String, Integer> analysisResWords = new HashMap<>();

        String text = reader.readLine();

        text = text.toLowerCase();
        text = deleteNonLetters(text);
        String text1 = text;

        text = text.replaceAll(" ", "");

        String[] subtext = text1.split(" ");

        List<String> words = new ArrayList<>(subtext.length);
        for (String s : subtext) {
            words.add(s);
        }

        words.removeAll(Arrays.asList("",null));

        performAnalysisWords(analysisResWords, words);
        performAnalysis(analysisResults, text);

        printResultsWords(analysisResWords);
        System.out.println("----------------");
        printResults(analysisResults);


    }

    private static void printResultsWords(HashMap<String, Integer> analysisResWords) {
        System.out.println("Results of frequency analysis (words):");
        for (String keys : analysisResWords.keySet()) {
            System.out.println(keys + " : "+ analysisResWords.get(keys));
        }
    }

    private static void performAnalysisWords(HashMap<String, Integer> analysisResWords, List<String> words) {
        for (int i = 0; i < words.size(); i++) {
            String word = words.get(i);
            if (!analysisResWords.containsKey(word)) {
                analysisResWords.put (word, 1);
            }
            else {
                int countW = analysisResWords.get(word);
                analysisResWords.put(word, countW + 1);
            }
        }
    }

    private static void printResults(HashMap<Character, Integer> analysisResults) {
        System.out.println("Results of frequency analysis (letters):");
        for (Character keys : analysisResults.keySet()) {
            System.out.println(keys + " : "+ analysisResults.get(keys));
        }
    }

    private static void performAnalysis(HashMap<Character, Integer> analysisResults, String text) {
        for (int i = 0; i < text.length(); i++) {
            char letter = text.charAt(i);
            if (!analysisResults.containsKey(letter)) {
                analysisResults.put (letter, 1);
            }
            else {
                int count = analysisResults.get(letter);
                analysisResults.put(letter, count + 1);
            }
        }
    }

    @NotNull
    private static String deleteNonLetters(String text) {
        for (int i = 0; i < text.length(); i++){
            if (!Character.isLetter(text.charAt(i))){
                text = text.replace(text.charAt(i), ' ');
            }
        }
        return text;
    }
}

