package loader;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import repository.Model;

public class GuiLoader extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/sample.fxml"));
        Parent root = loader.load();
        Model model = new Model();
        Controller controller = loader.getController();
        controller.setModel(model);
        primaryStage.setTitle("Simcard Info");
        primaryStage.setScene(new Scene(root, 480, 400));
        primaryStage.sizeToScene();
        controller.updateSimcardInfo();
        primaryStage.show();
    }

    public void start(String... args) {
        launch(args);
    }

}
