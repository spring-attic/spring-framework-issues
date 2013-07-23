package org.springframework.issues.javafx;

import org.springframework.issues.javafx.controller.LoginController;

import javafx.application.Application;
import javafx.stage.Stage;

public class TestApplication extends Application {

	public static final SpringFxmlLoader loader = new SpringFxmlLoader();

	@Override
	public void start(Stage primaryStage) {
		LoginController loginController = SpringFxmlLoader.applicationContext.getBean(LoginController.class);
		loginController.showView(primaryStage);
	}

	public static void main(String[] args) {
		launch(args);
	}
}
