package ui;

import javax.swing.*;
import java.awt.*;

public class Window extends JPanel {

    public static JFrame frame = new JFrame("Businessify"); // main window frame (Global: To only construct one frame and not allocations of multiple frames)
    JTabbedPane tabbedPane = new JTabbedPane(); // Tab menu
    
    public Window() {
        super(new GridLayout(1, 3));
    }

    public JFrame GetFrame() {
        return frame;
    }
    
    public void makeTab(String title, JComponent comp) {
     
        tabbedPane.addTab(title, comp);
        // The following line enables to use scrolling tabs.
        tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Add content to the window.
        frame.add(tabbedPane, BorderLayout.CENTER);
        // Display the window.
        frame.setSize(400, 400);
        frame.setResizable(false);
        frame.setVisible(true);
    }
}
