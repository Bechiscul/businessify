/*import java.util.AbstractCollection;
import java.util.AbstractList;
import java.util.AbstractSequentialList;*/
import java.util.LinkedList;
import java.util.ArrayList;
import java.io.*;
public class Buzzworder{
    private ArrayList<String> buzzwords = new ArrayList<String>();
    private File file = new File("./assets/buzzwords.txt");

    public Buzzworder() throws FileNotFoundException, IOException {
        BufferedReader reader = new BufferedReader(new FileReader(this.file));

        String line;
        while ((line = reader.readLine()) != null) {
            buzzwords.add(line);
        }
        
        reader.close();
    }

    public LinkedList<String> insert (LinkedList<String> adjectives) {
        int initialSize = adjectives.size();
        for (int i = 0; i < initialSize; i++) {
            if(i % 3 == 0){
            adjectives.add(i, buzzwords.get(i/3));
            }
        }
        return adjectives;
    }
}