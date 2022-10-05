import javax.swing.JLabel;

import ui.TextReader;
import ui.Window;

public class App {
    public static void main(String[] args) throws Exception {
        JLabel test = new JLabel("test");
        JLabel test2 = new JLabel("test");

        Window mainApp = new Window();

        mainApp.makeTab("test", test);   
        mainApp.makeTab("test2", test2);

        TextReader text = new TextReader();
        text.openFolder();
    }
}
