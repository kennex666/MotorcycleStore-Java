package application;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;

import bus.KhachHang_BUS;
import connectDB.ConnectDB;
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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import utilities.PopupNotify;
import utilities.SelectedTab;

public class Ctrl_MainMenu {
	private SelectedTab tabSelected;
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
	@FXML
	private Tab tabKH;
	@FXML
	private TextField txtSearch;
	

	private KhachHang_BUS kh_bus;
	private ObservableList<KhachHang> listKHObs = FXCollections.observableArrayList();
	
	@FXML
	private void initialize() {

		// Preload for KhachHang Table
		loadDataTablePropertyKH();
		tblKhachHang.setItems(listKHObs);
		
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
		
		// Remove after not work
		if (!tabKH.isSelected() && tabSelected == SelectedTab.KhachHang) {
			removeAllRowsKH();
		}
		if (tabKH.isSelected()) {
			tabSelected = SelectedTab.KhachHang;
			loadDataKHToTable();
		}
		
	}
	

	
	/*
	 * Handle event Tab KhachHang
	 */
	@FXML
	private void actionBtnSuaKH(){
		KhachHang temp = (KhachHang) tblKhachHang.getSelectionModel().getSelectedItem();
		if (temp == null) {
			PopupNotify.showErrorField("Lỗi", "Vui lòng chọn khách hàng cần thay đổi thông tin", "Hãy chọn 1 khách hàng cụ thể để tiếp tục!");
			return;
		}
		Ctrl_DienThongTinKH ctrlDienTT = actionBtnThemKH();
		ctrlDienTT.loadData(temp);
	}
	
	@FXML
	private Ctrl_DienThongTinKH actionBtnThemKH(){
		// TODO Auto-generated method stub
		BorderPane frmEdit;
		try {
			FXMLLoader fxmlLoad = new FXMLLoader(getClass().getResource("FrmDienTTKhachHang.fxml"));
			frmEdit = (BorderPane) fxmlLoad.load();
			Ctrl_DienThongTinKH ctrlDienTT = fxmlLoad.getController();
			ctrlDienTT.setTableModel(listKHObs);
			Scene sceneTaoKH = new Scene(frmEdit);
			Stage secondaryStage = new Stage();
			secondaryStage.setScene(sceneTaoKH);
			secondaryStage.setResizable(false);
			secondaryStage.show();
			return ctrlDienTT;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	private void loadDataTablePropertyKH() {
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
			new ReadOnlyObjectWrapper<Number>(tblKhachHang.getItems().indexOf(col.getValue()) + 1));

	}
	
	private void loadDataKHToTable() {
		ArrayList<KhachHang> listKH = kh_bus.getAllCustomers();
		for (KhachHang x : listKH)
			listKHObs.add(x);
	}
	
	private void removeAllRowsKH() {
		// TODO Auto-generated method stub
		listKHObs.clear();
	}
	
	@FXML
	private void actionSearchKH() {
		// TODO Auto-generated method stub
		String ma = txtSearch.getText();
		removeAllRowsKH();
		if (ma.isBlank()) {
			loadDataKHToTable();
		}else {
			ArrayList<KhachHang> listSearch = kh_bus.findCustomers(ma);
			for (KhachHang x : listSearch) {
				listKHObs.add(x);
			}
		}
	}
	
	@FXML
	private void actionBtnDeleteKH() {
		// TODO Auto-generated method stub
		KhachHang temp = (KhachHang) tblKhachHang.getSelectionModel().getSelectedItem();
		if (temp == null) {
			PopupNotify.showErrorField("Lỗi", "Vui lòng chọn khách hàng cần thay đổi thông tin", "Hãy chọn 1 khách hàng cụ thể để tiếp tục!");
			return;
		}
		if (PopupNotify.confirmNotification("Xác nhận thay đổi", "Bạn có chắc chắn muốn xoá thông tin khách hàng " + temp.getTenKhachHang() +"?", "Lưu ý: Thao tác không thể hoàn tác!")) {
			if (kh_bus.deleteCustomer(temp)) {
				PopupNotify.successNotify("Thông tin", "Đã xoá khách hàng " + temp.getTenKhachHang() + "!", null);
				listKHObs.remove(temp);
			}else {
				PopupNotify.showErrorField("Lỗi", "Lỗi cơ sở dữ liệu! Thao tác thất bại.", "Hãy liên hệ với QTV để được hỗ trợ thêm.");
			}
		}
	}
	
	@FXML
	private void actionRefreshTableKH() {
		// TODO Auto-generated method stub
		removeAllRowsKH();
		loadDataKHToTable();
		txtSearch.setText("");
		
	}
	
	
	public Ctrl_MainMenu() {
		super();
		ConnectDB.getInstance().connect();
		kh_bus = new KhachHang_BUS();

		tabSelected = SelectedTab.MainMenu;
	}
}