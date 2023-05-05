package application;

import java.time.LocalDate;
import java.util.ArrayList;

import bus.KhachHang_BUS;
import entity.KhachHang;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.Window;
import utilities.*;

public class Ctrl_TimKHNangCao {
	private KhachHang dataKH;
	private KhachHang_BUS kh_bus;
	private ObservableList<KhachHang> tblModelKH;
	
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
	
	private ObservableList<String> thangList;
	
	@FXML
	private void initialize() { // Khi khởi tạo toàn bộ thì sẽ thực hiện
		chkNam.setSelected(true);
		chkNu.setSelected(true);
		cboThang.setItems(thangList);
		cboThang.setValue(thangList.get(0));
	}
	
	public Ctrl_TimKHNangCao() {
		kh_bus = new KhachHang_BUS();
		thangList = FXCollections.observableArrayList();
		String[] thang = {"Toàn bộ", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}; 
		thangList.setAll(thang);
	}
	
	@FXML
	private void actionBtnTim() {
		// TODO Auto-generated method stub
		
		String ten = "";
		boolean isNam = chkNam.isSelected();
		boolean isNu = chkNu.isSelected();
		int tuTuoi = 0, denTuoi = 0, thangSinh = 0;
		try {
			ten = txtHoTen.getText();
			if (!txtTuTuoi.getText().trim().equals(""))
				tuTuoi = Integer.parseInt(txtTuTuoi.getText());
			if (!txtDenTuoi.getText().trim().equals(""))
				denTuoi = Integer.parseInt(txtDenTuoi.getText());
			if (!cboThang.getValue().equalsIgnoreCase("Toàn bộ") && cboThang.getValue() != null) {
				thangSinh = Integer.parseInt(cboThang.getValue());
			}
		}catch (Exception e) {
			PopupNotify.showErrorField("Lỗi", "Dữ liệu không hợp lệ!", "Hãy kiểm tra lại");
		}
		Object[] obj = {ten, isNam, isNu, tuTuoi, denTuoi, thangSinh};
		ArrayList<KhachHang> listKH = kh_bus.findCustomersAdvanced(obj);
		tblModelKH.clear();
		for (KhachHang x : listKH)
			tblModelKH.add(x);
	}
	
	@FXML
	private void actionBtnCancel() {
		Stage stage = (Stage) (frmThongTinKhachHang.getScene().getWindow());
		stage.close();
		//getKhachHangFromField();
	}
	
	public void setTableModel(ObservableList<KhachHang> temp) {
		tblModelKH = temp;
	}
	
}
