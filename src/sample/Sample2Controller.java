package sample;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;

public class Sample2Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView image_button_i;

    @FXML
    void initialize() {
        assert image_button_i != null : "fx:id=\"image_button_i\" was not injected: check your FXML file 'sample2.fxml'.";

    }
}
