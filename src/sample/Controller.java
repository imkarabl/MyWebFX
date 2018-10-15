package sample;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.anim.Shake;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField login_field;

    @FXML
    private TextField pass_field;

    @FXML
    private Button SignButton;

    @FXML
    private Button SignupButton;

    @FXML
    void initialize() {

        SignButton.setOnAction(event -> {
            String logintext = login_field.getText().trim();
            String loginpassword = pass_field.getText().trim();

            if(!logintext.equals("") && !loginpassword.equals("")){
                try {
                    loginUser(logintext, loginpassword);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            else
                System.out.println("error");
        });


        SignupButton.setOnAction(event -> {
            Opennewscene("/sample/signup.fxml", SignupButton);

        });

    }

    private void loginUser(String logintext, String loginpassword) throws SQLException {
        DatabaseHandler dbHandler = new DatabaseHandler();
        Users user = new Users();
        user.setUsername(logintext);
        user.setPassword(loginpassword);
        ResultSet res = dbHandler.getUser(user);

        int counter = 0;

    while (res.next()) {
        counter++;
        System.out.println("where is counter = "+ counter);
    }


        if (counter >=1) {
            Opennewscene("/sample/sample2.fxml", SignupButton);
        }
        else {

            Shake uselogadmin = new Shake(login_field);
            Shake usepasadmin = new Shake(pass_field);
            uselogadmin.playAnim();
            usepasadmin.playAnim();

        }

    }

    public void Opennewscene(String window,Button button){
        button.getScene().getWindow().hide();

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(window));

        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.showAndWait();


    }
}

