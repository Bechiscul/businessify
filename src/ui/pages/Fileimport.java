package ui.pages;

import javax.swing.*;
import java.awt.*;
import java.io.*;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;

import ui.TextReader;
import ui.util;

public class Fileimport extends JPanel {
    String data = null;
    String filename = File.separator + "tmp";
    TextReader textImport = new TextReader();
    JTextArea OrigrinTextArea = new JTextArea();
    JTextArea OutputTextArea = new JTextArea();

    public Fileimport() {
        super(new GridLayout(3,1));
      
        JPanel fileImportContainer = new JPanel();
        fileImportContainer.add(UploadFile());
        JPanel TextAreaContainer = new JPanel();
        TextAreaContainer.setLayout(new GridLayout(1, 2, 15, 5));


        OrigrinTextArea.setText("Upload or enter text here..."); // Start text
        OrigrinTextArea.setWrapStyleWord(true);
        OrigrinTextArea.setLineWrap(true);
        JScrollPane scrollOrigin = new JScrollPane(OrigrinTextArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        JScrollPane scrollOutput = new JScrollPane(OutputTextArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        TextAreaContainer.add(scrollOrigin, BorderLayout.EAST);
        TextAreaContainer.add(scrollOutput, BorderLayout.WEST);

        /*  */
        JPanel genaratePanel = new JPanel();
        genaratePanel.setSize(200, 100);
        genaratePanel.add(GenerateText());
        genaratePanel.add(Download());

        this.add(fileImportContainer);
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
        });
        browseFiles.setSize(100, 100);
        return browseFiles;
    }

    JButton Download(){
        JButton downloadBtn = util.makeButton("Download Output", (e) -> {
            String filePath = TextReader.getFilenPath();
            data = OrigrinTextArea.getText(); // TODO: Change to output text area when ready
           try {
            Files.write(Paths.get(filePath), data.getBytes());
           } catch (IOException ee) {
                System.out.println("An error occurred.");
                ee.printStackTrace();
              } 
        });
        downloadBtn.setSize(100, 100);
        return downloadBtn;
    }

    JButton GenerateText() {
        LinkedList<String> GeneratedOutput;
        JButton generateText = util.makeButton("Generate Buzzwords", (e) -> {
            System.out.println("generated");
            // Call Classifer method!
            // GeneratedOutput = Classifer.classify()???
            // TODO: Bech fix :)

            // outputTextArea.setText(GeneratedOutput);
        });
        generateText.setSize(100, 100);
        return generateText;
    }

}
