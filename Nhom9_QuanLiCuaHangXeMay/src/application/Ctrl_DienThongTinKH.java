package application;

import java.time.LocalDate;

import bus.KhachHang_BUS;
import entity.KhachHang;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import utilities.*;

public class Ctrl_DienThongTinKH {
	private ToggleGroup radGroup;
	private KhachHang dataKH;
	private ModeEditor trangThai = ModeEditor.THEM;
	private KhachHang_BUS kh_bus;
	
	@FXML
	private Pane frmThongTinKhachHang;
	
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
		if (dataKH != null) {
			trangThai = ModeEditor.SUA;
			radNam.setSelected(dataKH.isGioiTinh() ^ GioiTinh.NU);
			radNu.setSelected(dataKH.isGioiTinh() ^ GioiTinh.NAM);
			txtHoTen.setText(dataKH.getTenKhachHang());
			txtCCCD.setText(dataKH.getSoCCCD());
			txtSDT.setText(dataKH.getSoDT());
			txtEmail.setText(dataKH.getEmail());
			txtDiaChi.setText(dataKH.getDiaChi());
			txtDOB.setValue(dataKH.getNgaySinh());
			btnThemSua.setText("Sửa");
		}
	}
	
	public Ctrl_DienThongTinKH() {
		radGroup = new ToggleGroup();
		KhachHang temp;
		LocalDate date = LocalDate.now();
		try {
			temp = new KhachHang("11111", "Dương Thái Bảo", "Ấp 4, Bình Phước", "0869953285", "020202020", true, date, "bao1boxstudios");
			loadData(temp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Tạo giao diện.
		// Tự động
	}
	
	public void loadData(KhachHang temp) {
		dataKH = temp;
	}
	
	@FXML
	private void actionBtnCancel() {
		//Stage stage = (Stage) (frmThongTinKhachHang.getScene().getWindow());
		//stage.close();
		getKhachHangFromField();
	}
	
	@FXML
	private void actionBtnThemSua() {
		kh_bus = new KhachHang_BUS();
		switch (trangThai) {
			case THEM -> {
				
			}
			case SUA ->{
				kh_bus.editCustomer(dataKH);
			}
			default -> {
				throw new IllegalArgumentException("Unexpected value: " + trangThai);
			}
		}

	}
	
	
	private KhachHang getKhachHangFromField() {
		KhachHang temp = null;
		String titleNotification = "Dữ liệu không hợp lệ";
		
		String ten, diaChi, soDT, soCCCD, email;
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

		
		if (!ProcessDate.greaterThanEquals(dob, 18)){
			PopupNotify.showErrorField(titleNotification, "Khách hàng phải từ đủ 18 tuổi trở lên mới có thể đăng kí/mua/bán xe!", "Vui lòng kiểm tra lại.");
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
		
		if (!PopupNotify.regexValidNotification(soDT, RegexPattern.EMAIL, titleNotification, "Email không hợp lệ!", "Vui lòng kiểm tra lại.")) {
			txtEmail.requestFocus();
			return null;
		}
		
		if (diaChi.isBlank()){
			PopupNotify.showErrorField(titleNotification, "Địa chỉ không được để trống", "Vui lòng kiểm tra lại!");
			txtDiaChi.requestFocus();
			return null;
		}

		try {
			
			temp = new KhachHang("11111", "Dương Thái Bảo", "Ấp 4, Bình Phước", "0869953285", "020202020", true, txtDOB.getValue(), "bao1boxstudios");
		} catch (Exception e) {
			
		}
		return temp;
	}
	
}
