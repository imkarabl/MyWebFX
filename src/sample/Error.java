package sample;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Error {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button Repeatbutton;

    @FXML
    void initialize() {
       Repeatbutton.setOnAction(event -> {
           Repeatbutton.getScene().getWindow().hide();
           System.out.println("123");
       });
    }
}
