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
        int count = 0;
        int initialLength = adjectives.size();
        for (int i = 0; i < initialLength; i++) {
            int random = (int)(Math.random()*4+1);
            if(i % random == 0){
            String temp = adjectives.get(i);
            adjectives.remove(i);
            adjectives.add(i, buzzwords.get(count) + " " + temp);
            count++;
            }
        }
        return adjectives;
    }
}