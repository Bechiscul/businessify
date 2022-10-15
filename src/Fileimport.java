import javax.swing.*;
import java.awt.*;
import java.io.*;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;


public class Fileimport extends JPanel {
    String data = null;
    JLabel stateText = util.makeTextPanel("", 0,0,0);
    JTextArea OrigrinTextArea = new JTextArea();
    JTextArea OutputTextArea = new JTextArea();

    public Fileimport() {
        super(new GridLayout(4,1));
      
        JPanel fileImportContainer = new JPanel();
        fileImportContainer.add(UploadFile());
        JPanel TextAreaContainer = new JPanel();
        TextAreaContainer.setLayout(new GridLayout(1, 2, 15, 5));

        /* Text Field addons */
        stateText.setText("Upload file or Enter your text!");
        OrigrinTextArea.setText("random red text. it is a beautiful product containing cool animations");
        OrigrinTextArea.setWrapStyleWord(true);
        OrigrinTextArea.setLineWrap(true);
        OutputTextArea.setWrapStyleWord(true);
        OutputTextArea.setLineWrap(true);
        JScrollPane scrollOrigin = new JScrollPane(OrigrinTextArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        JScrollPane scrollOutput = new JScrollPane(OutputTextArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        TextAreaContainer.add(scrollOrigin, BorderLayout.EAST);
        TextAreaContainer.add(scrollOutput, BorderLayout.WEST);

        /* Gen */
        JPanel genaratePanel = new JPanel();
        genaratePanel.setSize(200, 100);
        try {
            genaratePanel.add(GenerateText());
        } catch (Exception e) {
           System.out.println(e);
        }
        genaratePanel.add(Download());

        this.add(fileImportContainer);
        this.add(stateText);
        this.add(TextAreaContainer);
        this.add(genaratePanel);
    }

    JButton UploadFile() {
        JButton browseFiles = util.makeButton("Browse files", (e) -> {
            data = TextReader.openFolder();
            if (data == null) {
                OrigrinTextArea.setText("Error, not valid file");
            } else
                OrigrinTextArea.setText(data);
                stateText.setText("File uploaded!");
        });
        browseFiles.setSize(100, 100);
        return browseFiles;
    }

    JButton Download(){
        JButton downloadBtn = util.makeButton("Download Output", (e) -> {
            String filePath = TextReader.getFilenPath();
            data = OutputTextArea.getText();
           try {
            Files.write(Paths.get(filePath), data.getBytes());
            stateText.setText("File now overwriten to the cool version!");
            
        } catch (IOException ee) {
                System.out.println("An error occurred.");
                ee.printStackTrace();
              } 
        });
        downloadBtn.setSize(100, 100);
        return downloadBtn;
    }

    JButton GenerateText() throws Exception  {
        
        Buzzworder buzzer = new Buzzworder();
        Classifier classifier = new Classifier();
        JButton generateText = util.makeButton("Generate Buzzwords", (e) -> {

            String text = new String(OrigrinTextArea.getText());
            LinkedList<String> buzzedAdjectives = buzzer.insert(classifier.classify(text));
            System.out.println(buzzedAdjectives);
           
            String buzzedText = classifier.reconstruct(buzzedAdjectives);
            System.out.println(buzzedText);
            OutputTextArea.setText(buzzedText);
            stateText.setForeground(new Color(0,200,0));
            stateText.setText("Generated buzzwords!");
            
         
        });
        generateText.setSize(100, 100);
        return generateText;

    }

}
