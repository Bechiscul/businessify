package ui.pages;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.*;

import ui.TextReader;
import ui.util;

public class Fileimport extends JPanel {

    public Fileimport() {
        super(new GridLayout(1, 3));
        JPanel fileImportContainer = new JPanel();
        fileImportContainer.setSize(200, 150);

        fileImportContainer.add(DisplayFileExplorer());

        this.add(fileImportContainer);
    }

    public JButton DisplayFileExplorer() {
        TextReader textImport = new TextReader();
        JButton browseFiles = util.makeButton("Browse files", (e) -> {
            textImport.openFolder();
        });
        browseFiles.setSize(100, 100);
        return browseFiles;
    }
}
