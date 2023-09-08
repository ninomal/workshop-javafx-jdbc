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
import model.service.DepartmentService;

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
		loadView("/gui/DepartmentList.fxml", (DepartmentListController controller) -> {
			controller.setDepartService(new DepartmentService());
			controller.updateTableview();
		});
	}
		
	@FXML
	public void onAboutMenuItemAction() {
		loadView("/gui/About.fxml", x -> {});
	}
	
	@Override
	public void initialize(URL url, ResourceBundle res) {		
		
	}

	public synchronized <T> void  loadView(String absolutName, java.util.function.Consumer<T> initialingAction) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(absolutName));	
			VBox vbox =  loader.load();		
			Scene mainScene = Main.getMainScene();
			VBox mainVbox = (VBox)((ScrollPane)mainScene.getRoot()).getContent();
			
			Node mainMenu = mainVbox.getChildren().get(0);
			mainVbox.getChildren().clear();
			mainVbox.getChildren().add(mainMenu);
			mainVbox.getChildren().addAll(vbox.getChildren());
			
			T controller = loader.getController();
			initialingAction.accept(controller);
			
		} catch (IOException e) {
			Alerts.showAlert("Error", null, e.getMessage(), AlertType.ERROR);
		}
	}


	
	
}
