package controller;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Login_controller implements Initializable{
	
	@FXML private TextField login_id_textfield;
	@FXML private Label login_current_date;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("a HH:mm");
		
		login_current_date.setText(sdf.format(date));
		
	}

}
