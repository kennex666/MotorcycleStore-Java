package bus;

import java.util.ArrayList;

import dao.KhachHang_DAO;
import entity.KhachHang;

public class KhachHang_BUS {
	KhachHang_DAO kh_DAO;
	
	
	public KhachHang_BUS() {
		super();
		kh_DAO = new KhachHang_DAO();
	}


	public ArrayList<KhachHang> getAllKhachHang() throws Exception {
		return kh_DAO.getAllKhachHang();
	}
	
	public String getTenByMaKH(String maKH) {
		return kh_DAO.getHoTenByMa(maKH);
	}


	public boolean addCustomer(KhachHang temp) {
		return kh_DAO.addCustomer(temp);
	}
	
	public int totalCustomers() {
		return kh_DAO.totalCustomers();
	}
	
	public ArrayList<KhachHang> getAllCustomers() {
		return kh_DAO.getAllCustomers();
	}
	
	public ArrayList<KhachHang> findCustomers(String keywords) {
		return kh_DAO.findCustomers(keywords);
	}
}
