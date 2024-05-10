package controller;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class LoginController {
	
	@FXML
	private TextField email;
	
	@FXML
	private TextField senha;
	
	
	public void entrar() {
		System.out.println("Tentativa de Login...");
		//logica de entrada
		if (email.getText().equals("admin") && senha.getText().equals("admin")) {
			try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/dashboardSaturnFlora.fxml"));
			
			StackPane root = loader.load();
				
				Scene scene = new Scene(root, 750, 450);
				
				Stage currentStage = (Stage) email.getScene().getWindow();
				currentStage.setScene(scene);
				currentStage.setTitle("Dashboard");
			    currentStage.show();
			    
			} catch (IOException e) {
			e.printStackTrace();
			}
			
		}else {
			mensagemDeErro();
		}
	}
	public void mensagemDeErro() {
		Alert alert = new Alert(Alert.AlertType.ERROR);
		alert.setTitle("Sua senha esta errada");
		alert.setContentText("Senha incorreta!");
		alert.setHeaderText(null);
		alert.showAndWait();
	}
}
