package application;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;

import bus.KhachHang_BUS;
import entity.KhachHang;
import javafx.beans.property.ReadOnlyBooleanWrapper;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Ctrl_MainMenu {
	@FXML
	private Button btnXe, btnLinhKien;
	@FXML
	private TableView tblKhachHang, tblProduct;
	@FXML
	private SplitPane splitPaneXe, splitPaneLK, splitPaneBH;
	@FXML
	private Tab tabProduct;
	@FXML
	private TabPane allTabs;
	@FXML
	private TableColumn<KhachHang, String> colMaKH, colHoTen, colNgaySinh, colDiaChi, colSDT, colEmail;
	@FXML
	private TableColumn<KhachHang, Boolean> colGioiTinh;
	@FXML
	private TableColumn<KhachHang, Number> colSTT;
	
	private KhachHang_BUS kh_bus;
	private ObservableList<KhachHang> listKHObs = FXCollections.observableArrayList();
	
	@FXML
	private Tab tabKH;
	
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
	
	@FXML
	private void actionTabChange() {
		KhachHang temp;
		LocalDate date = LocalDate.now();
		

		if (tabKH.isSelected()) {
			loadDataKH();
			tblKhachHang.setItems(listKHObs);

			//Load KH: listKHObs.add(temp);
		}
	}
	
	@FXML
	private void actionBtnSuaKH(){
		// TODO Auto-generated method stub
		BorderPane frmEdit;
		try {
			KhachHang temp = (KhachHang) tblKhachHang.getSelectionModel().getSelectedItem();
			
			FXMLLoader fxmlLoad = new FXMLLoader(getClass().getResource("FrmDienTTKhachHang.fxml"));
			frmEdit = (BorderPane) fxmlLoad.load();
			Ctrl_DienThongTinKH ctrlDienTT = fxmlLoad.getController();
			ctrlDienTT.loadData(temp);
			
			Scene sceneTaoKH = new Scene(frmEdit);
			Stage secondaryStage = new Stage();
			secondaryStage.setScene(sceneTaoKH);
			secondaryStage.setResizable(false);
			secondaryStage.show();
				
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*
	 * Phần xử lí dữ liệu bảng Khách Hàng
	 */
	
	private void loadDataKH() {
		colMaKH.setCellValueFactory(new PropertyValueFactory<>("maKhachHang"));
		colHoTen.setCellValueFactory(new PropertyValueFactory<>("tenKhachHang"));
		colDiaChi.setCellValueFactory(new PropertyValueFactory<>("diaChi"));
		colSDT.setCellValueFactory(new PropertyValueFactory<>("soDT"));
		colGioiTinh.setCellValueFactory(new PropertyValueFactory<>("gioiTinh"));
		colGioiTinh.setCellFactory(column -> {
			return new TableCell<KhachHang, Boolean>(){
				@Override
				protected void updateItem(Boolean item, boolean empty) {
					super.updateItem(item, empty);
					if (item == null) {
						setText(null);
					}else {
						setText(item ? "Nam" : "Nữ");
					}
				}
			};
		});
		colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
		colNgaySinh.setCellValueFactory(new PropertyValueFactory<>("ngaySinh"));
		
		// Auto numbered
		colSTT.setSortable(false);
		colSTT.setCellValueFactory(col -> 
			new ReadOnlyObjectWrapper<Number>(tblKhachHang.getItems().indexOf(col.getValue()) + 		1));
	}
	
	public Ctrl_MainMenu() {
		super();
		kh_bus = new KhachHang_BUS();
	}
}