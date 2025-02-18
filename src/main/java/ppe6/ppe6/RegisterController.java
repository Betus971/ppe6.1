package ppe6.ppe6;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ResourceBundle;


public class RegisterController implements Initializable {
    @FXML
    private ImageView ubikdImageView;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private PasswordField confirmPassword;

    public void initialize(URL url, ResourceBundle rb) {
        File ubikd = new File("image/croquis.png");
        Image ubikdImage = new Image(ubikd.toURI().toString());
        ubikdImageView.setImage(ubikdImage);

    }

}
