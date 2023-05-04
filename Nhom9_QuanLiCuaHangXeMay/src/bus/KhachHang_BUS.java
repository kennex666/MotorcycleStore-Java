package bus;

import java.util.ArrayList;

import dao.KhachHang_DAO;
import entity.KhachHang;
import interfaces.IKhachHang;

public class KhachHang_BUS implements IKhachHang{
	KhachHang_DAO kh_dao;
	
	
	public KhachHang_BUS() {
		super();
		kh_dao = new KhachHang_DAO();
	}
	
	@Override
	public boolean editCustomer(KhachHang kHTTMoi) {
		// TODO Auto-generated method stub
		return kh_dao.editCustomer(kHTTMoi);
	}

	@Override
	public boolean addCustomer(KhachHang kHTTMoi) {
		return kh_dao.addCustomer(kHTTMoi);
	}
	
	@Override
	public boolean deleteCustomer(KhachHang kh) {
		return kh_dao.deleteCustomer(kh);
	}


	public ArrayList<KhachHang> getAllKhachHang() throws Exception {
		return kh_dao.getAllKhachHang();
	}
	
	public String getHoTenByMa(String maKH) {
		return kh_dao.getHoTenByMa(maKH);
	}
	
	public int totalCustomers() {
		return kh_dao.totalCustomers();
	}
	
	public ArrayList<KhachHang> getAllCustomers() {
		return kh_dao.getAllCustomers();
	}
	
	public ArrayList<KhachHang> findCustomers(String keywords) {
		return kh_dao.findCustomers(keywords);
	}
}
