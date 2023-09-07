package gui;

import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.entities.Department;

public class DepartmentListController implements Initializable{
	
	@FXML
	private TableColumn<Department, Integer> tableColumn;
	
	@FXML
	private TableColumn<Department, String> tableName;
	
	@FXML
	private TableView<Department> tableDepart;
	
	@FXML
	private Button newBt;
	
	@FXML
	public void onNewBtAction() {
		System.out.println("New");
	}

	@Override
	public void initialize(URL url, ResourceBundle resou) {
		
		initiableNodes();
		
	}

	private void initiableNodes() {
		tableColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
		tableName.setCellValueFactory(new PropertyValueFactory<>("name"));
		
		Stage stage = (Stage) Main.getMainScene().getWindow();
		tableDepart.prefHeightProperty().bind(stage.heightProperty());
	}

}
