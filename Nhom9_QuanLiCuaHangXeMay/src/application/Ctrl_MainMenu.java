package application;

import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;

import bus.NhaCungCap_BUS;
import bus.Xe_Bus;
import connectDB.ConnectDB;
import entity.KhachHang;
import entity.NhaCungCap;
import entity.Xe;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.TableView.TableViewSelectionModel;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.StringConverter;
import utilities.PopupNotify;

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
	private void initialize() throws SQLException {
		
		try {
			ConnectDB.getInstance().connect();
			System.out.println("Connect");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		tabProduct.getTabPane().getTabs().remove(tabProduct);
		themDuLieuNCC();
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
	private TextField txtTenXe,txtLoaiXe,txtSoKhung,txtSoSuon,txtSoPK,txtMauXe,txtNhaSX,txtGia,txtSoLuongKho,txtNuocSX;
	
	@FXML
	private Button btnThemXe,btnXoaTrangXe,btnSuaXe,btnXoaXe;
	
//	@FXML
//	private TableView<Xe> tblXe;
	
	private NhaCungCap_BUS ncc_BUS;
	
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
		xe = new Xe(maXe, tenXe, loaiXe, nuocSX, soPK, soKhung, soSuon, mauXe, giaXe, "STIRNG", ncc, soLuongKho, 0);
		Xe_Bus xe_BUS = new Xe_Bus();
		xe_BUS.addXe(xe);
	}
	
	@FXML
	private ComboBox< NhaCungCap> cboNXS;
	
	
	@FXML
	private void themDuLieuNCC() {
		ncc_BUS = new NhaCungCap_BUS();
		ArrayList<NhaCungCap> listNCC = ncc_BUS.getAllNCC();
		cboNXS.getItems().add(new NhaCungCap(null, "Tất cả"));
		cboNXS.getItems().addAll(listNCC);
		cboNXS.setConverter(new StringConverter<NhaCungCap>() {
			
			@Override
			public String toString(NhaCungCap nhaCungCap) {
				return nhaCungCap == null ? null : nhaCungCap.getTenNCC();
			}
			
			@Override
			public NhaCungCap fromString(String arg0) {
				// TODO Auto-generated method stub
				return null;
			}
		});
		cboNXS.setValue(listNCC.get(0));
	}
	
	@FXML
	private void xoaXe() {
		
	}
	@FXML
	private Xe_Bus xe_BUS = new Xe_Bus();
	@FXML
	private TableColumn<Xe, String> colMaXe,colTenXe,colLoaiXe,colNhaSX,colNuocSX,colMauXe,colSoSuon,colSoKhung;
	@FXML
	private TableColumn<Xe, Double> colSoPK,colGia;
	@FXML
	private TableColumn<Xe, Integer> colSoLuongKho;
	@FXML
	private TableView<Xe> tblXe;
	
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
			return new SimpleStringProperty(ncc_BUS.getTenNCCByMa(cellData.getValue().getNcc().getMaNCC()));
		});
		colNuocSX.setCellValueFactory(new PropertyValueFactory<Xe,String>("nuocSX"));
		colSoSuon.setCellValueFactory(new PropertyValueFactory<Xe,String>("soSuon"));
		colSoKhung.setCellValueFactory(new PropertyValueFactory<Xe,String>("soKhung"));
		colSoLuongKho.setCellValueFactory(new PropertyValueFactory<Xe,Integer>("soLuongKho"));
		
		tblXe.getItems().addAll(listXe);
		System.out.println("LOAD DUOC");
	}
	
	private void xoaTrangDuLieuTable() {
		tblXe.getItems().clear();
	}
	
//	private void removeAllRowsKH() {
//		
//	}
//	
//	@FXML
//	private void actionRefreshTableKH() {
//		// TODO Auto-generated method stub
//		removeAllRowsKH();
////		loadDataKHToTable();
////		txtSearch.setText("");
//		
//	}
	
	@FXML
	private void clickTable() {
		Xe xe = tblXe.getSelectionModel().getSelectedItem();
		txtTenXe.setText(xe.getTenXe());
		txtLoaiXe.setText(xe.getLoaiXe());
		txtNuocSX.setText(xe.getNuocSX());
		txtMauXe.setText(xe.getMauXe());
		double soPK = xe.getSoPK();
		String soPKK = Double.toString(soPK);
		txtSoPK.setText(soPKK);
		txtSoKhung.setText(xe.getSoKhung());
		ObservableList<NhaCungCap> nccList = FXCollections.observableArrayList(xe.getNcc());
		cboNXS.setItems(nccList);
		txtSoSuon.setText(xe.getSoSuon());
		txtGia.setText(Double.toString(xe.getGiaXe()));
		txtSoLuongKho.setText(Integer.toString(xe.getSoLuongKho()));
		System.out.println("Thanh Cong");
	}
	
	
	
	@FXML
	public void suaXe() throws Exception {
		Xe xe = tblXe.getSelectionModel().getSelectedItem();
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
			xeSua = new Xe(maXe, tenXe, loaiXe, nuocSX, soPK, soKhung, soSuon, mauXe, giaXe, "STIRNG", ncc, soLuongKho, 0);
			xe_BUS.editXe(xeSua);
			PopupNotify.showErrorField("", "Đã sửa!", null);
		}
	}
	
	public Ctrl_MainMenu() {
		super();
	}
}