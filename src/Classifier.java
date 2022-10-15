import edu.mit.jwi.*;
import edu.mit.jwi.item.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;


// classify adjectives, nouns and verbs
public class Classifier {
  private IDictionary dictionary;
  private String text = new String();
  private ArrayList<String> wordArr = new ArrayList<>();

  public Classifier() throws IOException {
    File file = new File("./assets/dict");
    this.dictionary = new Dictionary(file);
    this.dictionary.open();
  }

  /// Returns an list of adjectives
  public LinkedList<String> classify(String text) {
    this.text = new String(text);
    
    LinkedList<String> adjectiveLinkedList = new LinkedList<>();
    ArrayList<String> sentenceArr = getSentences(text);

    for (String sentence : sentenceArr) {
      ArrayList<String> wordArr = getWords(sentence);
      this.wordArr.addAll(wordArr);

      for (String word : wordArr) {
        if (this.dictionary.getIndexWord(word, POS.ADJECTIVE) != null) {
          // Word exists in the form as an adjective
          // (we assume it is an adjective)
          adjectiveLinkedList.addLast(word);
        }
      }
    }

    return adjectiveLinkedList;
  }

  public String reconstruct(LinkedList<String> buzzed) {
    ArrayList<String> wordAndSymbolArr = new ArrayList<>(Arrays.asList(this.text.split("\s+")));

    for (int i = 0; i < this.wordArr.size(); i++) {
        try {
          String buzzWord = buzzed.getFirst();
          String[] buzzWordArr = buzzWord.split(" ");
          assert buzzWordArr.length == 1 || buzzWordArr.length == 2;
  
  
          if (buzzWordArr.length == 1) {
            buzzed.removeFirst();
            continue;
          }
  
          String word = wordArr.get(i);
          if (word.equals(buzzWordArr[0]) || word.equals(buzzWordArr[1])) {
            wordAndSymbolArr.set(i, wordAndSymbolArr.get(i).replace(word, buzzWord));
            buzzed.removeFirst();
          }

        } catch (NoSuchElementException e) {}
    }

    String output = new String();
    for (String s : wordAndSymbolArr) output += s + " ";
    return output;
  }

  private static ArrayList<String> getSentences(String text) {
    ArrayList<String> sentencArr = new ArrayList<>();

    int lastPeriod = 0;
    for (int i = 0; i < text.length(); i++) {
      if (text.charAt(i) == '.') {
        // Because String.substring is inclusive, we must increment it to get rid of the '.'
        // in the case where this sentence is not the first.
        sentencArr.add(text.substring((lastPeriod != 0) ? lastPeriod + 1 : 0, i).trim());
        lastPeriod = i;
      }
    }

    // If the last sentence is not delimited by a '.', then treat it as a sentence.
    if (text.lastIndexOf('.') != text.length() - 1) {
      sentencArr.add(text.substring(lastPeriod + ((lastPeriod != 0) ? + 1 : 0)).trim());
    }

    return sentencArr;
  }

  private static ArrayList<String> getWords(String sentence) {
    List<String> words = Arrays.asList(sentence.split("\\s+|,|\\?|:|;"));
    ArrayList<String> wordArr = new ArrayList<>(words);
    wordArr.removeIf((String v) -> v.equals(""));
    return wordArr;
  }
}
