package sample.controllers;

import dao.DatabaseHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.User;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SignUpController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button onHomeButton;

    @FXML
    private TextField login_field;

    @FXML
    private TextField pass_field;

    @FXML
    private Button SignUpButton;

    @FXML
    private TextField Firstname_field;

    @FXML
    private TextField Lastname_field;

    @FXML
    private TextField country_field;

    @FXML
    private CheckBox Checkboxmale;

    @FXML
    private CheckBox Checkboxfemale;

    @FXML
    private TextField pass_field1;


    @FXML
    void initialize() {

        onHomeButton.setOnAction(event -> {
            Controller controller = new Controller();
            controller.Opennewscene("/sample.fxml", onHomeButton);
        });


        SignUpButton.setOnAction(event -> {

            SignUpNewUser();

        });


    }

    private void SignUpNewUser() {
        DatabaseHandler dbHandler = new DatabaseHandler();
        String firstName = Firstname_field.getText();
        String lastName = Lastname_field.getText();
        String username = login_field.getText();
        String password = pass_field.getText();
        String password1 = pass_field1.getText();
        String country = country_field.getText();
        String gender = "";
        if (Checkboxmale.isSelected())
            gender = "Male";
        else
            gender = "Female";
        if (password.equals(password1)) {

            User user = new User(firstName, lastName, username, password, country, gender);
            dbHandler.signUpUser(user);
        } else {

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/error.fxml"));

            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();


            //StackPane layot = new StackPane();
          /*  Shake password1anim = new Shake(pass_field1);
            password1anim.playAnim();*/

        }
    }
}
