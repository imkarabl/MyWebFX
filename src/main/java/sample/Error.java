package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

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
