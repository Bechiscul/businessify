import java.io.*;
import java.util.ArrayList;

import edu.mit.jwi.*;

// classify adjectives, nouns and verbs
public class Classifier {
    private IDictionary dictionary;


    public Classifier() throws IOException {
        File file = new File("./assets/dict");
        this.dictionary = new Dictionary(file);
        this.dictionary.open();
    }


    public static void classify(String text)  {
        
    }

    private static ArrayList<String> getSentences(String text) {
        ArrayList<String> sentences = new ArrayList<>();

        int lastPeriod = 0;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == '.') {
                // Because String.substring is inclusive, we must increment it to get rid of the '.'
                // in the case where this sentence is not the first.
                sentences.add(text.substring((lastPeriod != 0) ? lastPeriod + 1 : 0, i).trim());
                lastPeriod = i;
            }
        }

        // If the last sentence is not delimited by a '.', then treat it as a sentence.
        if (text.lastIndexOf('.') != text.length() - 1) {
            sentences.add(text.substring(lastPeriod + 1).trim());
        }

        return sentences;
    }

}
