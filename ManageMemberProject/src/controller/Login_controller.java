package controller;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Login_controller implements Initializable{
	
	@FXML private TextField login_id_textfield;
	@FXML private PasswordField login_pw_textfield;
	@FXML private Label login_current_date;
	@FXML private HBox testHbox;
	@FXML private Button Login_btn;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("a HH:mm");
		login_current_date.setText(sdf.format(date));
		
		Login_btn.setOnAction(e -> handleBtnLogin(e));
		
	}
	
	public void handleBtnLogin (ActionEvent event) {
		
		String id = login_id_textfield.getText();
		String pw = login_pw_textfield.getText();
		
		
		
		
		
		try {
			Parent signup=FXMLLoader.load(getClass().getClassLoader().getResource("view/MainWindow.fxml"));
			Scene scene = new Scene(signup);
			Stage primaryStage = (Stage) Login_btn.getScene().getWindow();
			primaryStage.setTitle("Central_ove");
			primaryStage.setScene(scene);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
