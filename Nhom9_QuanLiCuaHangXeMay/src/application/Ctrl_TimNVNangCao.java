package application;

import java.time.LocalDate;
import java.util.ArrayList;

import bus.ChucVu_BUS;
import bus.KhachHang_BUS;
import bus.NhanVien_BUS;
import bus.PhongBan_BUS;
import entity.ChucVu;
import entity.KhachHang;
import entity.NhanVien;
import entity.PhongBan;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.Window;
import utilities.*;

public class Ctrl_TimNVNangCao {
	private NhanVien_BUS nv_bus;
	private PhongBan_BUS pb_bus;
	private ChucVu_BUS cv_bus;
	private ObservableList<NhanVien> tblModelNV;
	private ObservableList<ChucVu> cboModelCV;
	private ObservableList<PhongBan> cboModelPB;
	
	@FXML
	private Pane frmThongTinKhachHang;
	
	@FXML
	private CheckBox chkNam, chkNu;
	
	@FXML 
	private TextField txtHoTen, txtTuTuoi, txtDenTuoi;
	
	@FXML
	private Button btnThemSua, btnHuy;
	
	@FXML
	private ComboBox<String> cboThang;
	@FXML
	private ComboBox<PhongBan> cboPhongBan;
	@FXML
	private ComboBox<ChucVu> cboChucVu;
	
	private ObservableList<String> thangList;
	
	@FXML
	private void initialize() { // Khi khởi tạo toàn bộ thì sẽ thực hiện
		chkNam.setSelected(true);
		chkNu.setSelected(true);
		cboThang.setItems(thangList);
		cboThang.setValue(thangList.get(0));
		cboChucVu.setItems(cboModelCV);
		cboChucVu.setValue(cboModelCV.get(0));
		cboPhongBan.setItems(cboModelPB);
		cboPhongBan.setValue(cboModelPB.get(0));
	}
	
	public Ctrl_TimNVNangCao() {
		nv_bus = new NhanVien_BUS();
		pb_bus = new PhongBan_BUS();
		cv_bus = new ChucVu_BUS();
		thangList = FXCollections.observableArrayList();
		cboModelCV = FXCollections.observableArrayList();
		cboModelPB = FXCollections.observableArrayList();
		String[] thang = {"Toàn bộ", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}; 
		thangList.setAll(thang);
		ArrayList<PhongBan> listPb = pb_bus.getAllPhongBan();
		ArrayList<ChucVu> listCv = cv_bus.getAllChucVu();
		try {
			cboModelPB.add(new PhongBan(0, "Toàn bộ"));
			cboModelCV.add(new ChucVu(0, "Toàn bộ"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (PhongBan x : listPb)
			cboModelPB.add(x);
		for (ChucVu x : listCv)
			cboModelCV.add(x);
			
	}
	
	@FXML
	private void actionBtnTim() {
		// TODO Auto-generated method stub
		
		String ten = "";
		boolean isNam = chkNam.isSelected();
		boolean isNu = chkNu.isSelected();
		int tuTuoi = 0, denTuoi = 0, thangSinh = 0, maChucVu = 0, maPhongBan = 0;
		try {
			ten = txtHoTen.getText();
			if (!txtTuTuoi.getText().trim().equals(""))
				tuTuoi = Integer.parseInt(txtTuTuoi.getText());
			if (!txtDenTuoi.getText().trim().equals(""))
				denTuoi = Integer.parseInt(txtDenTuoi.getText());
			if (!cboThang.getValue().equalsIgnoreCase("Toàn bộ") && cboThang.getValue() != null) {
				thangSinh = Integer.parseInt(cboThang.getValue());
			}
			if (cboChucVu.getValue().getMaChucVu() != 0 && cboChucVu.getValue() != null) {
				maChucVu = cboChucVu.getValue().getMaChucVu();
			}
			if (cboPhongBan.getValue().getId() != 0 && cboPhongBan.getValue() != null) {
				maPhongBan = cboPhongBan.getValue().getId();
			}
		}catch (Exception e) {
			PopupNotify.showErrorField("Lỗi", "Dữ liệu không hợp lệ!", "Hãy kiểm tra lại");
		}
		Object[] obj = {ten, isNam, isNu, tuTuoi, denTuoi, thangSinh, maPhongBan, maChucVu};
		ArrayList<NhanVien> listNV = nv_bus.findEmployeeAdvanced(obj);
		tblModelNV.clear();
		for (NhanVien x : listNV)
			tblModelNV.add(x);
	}
	
	@FXML
	private void actionBtnCancel() {
		Stage stage = (Stage) (frmThongTinKhachHang.getScene().getWindow());
		stage.close();
		//getKhachHangFromField();
	}
	
	public void setTableModel(ObservableList<NhanVien> temp) {
		tblModelNV = temp;
	}
	
}
