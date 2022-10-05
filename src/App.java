import ui.Window;
import ui.pages.Fileimport;

public class App {
    public static void main(String[] args) throws Exception {
        Window mainApp = new Window();
        Fileimport importUi = new Fileimport();

        mainApp.makeTab("Import file", importUi);

    }
}
