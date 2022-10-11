package ui.pages;

import javax.swing.*;
import java.awt.*;

import ui.TextReader;
import ui.util;

public class Fileimport extends JPanel {
    static TextReader textImport = new TextReader();

    public Fileimport() {
        super(new GridLayout(3, 1));

        JPanel fileImportContainer = new JPanel();
        fileImportContainer.setSize(200, 150);
        fileImportContainer.add(DisplayFileExplorer());

        this.add(fileImportContainer);
        this.add(TextOriginField());
    }

    public JButton DisplayFileExplorer() {
        JButton browseFiles = util.makeButton("Browse files", (e) -> {
            textImport.openFolder();
        });
        browseFiles.setSize(100, 100);
        return browseFiles;
    }

    public static JPanel TextOriginField() {
        JPanel textOrigin = new JPanel();
        System.out.println("data"+ textImport.data);
        textOrigin.add(util.makeTextPanel("Original Text", 0, 0, 0));
        textOrigin.add(util.makeTextPanel(textImport.data, 0, 0, 0));


        return textOrigin;
    }
 
}
