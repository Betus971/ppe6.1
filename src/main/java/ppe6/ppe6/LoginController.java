package ppe6.ppe6;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.stage.StageStyle;

import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.net.URL;


public class LoginController implements Initializable {
     @FXML
     private Button CancelButton;
     @FXML
     private  Label InvalidLoginMessageLabel;
     @FXML
     private ImageView BrandimageView;
     @FXML
     private ImageView lockedview;
     @FXML
     private TextField UsernameTextField;
     @FXML
     private PasswordField PasswordTextField;


    @Override
  public void initialize(URL url, ResourceBundle rb) {
        File branding = new File("image/andrej-lisakov-V2OyJtFqEtY-unsplash.jpg");
        Image brandimage = new Image(branding.toURI().toString());
        BrandimageView.setImage(brandimage);


        File lockFile = new File("image/cle-privee.png");
        Image LockedImage = new Image(lockFile.toURI().toString());
        lockedview.setImage(LockedImage);
    }





    public  void LoginButtonOnAction(ActionEvent event) {
//            InvalidLoginMessageLabel.setText("Identifiant Invalid");
            if (!UsernameTextField.getText().isBlank() || !PasswordTextField.getText().isBlank()) {
                validLogin();

            } else{
                InvalidLoginMessageLabel.setText("Enter Username/Password");
            }
    }

    public void CancelButtonOnAction(ActionEvent event) {
       Stage stage = (Stage) CancelButton.getScene().getWindow();
       stage.close();
   }
     public void validLogin() {
        DatabaseConnection connectionNow = new DatabaseConnection();
         Connection connectionDB = connectionNow.getconnection();
         String verify ="SELECT count(1) FROM user_account login WHERE username = '"+UsernameTextField.getText()+"'and password = '"+PasswordTextField.getText()+"'";

         try {
             Statement statement = connectionDB.createStatement();
             ResultSet resultSet = statement.executeQuery(verify);

             while (resultSet.next()) {
                 if(resultSet.getInt(1)==1){
                     //InvalidLoginMessageLabel.setText("Bravo !!");
                     CreateAccountForm();
                 } else {
                     InvalidLoginMessageLabel.setText("Invalid Username or Password");
                 }

             }

         } catch ( Exception e ) {
             e.printStackTrace();
             e.getCause();

         }

     }

      public void CreateAccountForm() {
            try {
                Parent root = FXMLLoader.load(getClass().getResource("register.fxml"));
                Stage registerStage = new Stage();
                registerStage.initStyle(StageStyle.UNDECORATED);
                registerStage.setScene(new Scene(root,520,650));
                registerStage.show();



            } catch (Exception e) {
                e.printStackTrace();
                e.getCause();

            }
      }
}
