package application;

import java.io.File;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Ctrl_MainMenu {
	@FXML
	private Button btnXe;
	
	@FXML
	private Button btnLinhKien;

	
	@FXML
	private SplitPane splitPaneXe;
	
	@FXML
	private SplitPane splitPaneLK;

	@FXML
	private SplitPane splitPaneBH;
	
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
	
	@FXML
	private void actionAddSplitPaneXe() {
		allTabs.getTabs().add(tabProduct);
		splitPaneXe.setVisible(true);
		splitPaneLK.setVisible(false);
		splitPaneBH.setVisible(false);
	}
	
	@FXML
	private void actionAddSplitPaneLK() {
		allTabs.getTabs().add(tabProduct);
		splitPaneLK.setVisible(true);
		splitPaneXe.setVisible(false);
		splitPaneBH.setVisible(false);
	}
	
	@FXML
	private void actionAddSplitPaneBH() {
		allTabs.getTabs().add(tabProduct);
		splitPaneBH.setVisible(true);
		splitPaneXe.setVisible(false);
		splitPaneLK.setVisible(false);
	}
	
	public Ctrl_MainMenu() {
		super();
	}
}