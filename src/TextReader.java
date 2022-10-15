

import java.io.*;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class TextReader {
    static File selectedFile;
    
    public static String openFolder() {
        String filename = File.separator + "tmp";
        JFileChooser fc = new JFileChooser(new File(filename));

        // Make pop-up ony accept '.txt' files
        FileNameExtensionFilter filter = new FileNameExtensionFilter(".txt", "txt", "text");
        fc.setFileFilter(filter);

        // Show open dialog; this method does not return until the dialog is closed
        switch (fc.showOpenDialog(Window.frame)) {
            case JFileChooser.CANCEL_OPTION:
                System.out.println("Closed dialog window. No file selected");
                return null;

            case JFileChooser.APPROVE_OPTION:
                System.out.println("Closed dialog window. One file selected");
                selectedFile = fc.getSelectedFile();
                
                String data = readFile(selectedFile);
                return data;

            default:
                System.out.println("Closed dialog window. Error occured");
                return "Closed dialog window. Error occured";
        }
    }

    public static String getFilenPath() {
        return selectedFile.getAbsolutePath();
    }

    public static String readFile(File selectedFile) {
        String data = "";
        try {
            Scanner file = new Scanner(selectedFile);

            while (file.hasNextLine()) {
                data += file.nextLine();
                data += "\n";
            }
            System.out.println(data);
            file.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not Found");
            e.printStackTrace();
        }
        return data;
    }
}
