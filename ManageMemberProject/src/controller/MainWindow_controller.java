package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ScrollPane;

public class MainWindow_controller implements Initializable{
	
	@FXML private ScrollPane Mainwindow_scrollpane;
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		Mainwindow_scrollpane.vbarPolicyProperty().setValue(ScrollPane.ScrollBarPolicy.NEVER);
		Mainwindow_scrollpane.hbarPolicyProperty().setValue(ScrollPane.ScrollBarPolicy.NEVER);
		
	}

}
