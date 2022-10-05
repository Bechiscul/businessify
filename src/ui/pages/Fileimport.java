package ui.pages;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.*;

import ui.TextReader;
import ui.util;

public class Fileimport extends JPanel{
  
    public Fileimport() {
       super(new GridLayout(1, 3));
       this.add(DisplayFileExplorer());
        
    }

    public JButton DisplayFileExplorer() {
        TextReader textImport = new TextReader();
        return util.makeButton("Browse files", (e) -> {textImport.openFolder();});
    }
}
