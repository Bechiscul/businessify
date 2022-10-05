package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class util {
    public static JButton makeButton(String title, ActionListener listener) {
        // Make common button
        JButton btn = new JButton(title);
        btn.addActionListener(listener);
        btn.setSize(100, 100);
        return btn;
    }
}
