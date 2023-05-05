package bus;

import java.util.ArrayList;

import dao.NhanVien_DAO;
import entity.NhanVien;
import interfaces.INhanVien;

public class NhanVien_BUS implements INhanVien{
	NhanVien_DAO nv_dao;
	
	@Override
	public ArrayList<NhanVien> findEmployeeAdvanced(Object[] obj) {
		return nv_dao.findEmployeeAdvanced(obj);
	}
	
	@Override
	public ArrayList<NhanVien> getAllEmployees() {
		return nv_dao.getAllEmployees();
	}

	@Override
	public ArrayList<NhanVien> findEmployee(String keywords) {
		return nv_dao.findEmployee(keywords);
	}
	
	public NhanVien_BUS() {
		nv_dao = new NhanVien_DAO();
	}
	
	@Override
	public int totalEmployees() {
		// TODO Auto-generated method stub
		return nv_dao.totalEmployees();
	}
	
	@Override
	public boolean editEmployee(NhanVien nv) {
		return nv_dao.editEmployee(nv);
	}
	
	@Override
	public boolean addEmployee(NhanVien nv) {
		return nv_dao.addEmployee(nv);
	}
	
	@Override
	public boolean deleteEmployee(NhanVien nv) {
		return nv_dao.deleteEmployee(nv);
	}

	public String getTenByMaNV(String maNV) {
		return nv_dao.getTenByMaNV(maNV);
	}

	@Override
	public String toString() {
		return "NhanVien_BUS []";
	}
	
}
