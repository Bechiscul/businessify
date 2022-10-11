package ui.pages;

import javax.swing.*;
import java.awt.*;

import ui.TextReader;
import ui.util;

public class Fileimport extends JPanel {
    TextReader textImport = new TextReader();

    public Fileimport() {
        super(new GridLayout(3, 1));

        JPanel fileImportContainer = new JPanel();
        fileImportContainer.setSize(200, 150);
        fileImportContainer.add(DisplayFileExplorer());

        this.add(fileImportContainer);

        InnerFileOutput output = new InnerFileOutput();
        this.add(output);
    }

    public JButton DisplayFileExplorer() {
        JButton browseFiles = util.makeButton("Browse files", (e) -> {
            textImport.openFolder();
        });
        browseFiles.setSize(100, 100);
        return browseFiles;
    }

    /**
     * InnerFileOutput
     */
    public class InnerFileOutput extends JPanel {
        String data;

        public InnerFileOutput() {
            this.data = textImport.data;

            this.add(util.makeTextPanel("Input", 0, 0, 0));
            System.out.println("Data:" + data);

        }

    }
}
