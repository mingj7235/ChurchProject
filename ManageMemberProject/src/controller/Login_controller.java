package controller;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class Login_controller implements Initializable{
	
	@FXML private TextField login_id_textfield;
	@FXML private Label login_current_date;
	@FXML private HBox testHbox;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("a HH:mm");
		
		
		login_current_date.setText(sdf.format(date));
		
	}

}
