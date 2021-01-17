package view;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class ChurchMain extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		System.setProperty("prism.lcdtext", "false");
		Font.loadFont(getClass().getResource("/resources/NanumGothic.ttf").toExternalForm(), 10);
		
		primaryStage.setTitle("Login");
		Parent root = FXMLLoader.load(ChurchMain.class.getResource("/view/Login.fxml"));
		Scene scene = new Scene (root);
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();

	}
	public static void main(String[] args) {
		launch(args);
	}
}