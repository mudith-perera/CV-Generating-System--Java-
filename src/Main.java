import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Gui gui = new Gui();
        gui.logIn();
    }

    public static void main(String[] args) {
        launch();
    }
}
