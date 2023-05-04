package application;

import java.time.LocalDate;

import bus.KhachHang_BUS;
import entity.KhachHang;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.Window;
import utilities.*;

public class Ctrl_DienThongTinKH {
	private ToggleGroup radGroup;
	private KhachHang dataKH;
	private ModeEditor trangThai = ModeEditor.THEM;
	private KhachHang_BUS kh_bus;
	private ObservableList<KhachHang> tblModelKH;
	
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
	}
	
	public Ctrl_DienThongTinKH() {
		radGroup = new ToggleGroup();
		kh_bus = new KhachHang_BUS();
		// Tạo giao diện.
		// Tự động
	}
	
	public void loadData(KhachHang temp) {
		dataKH = temp;
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
	
	@FXML
	private void actionBtnCancel() {
		Stage stage = (Stage) (frmThongTinKhachHang.getScene().getWindow());
		stage.close();
		//getKhachHangFromField();
	}
	
	@FXML
	private void actionBtnThemSua() {
		Stage stage = (Stage) (frmThongTinKhachHang.getScene().getWindow());
		KhachHang temp = null;
		temp = getKhachHangFromField();
		if (temp == null)
			return;
		switch (trangThai) {
			case THEM -> {
				if (kh_bus.addCustomer(temp)) {
					PopupNotify.successNotify("Thông tin", "Thêm khách hàng thành công!", "");
					if (tblModelKH != null)
						tblModelKH.add(temp);
					stage.close();
				}else {
					PopupNotify.showErrorField("Lỗi", "Thêm khách hàng thất bại!", "Lỗi do kết nối cơ sở dữ liệu hoặc bất thường dữ liệu");
				}
			}
			case SUA ->{
				if (kh_bus.editCustomer(temp)) {
					PopupNotify.successNotify("Thông tin", "Sửa thông tin khách hàng thành công!", "");

					if (tblModelKH != null)
						tblModelKH.set(tblModelKH.indexOf(temp), temp);
					stage.close();
				}else {
					PopupNotify.showErrorField("Lỗi", "Sửa thông tin khách hàng thất bại!", "Lỗi do kết nối cơ sở dữ liệu hoặc bất thường dữ liệu");
				}
			}
			default -> {
				PopupNotify.showErrorField("Lỗi", "Dữ liệu không mong đợi", "Unexpected value: " + trangThai);
			}
		}

	}
	
	public void setTableModel(ObservableList<KhachHang> temp) {
		tblModelKH = temp;
	}
	
	private KhachHang getKhachHangFromField() {
		KhachHang temp = null;
		String titleNotification = "Dữ liệu không hợp lệ";
		
		String maKH, ten, diaChi, soDT, soCCCD, email;
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
			maKH = dataKH.getMaKhachHang();
		}else {
			maKH = GenerateID.taoIDKhachHang(kh_bus.totalCustomers(), GenerateID.MADAILY_FORTESTING, "KH");
		}

		try {
			temp = new KhachHang(maKH, ten, diaChi, soDT, soCCCD, gioiTinh, dob, email);
		} catch (Exception e) {
			PopupNotify.showErrorField("Lỗi khởi tạo", "Xảy ra lỗi! Xem bên dưới để biết thêm chi tiết.", "Chi tiết lỗi: " + e.getMessage());
			return null;
		}
		return temp;
	}
	
}
