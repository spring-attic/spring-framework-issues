package org.springframework.issues.javafx.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.issues.beans.Security;
import org.springframework.issues.javafx.TestApplication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Controller;


@Controller
public class LoginController {
	@FXML
	private ResourceBundle resources;
	@FXML
	private URL location;
	@FXML
	private Label header;
	@FXML
	private PasswordField password;
	@FXML
	private TextField username;
	@Autowired
	SearchController searchController;
	@Autowired
	private Security security;
	private Stage dialogStage = null;

	@FXML
	void initialize() {
		assert header != null : "fx:id=\"header\" was not injected: check your FXML file 'login.fxml'.";
		assert password != null : "fx:id=\"password\" was not injected: check your FXML file 'login.fxml'.";
		assert username != null : "fx:id=\"username\" was not injected: check your FXML file 'login.fxml'.";
	}

	@FXML
	public void cerrar(ActionEvent event) {
		Platform.exit();
	}

	@FXML
	public void login(ActionEvent event) {
		try {
			security.authenticate(username.getText(), password.getText());
		} catch (AuthenticationException e) {
			header.setText("Username/password was incorrect, try again:");
			header.setTextFill(Color.DARKRED);
			return;
		}
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				dialogStage.close();
			}
		});
		// Lanzar la forma principal
		searchController.showView((Stage) dialogStage.getOwner());
	}

	public void showView(Stage mainStage) {
		if (dialogStage == null) {
			AnchorPane root = (AnchorPane) TestApplication.loader.load("/login.fxml");
			dialogStage = new Stage();
			dialogStage.initOwner(mainStage);
			dialogStage.initModality(Modality.WINDOW_MODAL);
			Scene scene = new Scene(root);
			dialogStage.setScene(scene);
			dialogStage.setResizable(false);
			dialogStage.initStyle(StageStyle.UNDECORATED);
		}
		dialogStage.show();
	}
}