package application;

import java.io.File;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class QuanLi {
	@FXML
	private Button btnProduct;
	
	@FXML
	private SplitPane splitPane;
	
	@FXML
	private Tab tabProduct;
	
	@FXML
	private TabPane allTabs;
	
	@FXML
	private TableView<Object> tblProduct;
	
	@FXML
	private void initialize() {
		tabProduct.getTabPane().getTabs().remove(tabProduct);
	}
	
	@FXML
	private void actionListProduct(){
		allTabs.getTabs().add(tabProduct);
	}
	
	public QuanLi() {
		super();
		
	}
}