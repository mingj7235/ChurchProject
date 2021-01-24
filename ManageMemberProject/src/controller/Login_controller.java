package controller;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
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
		
		login_id_textfield.setOnKeyPressed(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent event) {
				if(event.getCode() == KeyCode.ENTER) {
					String id = login_id_textfield.getText();
					String pw = login_pw_textfield.getText();
					UserDAO dao = new UserDAO();
					if(dao.login(id, pw) == 1) {
						try {
							Parent signup=FXMLLoader.load(getClass().getClassLoader().getResource("view/MainWindow.fxml"));
							Scene scene = new Scene(signup);
							Stage primaryStage = (Stage) Login_btn.getScene().getWindow();
							primaryStage.setTitle("Central_ove");
							primaryStage.setScene(scene);
						}catch (Exception e) {
							e.printStackTrace();
						}
					//새가족 계정
					} else if (dao.login(id, pw) == 2) {
						//resource 수정해야함 
						try {
							Parent signup=FXMLLoader.load(getClass().getClassLoader().getResource("view/MainWindow.fxml"));
							Scene scene = new Scene(signup);
							Stage primaryStage = (Stage) Login_btn.getScene().getWindow();
							primaryStage.setTitle("Central_ove");
							primaryStage.setScene(scene);
						}catch (Exception e) {
							e.printStackTrace();
						}
					} else {
						//로그인 실패 
						System.out.println("비밀번호 확인");
					}
				}
			};
		});
		login_pw_textfield.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				if(event.getCode() == KeyCode.ENTER) {
					String id = login_id_textfield.getText();
					String pw = login_pw_textfield.getText();
					UserDAO dao = new UserDAO();
					if(dao.login(id, pw) == 1) {
						try {
							Parent signup=FXMLLoader.load(getClass().getClassLoader().getResource("view/MainWindow.fxml"));
							Scene scene = new Scene(signup);
							Stage primaryStage = (Stage) Login_btn.getScene().getWindow();
							primaryStage.setTitle("Central_ove");
							primaryStage.setScene(scene);
						}catch (Exception e) {
							e.printStackTrace();
						}
					//새가족 계정
					} else if (dao.login(id, pw) == 2) {
						//resource 수정해야함 
						try {
							Parent signup=FXMLLoader.load(getClass().getClassLoader().getResource("view/MainWindow.fxml"));
							Scene scene = new Scene(signup);
							Stage primaryStage = (Stage) Login_btn.getScene().getWindow();
							primaryStage.setTitle("Central_ove");
							primaryStage.setScene(scene);
						}catch (Exception e) {
							e.printStackTrace();
						}
					} else {
						//로그인 실패 
						System.out.println("비밀번호 확인");
					}
				}
			}
		});
		
		Login_btn.setOnAction(e -> handleBtnLogin(e));
		
	}
	
	public void handleBtnLogin (ActionEvent event) {
		String id = login_id_textfield.getText();
		String pw = login_pw_textfield.getText();
		UserDAO dao = new UserDAO();
		//관리자계정
		if(dao.login(id, pw) == 1) {
			try {
				Parent signup=FXMLLoader.load(getClass().getClassLoader().getResource("view/MainWindow.fxml"));
				Scene scene = new Scene(signup);
				Stage primaryStage = (Stage) Login_btn.getScene().getWindow();
				primaryStage.setTitle("Central_ove");
				primaryStage.setScene(scene);
			}catch (Exception e) {
				e.printStackTrace();
			}
		//새가족 계정
		} else if (dao.login(id, pw) == 2) {
			//resource 수정해야함 
			try {
				Parent signup=FXMLLoader.load(getClass().getClassLoader().getResource("view/MainWindow.fxml"));
				Scene scene = new Scene(signup);
				Stage primaryStage = (Stage) Login_btn.getScene().getWindow();
				primaryStage.setTitle("Central_ove");
				primaryStage.setScene(scene);
			}catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			//로그인 실패 
			System.out.println("비밀번호 확인");
		}
		
		
		
	}

}
