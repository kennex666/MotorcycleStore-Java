package bus;

import java.util.ArrayList;

import dao.KhachHang_DAO;
import entity.KhachHang;
import interfaces.IKhachHang;

public class KhachHang_BUS implements IKhachHang{
	KhachHang_DAO kh_dao;
	@Override
	public ArrayList<KhachHang> findCustomers(String keywords) {
		return kh_dao.findCustomers(keywords);
	}
	
	@Override
	public ArrayList<KhachHang> getAllCustomers() {
		return kh_dao.getAllCustomers();
	}
	
	public KhachHang_BUS() {
		kh_dao = new KhachHang_DAO();
	}
	
	@Override
	public int totalCustomers() {
		// TODO Auto-generated method stub
		return kh_dao.totalCustomers();
	}
	
	@Override
	public boolean editCustomer(KhachHang kHTTMoi) {
		return kh_dao.editCustomer(kHTTMoi);
	}

	@Override
	public String toString() {
		return "KhachHang_BUS []";
	}
	
}
