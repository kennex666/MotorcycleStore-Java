package interfaces;

import java.util.ArrayList;

import entity.KhachHang;

public interface IKhachHang {
	public ArrayList<KhachHang> getAllCustomers();
	
	/*
	 * Tham số keywords: Có thể là số điện thoại, tên khách hàng, mã khách hàng.
	 */
	public ArrayList<KhachHang> findCustomers(String keywords);
	
	public int totalCustomers();
	
	public boolean editCustomer(KhachHang kHTTMoi);
	
	public boolean addCustomer(KhachHang kh);
	
	public boolean deleteCustomer(KhachHang kh);
	
}
