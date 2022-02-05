import javafx.application.Application;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class CloudDiskApp extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {

        Stage loginPane = new LoginPane().getLoginPane();
        loginPane.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
