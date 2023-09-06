package gui;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;

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
		System.out.println("depart");
	}
		
	@FXML
	public void onAboutMenuItemAction() {
		System.out.println("about");
	}
	
	@Override
	public void initialize(URL url, ResourceBundle res) {
		
		
		
		
	}

	

	
	
	
}
