package application;

import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;

import bus.NhaCungCap_BUS;
import bus.Xe_Bus;
import connectDB.ConnectDB;
import dao.NhaCungCap_DAO;
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
import javafx.scene.layout.AnchorPane;
import javafx.util.StringConverter;
import utilities.PopupNotify;

public class Ctrl_MainMenu {
	private NhaCungCap_BUS ncc_bus;
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
		
//		tabProduct.getTabPane().getTabs().remove(tabProduct);
		themDuLieuNCC();
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
		Xe_Bus xe_BUS = new Xe_Bus();
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
	
	private void lamMoiTextFileTimKiem() {
		
	}
	
	private void xoaTrangTable() {
		listXeObs.clear();
	}
	
	public Ctrl_MainMenu() {
		super();
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ncc_bus = new NhaCungCap_BUS();
		
	}
}