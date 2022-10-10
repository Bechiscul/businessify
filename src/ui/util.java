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

    public static JSpinner makeSpinner(double minimum, double maximum, double stepSize) {
        /**
         * Make spinner with min and max value
         * includes stepsize
         */
        SpinnerNumberModel spinnerRange = new SpinnerNumberModel(0, minimum, maximum, stepSize);
        JSpinner spinner = new JSpinner(spinnerRange);

        // set the preferred size
        Dimension d = spinner.getPreferredSize();
        d.width = 100;
        spinner.setPreferredSize(d);
        return spinner;
    }

    public static JPanel makeTextPanel(String text, int r, int g, int b) {
        // Make common text panel
        JPanel panel = new JPanel(false);
        JLabel filler = new JLabel(text);
        filler.setHorizontalAlignment(JLabel.CENTER);
        filler.setForeground(new Color(r, g, b));
        panel.setLayout(new GridLayout(1, 1));
        panel.add(filler);
        return panel;
    }
}
