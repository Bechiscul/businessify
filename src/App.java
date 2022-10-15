import java.util.LinkedList;

public class App {
    public static void main(String[] args) throws Exception {
        Buzzworder buzzer = new Buzzworder();
        Classifier classifier = new Classifier();

        String text = new String("random red text. it is a beautiful product containing cool animations");

        LinkedList<String> buzzedAdjectives = buzzer.insert(classifier.classify(text));
        System.out.println(buzzedAdjectives);
        String buzzedText = classifier.reconstruct(buzzedAdjectives);
        System.out.println(buzzedText);
    }
}
