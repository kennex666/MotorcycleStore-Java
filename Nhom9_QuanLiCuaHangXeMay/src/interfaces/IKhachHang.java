package interfaces;

import java.util.ArrayList;

import entity.KhachHang;

public interface IKhachHang {

	public ArrayList<KhachHang> findCustomers(String keywords);
	public ArrayList<KhachHang> getAllKhachHang() throws Exception;
	String getHoTenByMa(String maKH);
	public int totalCustomers();
	public boolean editCustomer(KhachHang kHTTMoi);
	public boolean addCustomer(KhachHang kh);
	public boolean deleteCustomer(KhachHang kh);
	public ArrayList<KhachHang> getAllCustomers();
	public ArrayList<KhachHang> findCustomersAdvanced(Object[] obj);
	
	
}
