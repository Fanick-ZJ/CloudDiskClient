import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainPane extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        //根节点
        AnchorPane root = new AnchorPane();
        root.setPrefSize(1000,600);
        root.setId("root");
        //侧边栏
        VBox siderBar = new VBox();
        siderBar.setPrefWidth(100);
        siderBar.setId("siderBar");
        siderBar.setStyle("-fx-background-color: f5f5f6");


        root.getChildren().add(siderBar);
        Application.setUserAgentStylesheet(getClass().getResource("css/MainPane.css").toExternalForm());
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
