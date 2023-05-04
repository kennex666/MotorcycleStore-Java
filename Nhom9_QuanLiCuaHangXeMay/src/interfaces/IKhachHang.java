package interfaces;

import java.util.ArrayList;

import entity.KhachHang;

public interface IKhachHang {

	public ArrayList<KhachHang> findCustomers(String keywords);
	public ArrayList<KhachHang> getAllKhachHang() throws Exception;
	String getHoTenByMa(String maKH);
	public boolean addCustomer(KhachHang kh);
	public int totalCustomers();
	ArrayList<KhachHang> getAllCustomers();
}
