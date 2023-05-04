package bus;

import java.util.ArrayList;

import dao.LinhKien_DAO;
import entity.LinhKien;
import interfaces.ILinhKien;

public class LinhKien_BUS implements ILinhKien{
	private LinhKien_DAO linhKien_DAO;

	public LinhKien_BUS() {
		super();
		linhKien_DAO = new LinhKien_DAO();
	}
	
	public ArrayList<LinhKien> getAllLinhKien() throws Exception {
		return linhKien_DAO.getAllLinhKien();
	}
	
	public void updateSLKho(int newSL, String maXe) {
		linhKien_DAO.updateSoLuongKho(newSL, maXe);
	}
	
	public void updateSLBan(int newSL, String maXe) {
		linhKien_DAO.updateSoLuongBan(newSL, maXe);
	}
	
	public String getTenByMa(String maXe) {
		return linhKien_DAO.getTenByMa(maXe);
	}

	@Override
	public void updateSoLuongKho(int newSL, String maLK) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateSoLuongBan(int newSL, String maLK) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean themLinhKien(LinhKien lk) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean xoaLinhKien(LinhKien lk) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean editLinhKien(LinhKien lk) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<LinhKien> findLinhKien(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}
}
