package ui;

import java.io.*;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class TextReader {
    File selectedFile;

    public void openFolder() {
        String filename = File.separator+"tmp";
        JFileChooser fc = new JFileChooser(new File(filename));
       
        // Make pop-up ony accept '.txt' files
        FileNameExtensionFilter filter = new FileNameExtensionFilter(".txt", "txt", "text");
        fc.setFileFilter(filter);
       
        // Show open dialog; this method does not return until the dialog is closed
        switch (fc.showOpenDialog(Window.frame)) {
            case JFileChooser.CANCEL_OPTION:
            System.out.println("Closed dialog window. No file selected");
            break;

            case JFileChooser.APPROVE_OPTION:
                System.out.println("Closed dialog window. One file selected");
                selectedFile = fc.getSelectedFile();
                readFile();
            break;

            default:
                System.out.println("Closed dialog window. Error occured");
            break;
        }
    }

    public void readFile() {
        try { 
            Scanner file = new Scanner(selectedFile);

            while (file.hasNextLine()) {
            String data = file.nextLine();
            System.out.println(data);
          }
          file.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not Found");
            e.printStackTrace();
        }
    }}
