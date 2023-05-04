package application;

import java.time.LocalDate;
import java.util.ArrayList;

import bus.ChucVu_BUS;
import bus.NhanVien_BUS;
import bus.PhongBan_BUS;
import entity.ChucVu;
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

public class Ctrl_DienThongTinNV {
	private ToggleGroup radGroup;
	private NhanVien dataNV;
	private ModeEditor trangThai = ModeEditor.THEM;
	private NhanVien_BUS nv_bus;
	private ObservableList<NhanVien> tblModelNV;
	private ObservableList<ChucVu> obsListCV;
	private ObservableList<PhongBan> obsListPB;
	private ObservableList<String> obsListBT, obsListTD;
	private PhongBan_BUS pb_bus;
	private ChucVu_BUS cv_bus;
	
	@FXML
	private ComboBox<PhongBan> cboPhongBan;
	@FXML
	private ComboBox<ChucVu> cboChucVu;
	@FXML
	private ComboBox<String> cboTrinhDo, cboBacTho;
	
	
	@FXML
	private Pane frmThongTinNhanVien;
	
	@FXML
	private RadioButton radNam, radNu;
	
	@FXML 
	private TextField txtHoTen, txtCCCD, txtSDT, txtEmail, txtDiaChi; 
	
	@FXML
	private Button btnThemSua, btnHuy;
	
	@FXML 
	private DatePicker txtDOB;
	
	

	@FXML
	private void initialize() { // Khi khởi tạo toàn bộ thì sẽ thực hiện
		radNam.setToggleGroup(radGroup);
		radNu.setToggleGroup(radGroup);
		radNam.setSelected(true);

		cboChucVu.setItems(obsListCV);
		cboPhongBan.setItems(obsListPB);
		cboTrinhDo.setItems(obsListTD);
		
		cboBacTho.setItems(obsListBT);
		cboChucVu.setItems(obsListCV);
		cboPhongBan.setItems(obsListPB);
		cboTrinhDo.setItems(obsListTD);
		
		ArrayList<ChucVu> listCV = cv_bus.getAllChucVu();
		ArrayList<PhongBan> listPhongBan  = pb_bus.getAllPhongBan();
		for (PhongBan x : listPhongBan)
			obsListPB.add(x);
		for (ChucVu x : listCV)
			obsListCV.add(x);
		obsListBT.setAll(DataDefault.BACTHO);
		obsListTD.setAll(DataDefault.TRINHDO_HOCVAN);
		
		
		cboChucVu.setValue(obsListCV.get(0));
		cboBacTho.setValue(obsListBT.get(0));
		cboPhongBan.setValue(obsListPB.get(0));
		cboTrinhDo.setValue(obsListTD.get(0));
		
	}
	
	public Ctrl_DienThongTinNV() {
		radGroup = new ToggleGroup();
		pb_bus = new PhongBan_BUS();
		nv_bus = new NhanVien_BUS();
		cv_bus = new ChucVu_BUS();
		obsListBT = FXCollections.observableArrayList();
		obsListCV = FXCollections.observableArrayList();
		obsListPB = FXCollections.observableArrayList();
		obsListTD = FXCollections.observableArrayList();
		
		// Tạo giao diện.
		// Tự động
	}
	
	public void loadData(NhanVien temp) {
		dataNV = temp;
		if (dataNV != null) {
			trangThai = ModeEditor.SUA;
			radNam.setSelected(dataNV.isGioiTinh() ^ GioiTinh.NU);
			radNu.setSelected(dataNV.isGioiTinh() ^ GioiTinh.NAM);
			txtHoTen.setText(dataNV.getTenNhanVien());
			txtCCCD.setText(dataNV.getSoCCCD());
			txtSDT.setText(dataNV.getSoDT());
			txtEmail.setText(dataNV.getEmail());
			txtDiaChi.setText(dataNV.getDiaChi());
			txtDOB.setValue(dataNV.getNgaySinh());
			btnThemSua.setText("Sửa");
			cboChucVu.setValue(dataNV.getChucVu());
			cboBacTho.setValue(dataNV.getBacTho());
			cboPhongBan.setValue(dataNV.getPhongBan());
			cboTrinhDo.setValue(dataNV.getTrinhDo());
		}
	}
	@FXML
	private void selectedCboChucVu() {
		if (cboChucVu.getValue().getMaChucVu() == DataDefault.NV_THOKITHUAT) {
			cboBacTho.setDisable(false);
		}else {
			cboBacTho.setDisable(true);
		}
		return;

	}
	
	@FXML
	private void actionBtnCancel() {
		Stage stage = (Stage) (frmThongTinNhanVien.getScene().getWindow());
		stage.close();
		//getNhanVienFromField();
	}
	
	@FXML
	private void actionBtnThemSua() {
		Stage stage = (Stage) (frmThongTinNhanVien.getScene().getWindow());
		NhanVien temp = null;
		temp = getNhanVienFromField();
		if (temp == null)
			return;
		switch (trangThai) {
			case THEM -> {
				if (nv_bus.addEmployee(temp)) {
					PopupNotify.successNotify("Thông tin", "Thêm nhân viên thành công!", "");
					if (tblModelNV != null)
						tblModelNV.add(temp);
					stage.close();
				}else {
					PopupNotify.showErrorField("Lỗi", "Thêm nhân viên thất bại!", "Lỗi do kết nối cơ sở dữ liệu hoặc bất thường dữ liệu");
				}
			}
			case SUA ->{
				if (nv_bus.editEmployee(temp)) {
					PopupNotify.successNotify("Thông tin", "Sửa thông tin nhân viên thành công!", "");

					if (tblModelNV != null)
						tblModelNV.set(tblModelNV.indexOf(temp), temp);
					stage.close();
				}else {
					PopupNotify.showErrorField("Lỗi", "Sửa thông tin nhân viên thất bại!", "Lỗi do kết nối cơ sở dữ liệu hoặc bất thường dữ liệu");
				}
			}
			default -> {
				PopupNotify.showErrorField("Lỗi", "Dữ liệu không mong đợi", "Unexpected value: " + trangThai);
			}
		}

	}
	
	public void setTableModel(ObservableList<NhanVien> temp) {
		tblModelNV = temp;
	}
	
	private NhanVien getNhanVienFromField() {
		NhanVien temp = null;
		String titleNotification = "Dữ liệu không hợp lệ";
		
		String maNV, ten, diaChi, soDT, soCCCD, email;
		boolean gioiTinh;
		LocalDate dob, now = LocalDate.now();
		
		ten = txtHoTen.getText();
		diaChi = txtDiaChi.getText();
		soDT = txtSDT.getText();
		soCCCD = txtCCCD.getText();
		email = txtEmail.getText().toLowerCase();
		dob = txtDOB.getValue();
		gioiTinh = radNam.isSelected();
		
		if (!PopupNotify.regexValidNotification(ten, RegexPattern.HOTEN, titleNotification, "Tên không rỗng, phải là chữ, viết hoa đầu từ và không chứa kí tự đặc biệt!", "Có thể cách nhau bằng dấu cách như: Nguyễn Văn A, ...")) {
			txtHoTen.requestFocus();
			return null;
		}
		
		PhongBan phongBan = cboPhongBan.getValue();
		ChucVu chucVu = cboChucVu.getValue();
		String bacTho = "";
		if (cboChucVu.getValue().getMaChucVu() == DataDefault.NV_THOKITHUAT)
			bacTho = cboBacTho.getValue();
		String trinhDo = cboTrinhDo.getValue();

		
		if (!ProcessDate.greaterThanEquals(dob, 18)){
			PopupNotify.showErrorField(titleNotification, "Nhân viên phải từ đủ 18 tuổi trở lên mới có thể làm việc!", "Vui lòng kiểm tra lại.");
			txtDOB.requestFocus();
			return null;
		}
		
		if (!PopupNotify.regexValidNotification(soCCCD, RegexPattern.getRegexCCCD(dob, gioiTinh), titleNotification, "Số chứng minh nhân dân hoặc căn cước công dân không hợp lệ!", "Kiểm tra lại: Năm sinh, giới tính và số CCCD đối với CCCD hoặc 8 chữ số với CMND")) {
			txtCCCD.requestFocus();
			return null;
		}
		
		if (!PopupNotify.regexValidNotification(soDT, RegexPattern.SDTVN, titleNotification, "Số điện thoại không hợp lệ!", "Phải bắt đầu từ số 0 theo sau là 9 kí số.")) {
			txtSDT.requestFocus();
			return null;
		}
		
		if (!PopupNotify.regexValidNotification(email, RegexPattern.EMAIL, titleNotification, "Email không hợp lệ!", "Vui lòng kiểm tra lại.")) {
			txtEmail.requestFocus();
			return null;
		}
		
		if (diaChi.isBlank()){
			PopupNotify.showErrorField(titleNotification, "Địa chỉ không được để trống", "Vui lòng kiểm tra lại!");
			txtDiaChi.requestFocus();
			return null;
		}
		
		
		
		if (ModeEditor.SUA == trangThai) {
			maNV = dataNV.getMaNhanVien();
		}else {
			maNV = GenerateID.taoIDNhanVien(nv_bus.totalEmployees(), GenerateID.MADAILY_FORTESTING, chucVu.getMaChucVu());
		}

		try {
			temp = new NhanVien(maNV, ten, diaChi, soDT, soCCCD, gioiTinh, dob, email, trinhDo, bacTho, chucVu, phongBan);
		} catch (Exception e) {
			PopupNotify.showErrorField("Lỗi khởi tạo", "Xảy ra lỗi! Xem bên dưới để biết thêm chi tiết.", "Chi tiết lỗi: " + e.getMessage());
			return null;
		}
		return temp;
	}
	
}
