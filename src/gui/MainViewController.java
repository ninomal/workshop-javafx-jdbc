package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import gui.util.Alerts;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

public class MainViewController implements Initializable{
	
	@FXML
	private MenuItem sellerMenuItem;
	
	@FXML
	private MenuItem departmentMenuItem;
	
	@FXML
	private MenuItem aboutMenuItem;
	
	@FXML
	public void onSellerMenuItemAction() {
		System.out.println("seller");
	}

	@FXML
	public void onDepartmentMenuItemAction() {
		loadView("/gui/DepartmentList.fxml");
	}
		
	@FXML
	public void onAboutMenuItemAction() {
		loadView("/gui/About.fxml");
	}
	
	@Override
	public void initialize(URL url, ResourceBundle res) {		
		
	}

	public synchronized void  loadView(String absolutName) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(absolutName));	
			VBox vbox =  loader.load();		
			Scene mainScene = Main.getMainScene();
			VBox mainVbox = (VBox)((ScrollPane)mainScene.getRoot()).getContent();
			
			Node mainMenu = mainVbox.getChildren().get(0);
			mainVbox.getChildren().clear();
			mainVbox.getChildren().add(mainMenu);
			mainVbox.getChildren().addAll(vbox.getChildren());
			
		} catch (IOException e) {
			Alerts.showAlert("Error", null, e.getMessage(), AlertType.ERROR);
		}
	}

	
	
	
}
