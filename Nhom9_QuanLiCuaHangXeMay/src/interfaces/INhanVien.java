package interfaces;

import java.util.ArrayList;

import entity.NhanVien;

public interface INhanVien {
	public ArrayList<NhanVien> getAllEmployees();
	
	/*
	 * Tham số keywords: Có thể là số điện thoại, tên khách hàng, mã khách hàng.
	 */
	public ArrayList<NhanVien> findEmployee(String keywords);
	
	public int totalEmployees();
	
	public boolean editEmployee(NhanVien nv);
	
	public boolean addEmployee(NhanVien nv);
	
	public boolean deleteEmployee(NhanVien nv);
	
	String getTenByMaNV(String maNV);
	
}
