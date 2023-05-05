package application;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;

import bus.KhachHang_BUS;
import bus.LinhKien_BUS;
import bus.NhanVien_BUS;
import connectDB.ConnectDB;
import entity.ChiTietSuaChua;
import entity.ChucVu;
import entity.KhachHang;
import entity.LinhKien;
import entity.NhanVien;
import javafx.beans.property.ReadOnlyBooleanWrapper;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.beans.property.ReadOnlyObjectWrapper;
import bus.NhaCungCap_BUS;
import bus.Xe_BUS;
import connectDB.ConnectDB;
import dao.NhaCungCap_DAO;
import entity.KhachHang;
import entity.NhaCungCap;
import entity.Xe;
import javafx.beans.property.SimpleStringProperty;
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
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import utilities.PopupNotify;
import utilities.SelectedTab;

public class Ctrl_MainMenu {
	private NhaCungCap_BUS ncc_bus;
	private SelectedTab tabSelected;
	@FXML
	private Button btnXe, btnLinhKien;
	@FXML
	private TableView tblKhachHang, tblNhanVien;
	@FXML
	private SplitPane splitPaneXe, splitPaneLK, splitPaneBH;
	@FXML
	private Tab tabProduct, tabNhanVien, tabKH;
	@FXML
	private TabPane allTabs;
	@FXML
	private TableColumn<KhachHang, String> colMaKH, colHoTen, colNgaySinh, colDiaChi, colSDT, colEmail;
	@FXML
	private TableColumn<KhachHang, Boolean> colGioiTinh;
	@FXML
	private TableColumn<KhachHang, Number> colSTT;
	@FXML
	private TableColumn<NhanVien, String> colnvMa, colnvHoTen, colnvNgaySinh, colnvDiaChi, colnvSDT, colnvEmail;
	@FXML
	private TableColumn<NhanVien, Boolean> colnvGioiTinh;
	@FXML
	private TableColumn<NhanVien, ChucVu> colnvChucVu;
	@FXML
	private TableColumn<NhanVien, Number> colnvSTT;
	@FXML
	private TextField txtSearch, txtNVSearch;
	

	private KhachHang_BUS kh_bus;
	private ObservableList<KhachHang> listKHObs;
	private NhanVien_BUS nv_bus;
	private ObservableList<NhanVien> listNVObs;
	
	@FXML
	private void initialize() {

		// Preload for KhachHang Table
		loadDataTablePropertyKH();
		loadDataTablePropertyNV();
		tblKhachHang.setItems(listKHObs);
		tblNhanVien.setItems(listNVObs);
		themDuLieuNCC();
		//tabProduct.getTabPane().getTabs().remove(tabProduct);
	}
	
	@FXML
	private AnchorPane paneLK;
	
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
		
		// Remove after not work
		if (!tabKH.isSelected() && tabSelected == SelectedTab.KhachHang) {
			removeAllRowsKH();
		}
		if (tabKH.isSelected()) {
			tabSelected = SelectedTab.KhachHang;
			loadDataKHToTable();
		}

		if (!tabNhanVien.isSelected() && tabSelected == SelectedTab.NhanVien) {
			removeAllRowsNV();
		}
		if (tabNhanVien.isSelected()) {
			tabSelected = SelectedTab.NhanVien;
			loadDataNVToTable();
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
	
	@FXML
	private void actionLocKHNangCao() {// TODO Auto-generated method stub
		BorderPane frmEdit;
		try {
			FXMLLoader fxmlLoad = new FXMLLoader(getClass().getResource("FrmTimKHNangCao.fxml"));
			frmEdit = (BorderPane) fxmlLoad.load();
			Ctrl_TimKHNangCao ctrlDienTT = fxmlLoad.getController();
			ctrlDienTT.setTableModel(listKHObs);
			Scene sceneTaoKH = new Scene(frmEdit);
			Stage secondaryStage = new Stage();
			secondaryStage.setScene(sceneTaoKH);
			secondaryStage.setResizable(false);
			secondaryStage.show();
			return;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

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
	
	/*
	 * Handle event Tab NhanVien
	 */
	@FXML
	private void actionBtnSuaNV(){
		NhanVien temp = (NhanVien) tblNhanVien.getSelectionModel().getSelectedItem();
		if (temp == null) {
			PopupNotify.showErrorField("Lỗi", "Vui lòng chọn nhân viên cần thay đổi thông tin", "Hãy chọn 1 nhân viên cụ thể để tiếp tục!");
			return;
		}
		Ctrl_DienThongTinNV ctrlDienTT = actionBtnThemNV();
		ctrlDienTT.loadData(temp);
	}
	
	@FXML
	private Ctrl_DienThongTinNV actionBtnThemNV(){
		// TODO Auto-generated method stub
		BorderPane frmEdit;
		try {
			FXMLLoader fxmlLoad = new FXMLLoader(getClass().getResource("FrmDienTTNhanVien.fxml"));
			frmEdit = (BorderPane) fxmlLoad.load();
			Ctrl_DienThongTinNV ctrlDienTT = fxmlLoad.getController();
			ctrlDienTT.setTableModel(listNVObs);
			Scene sceneTaoNV = new Scene(frmEdit);
			Stage secondaryStage = new Stage();
			secondaryStage.setScene(sceneTaoNV);
			secondaryStage.setResizable(false);
			secondaryStage.show();
			return ctrlDienTT;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	private void loadDataTablePropertyNV() {
		colnvMa.setCellValueFactory(new PropertyValueFactory<>("maNhanVien"));
		colnvHoTen.setCellValueFactory(new PropertyValueFactory<>("tenNhanVien"));
		colnvDiaChi.setCellValueFactory(new PropertyValueFactory<>("diaChi"));
		colnvSDT.setCellValueFactory(new PropertyValueFactory<>("soDT"));
		colnvChucVu.setCellValueFactory(new PropertyValueFactory<>("chucVu"));
		colnvGioiTinh.setCellValueFactory(new PropertyValueFactory<>("gioiTinh"));
		colnvGioiTinh.setCellFactory(column -> {
			return new TableCell<NhanVien, Boolean>(){
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
		colnvEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
		colnvNgaySinh.setCellValueFactory(new PropertyValueFactory<>("ngaySinh"));
		
		// Auto numbered
		colnvSTT.setSortable(false);
		colnvSTT.setCellValueFactory(col -> 
			new ReadOnlyObjectWrapper<Number>(tblNhanVien.getItems().indexOf(col.getValue()) + 1));

	}
	
	private void loadDataNVToTable() {
		ArrayList<NhanVien> listNV = nv_bus.getAllEmployees();
		for (NhanVien x : listNV)
			listNVObs.add(x);
	}
	
	private void removeAllRowsNV() {
		// TODO Auto-generated method stub
		listNVObs.clear();
	}
	
	@FXML
	private void actionSearchNV() {
		// TODO Auto-generated method stub
		String ma = txtNVSearch.getText();
		removeAllRowsNV();
		if (ma.isBlank()) {
			loadDataKHToTable();
		}else {
			ArrayList<NhanVien> listSearch = nv_bus.findEmployee(ma);
			for (NhanVien x : listSearch) {
				listNVObs.add(x);
			}
		}
	}
	
	@FXML
	private void actionBtnDeleteNV() {
		// TODO Auto-generated method stub
		NhanVien temp = (NhanVien) tblNhanVien.getSelectionModel().getSelectedItem();
		if (temp == null) {
			PopupNotify.showErrorField("Lỗi", "Vui lòng chọn nhân viên cần thay đổi thông tin", "Hãy chọn 1 nhân viên cụ thể để tiếp tục!");
			return;
		}
		if (PopupNotify.confirmNotification("Xác nhận thay đổi", "Bạn có chắc chắn muốn xoá thông tin nhân viên " + temp.getMaNhanVien() +"?", "Lưu ý: Thao tác không thể hoàn tác!")) {
			if (nv_bus.deleteEmployee(temp)) {
				PopupNotify.successNotify("Thông tin", "Đã xoá nhân viên " + temp.getTenNhanVien() + "!", null);
				listNVObs.remove(temp);
			}else {
				PopupNotify.showErrorField("Lỗi", "Lỗi cơ sở dữ liệu! Thao tác thất bại.", "Hãy liên hệ với QTV để được hỗ trợ thêm.");
			}
		}
	}
	
	@FXML
	private void actionRefreshTableNV() {
		// TODO Auto-generated method stub
		removeAllRowsNV();
		loadDataNVToTable();
		txtNVSearch.setText("");
		
	}
	
	@FXML
	private void actionLocNVNangCao() {// TODO Auto-generated method stub
		BorderPane frmEdit;
		try {
			FXMLLoader fxmlLoad = new FXMLLoader(getClass().getResource("FrmTimNVNangCao.fxml"));
			frmEdit = (BorderPane) fxmlLoad.load();
			Ctrl_TimNVNangCao ctrlDienTT = fxmlLoad.getController();
			ctrlDienTT.setTableModel(listNVObs);
			Scene sceneTaoKH = new Scene(frmEdit);
			Stage secondaryStage = new Stage();
			secondaryStage.setScene(sceneTaoKH);
			secondaryStage.setResizable(false);
			secondaryStage.show();
			return;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
	@FXML
	private TextField txtTenXe,txtLoaiXe,txtSoKhung,txtSoSuon,txtSoPK,txtMauXe,txtNhaSX,txtGia,txtSoLuongKho,txtNuocSX;
	
	@FXML
	private Button btnThemXe,btnXoaTrangXe,btnSuaXe,btnXoaXe;
	
	@FXML
	private ObservableList<Xe> listXeObs = FXCollections.observableArrayList();
	
	
	@FXML
	private void themXe() throws Exception {
		Xe xe;
		String maXe;
		String tenXe;
		String loaiXe;
		String nuocSX;
		double soPK; String soPk_String;
		String soKhung;
		String soSuon;
		String mauXe;
		double giaXe; String giaXe_String;
		String imagePath;
		int soLuongKho, soLuongBan; String soLuongKho_String,soLuongBan_String;
		
		
		tenXe = txtTenXe.getText().trim();
		maXe = utilities.GenerateID.taoMaXe(tenXe);
		loaiXe = txtLoaiXe.getText().trim();
		nuocSX =txtNuocSX.getText().trim();
		soPk_String = txtSoPK.getText().trim();
		soPK = Double.parseDouble(soPk_String);
		soKhung = txtSoKhung.getText().trim();
		soSuon = txtSoSuon.getText().trim();
		mauXe = txtMauXe.getText().trim();
		giaXe_String = txtGia.getText().trim();
		giaXe = Double.parseDouble(giaXe_String);
		
		soLuongKho_String = txtSoLuongKho.getText().trim();
		soLuongKho = Integer.parseInt(soLuongKho_String);
		
		NhaCungCap ncc = cboNXS.getValue();
		xe = new Xe(maXe, tenXe, loaiXe, nuocSX, soPK, soKhung, soSuon, mauXe, giaXe, "STRING", ncc, soLuongKho, 0);
		Xe_BUS xe_BUS = new Xe_BUS();
		xe_BUS.addXe(xe);
		listXeObs.add(xe);
		//addXeVaoTable();
		PopupNotify.showErrorField(null, "Thêm thành công!", null);
	}
	
	
	@FXML
	private ComboBox<NhaCungCap> cboNXS;
	
	@FXML
	private TabPane tabXe;

	@FXML
	private TabPane tabLK;
	
	@FXML
	private void clickDSLK() {
		tabXe.setVisible(true);
		tabLK.setVisible(false);
	}
	
	@FXML
	private void clickDSXe() {
		tabLK.setVisible(true);
		tabXe.setVisible(false);
		themDuLieuNCCLK();
	}
	
	
	@FXML
	private void themDuLieuNCC() {
		ArrayList<NhaCungCap> listNCC = ncc_bus.getAllNCC();
		ObservableList<NhaCungCap> obsListNCC = FXCollections.observableArrayList();
		obsListNCC.add(new NhaCungCap(null, "Tất cả"));
		for (NhaCungCap x : listNCC)
			obsListNCC.add(x);
		cboNXS.setValue(obsListNCC.get(0));
		cboNXS.setItems(obsListNCC);
	}
	
	@FXML
	private Xe_BUS xe_BUS = new Xe_BUS();
	@FXML
	private TableColumn<Xe, String> colMaXe,colTenXe,colLoaiXe,colNhaSX,colNuocSX,colMauXe,colSoSuon,colSoKhung;
	@FXML
	private TableColumn<Xe, Double> colSoPK,colGia;
	@FXML
	private TableColumn<Xe, Integer> colSoLuongKho;
	@FXML
	private TableView tblXe;
	
	@FXML
	private void addXeVaoTable() throws Exception {
		xoaTrangDuLieuTable();
		ArrayList<Xe> listXe = xe_BUS.getAllXe();
		
		colMaXe.setCellValueFactory(new PropertyValueFactory<Xe,String>("maXe"));
		colTenXe.setCellValueFactory(new PropertyValueFactory<Xe,String>("tenXe"));
		colLoaiXe.setCellValueFactory(new PropertyValueFactory<Xe,String>("loaiXe"));
		colMauXe.setCellValueFactory(new PropertyValueFactory<Xe,String>("mauXe"));
		colSoPK.setCellValueFactory(new PropertyValueFactory<Xe,Double>("soPK"));
		colGia.setCellValueFactory(new PropertyValueFactory<Xe,Double>("giaXe"));
		colNhaSX.setCellValueFactory(cellData -> {
			return new SimpleStringProperty(ncc_bus.getTenNCCByMa(cellData.getValue().getNcc().getMaNCC()));
		});
		colNuocSX.setCellValueFactory(new PropertyValueFactory<Xe,String>("nuocSX"));
		colSoSuon.setCellValueFactory(new PropertyValueFactory<Xe,String>("soSuon"));
		colSoKhung.setCellValueFactory(new PropertyValueFactory<Xe,String>("soKhung"));
		colSoLuongKho.setCellValueFactory(new PropertyValueFactory<Xe,Integer>("soLuongKho"));
		
		for (Xe x : listXe)
			listXeObs.add(x);
		
		tblXe.setItems(listXeObs);
		
	}
	
	private void xoaTrangDuLieuTable() {
		listXeObs.clear();
	}
	
	
	@FXML
	private void clickTable() {
		Xe xe = (Xe) tblXe.getSelectionModel().getSelectedItem();
		txtTenXe.setText(xe.getTenXe());
		txtLoaiXe.setText(xe.getLoaiXe());
		txtNuocSX.setText(xe.getNuocSX());
		txtMauXe.setText(xe.getMauXe());
		double soPK = xe.getSoPK();
		String soPKK = Double.toString(soPK);
		txtSoPK.setText(soPKK);
		txtSoKhung.setText(xe.getSoKhung());
		cboNXS.setValue(xe.getNcc());
		txtSoSuon.setText(xe.getSoSuon());
		txtGia.setText(Double.toString(xe.getGiaXe()));
		txtSoLuongKho.setText(Integer.toString(xe.getSoLuongKho()));
		
	}
	
	
	
	@FXML
	public void suaXe() throws Exception {
		Xe xe = (Xe) tblXe.getSelectionModel().getSelectedItem();
		if (xe == null )
		{
			PopupNotify.showErrorField("Lỗi !", "Chưa chọn dữ liệu cần sửa!", null);
			return;
		}
		else {
			Xe xeSua;
			String maXe;
			String tenXe;
			String loaiXe;
			String nuocSX;
			double soPK; String soPk_String;
			String soKhung;
			String soSuon;
			String mauXe;
			double giaXe; String giaXe_String;
			String imagePath;
			int soLuongKho, soLuongBan; String soLuongKho_String,soLuongBan_String;
			
			
			tenXe = txtTenXe.getText().trim();
			maXe = utilities.GenerateID.taoMaXe(tenXe);
			loaiXe = txtLoaiXe.getText().trim();
			nuocSX =txtNuocSX.getText().trim();
			soPk_String = txtSoPK.getText().trim();
			soPK = Double.parseDouble(soPk_String);
			soKhung = txtSoKhung.getText().trim();
			soSuon = txtSoSuon.getText().trim();
			mauXe = txtMauXe.getText().trim();
			giaXe_String = txtGia.getText().trim();
			giaXe = Double.parseDouble(giaXe_String);
			
			soLuongKho_String = txtSoLuongKho.getText().trim();
			soLuongKho = Integer.parseInt(soLuongKho_String);
			
			NhaCungCap ncc = cboNXS.getValue();
			xeSua = new Xe(xe.getMaXe(), tenXe, loaiXe, nuocSX, soPK, soKhung, soSuon, mauXe, giaXe, "STIRNG", ncc, soLuongKho, 0);
			if (xe_BUS.editXe(xeSua)) {
				PopupNotify.showErrorField(null, "Đã sửa!", null);
				listXeObs.set( tblXe.getSelectionModel().getSelectedIndex(), xeSua);
			}
			
		}
	}
	
	@FXML
	private TextField txtTimKiemXe;
	@FXML
	private void timKiemTheoMa() throws Exception {
		String ma = txtTimKiemXe.getText();
		xoaTrangTable();
		if (ma.isBlank()) {
			addXeVaoTable();
		}else {
			ArrayList<Xe> listXe = xe_BUS.findXe(ma);
			for (Xe x: listXe)
				listXeObs.add(x);
		}
	}
	
	@FXML
	private void lamMoiTextTimKiem() throws Exception {
		txtTimKiemXe.setText("");
		addXeVaoTable();
	}
	
	private void xoaTrangTable() {
		listXeObs.clear();
	}
	
	@FXML
	private void xoaXe() throws Exception {
		Xe xe = (Xe) tblXe.getSelectionModel().getSelectedItem();
		if (xe == null )
		{
			PopupNotify.showErrorField("Lỗi !", "Chưa chọn dữ liệu cần xóa!", null);
			return;
		}
		else {
			Xe xeXoa;
			String maXe;
			String tenXe;
			String loaiXe;
			String nuocSX;
			double soPK; String soPk_String;
			String soKhung;
			String soSuon;
			String mauXe;
			double giaXe; String giaXe_String;
			String imagePath;
			int soLuongKho, soLuongBan; String soLuongKho_String,soLuongBan_String;
			
			
			tenXe = txtTenXe.getText().trim();
			maXe = utilities.GenerateID.taoMaXe(tenXe);
			loaiXe = txtLoaiXe.getText().trim();
			nuocSX =txtNuocSX.getText().trim();
			soPk_String = txtSoPK.getText().trim();
			soPK = Double.parseDouble(soPk_String);
			soKhung = txtSoKhung.getText().trim();
			soSuon = txtSoSuon.getText().trim();
			mauXe = txtMauXe.getText().trim();
			giaXe_String = txtGia.getText().trim();
			giaXe = Double.parseDouble(giaXe_String);
			
			soLuongKho_String = txtSoLuongKho.getText().trim();
			soLuongKho = Integer.parseInt(soLuongKho_String);
			
			NhaCungCap ncc = cboNXS.getValue();
			xeXoa = new Xe(xe.getMaXe(), tenXe, loaiXe, nuocSX, soPK, soKhung, soSuon, mauXe, giaXe, "STIRNG", ncc, soLuongKho, 0);
			if(PopupNotify.confirmNotification("Thông báo xóa", "Bạn có muốn xóa", null)) {
				xe_BUS.deleteXe(xeXoa);
				PopupNotify.showErrorField(null,"Xóa thành công!",null);
				addXeVaoTable();
			}else {
				PopupNotify.showErrorField(null,"Xóa thất bại!",null);
			}
		}
	}
	
	@FXML
	private void xoaTrang() {
		txtTenXe.setText("");
		txtLoaiXe.setText("");
		txtNuocSX.setText("");
		txtMauXe.setText("");
	
	
		txtSoPK.setText("");
		txtSoKhung.setText("");
		cboNXS.getValue();
		txtSoSuon.setText("");
		txtGia.setText("");
		txtSoLuongKho.setText("");
		
	}
	
//	tab Linh Kien
	
	@FXML
	private TextField txtTenLinhKien,txtGiaLinhKien,txtSoLuongKhoLK;
	
	@FXML
	private ComboBox<NhaCungCap> cboNCCLK;
	
	@FXML
	private ObservableList<LinhKien> listXeObsLK = FXCollections.observableArrayList();
	
	@FXML
	private void themDuLieuNCCLK() {
		ArrayList<NhaCungCap> listNCC = ncc_bus.getAllNCC();
		ObservableList<NhaCungCap> obsListNCC = FXCollections.observableArrayList();
		obsListNCC.add(new NhaCungCap(null, "Tất cả"));
		for (NhaCungCap x : listNCC)
			obsListNCC.add(x);
		cboNCCLK.setValue(obsListNCC.get(0));
		cboNCCLK.setItems(obsListNCC);
	}
	
	
	@FXML
	private void themLinhKien() throws Exception {
//		LinhKien linhKien;
//		String maLK;
//		String tenLK;
//		double giaLK; String giaLK_String;
//		String imagePath;
//		int soLuongKhoLK; String soLuongKhoLK_String;
//		
//		
//		tenLK = txtTenLinhKien.getText().trim();
//		maLK = utilities.GenerateID.taoMaLK();
//		giaLK_String = txtGiaLinhKien.getText().trim();
//		giaLK = Double.parseDouble(giaLK_String);
//		
//		soLuongKhoLK_String = txtSoLuongKhoLK.getText().trim();
//		soLuongKhoLK = Integer.parseInt(soLuongKhoLK_String);
//		
//		NhaCungCap ncc = cboNCCLK.getValue();
//		ChiTietSuaChua chiTietSuaChua = new ChiTietSuaChua();
//		
//		linhKien = new LinhKien(maLK, tenLK, "String", ncc, chiTietSuaChua, giaLK, soLuongKhoLK, 0);
//		LinhKien_BUS linhKien_BUS = new LinhKien_BUS();
//		linhKien_BUS.themLinhKien(linhKien);
//		listXeObsLK.add(linhKien);
//		//addXeVaoTable();
//		PopupNotify.showErrorField(null, "Thêm thành công!", null);
	}
	
	
	public Ctrl_MainMenu() {
		super();
		kh_bus = new KhachHang_BUS();
		nv_bus = new NhanVien_BUS();
		listNVObs = FXCollections.observableArrayList(); 
		listKHObs = FXCollections.observableArrayList();

		tabSelected = SelectedTab.MainMenu;
		
		ncc_bus = new NhaCungCap_BUS();
	}
}