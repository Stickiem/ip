package stickiem;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * A GUI for Stickiem using FXML.
 */
public class Main extends Application {

    private final Stickiem stickiem = new Stickiem("stickiem.txt");

    @Override
    public void start(Stage stage) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/view/MainWindow.fxml"));
            AnchorPane ap = fxmlLoader.load();
            Scene scene = new Scene(ap);
            stage.setScene(scene);
            fxmlLoader.<Ui>getController().setDuke(stickiem);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
