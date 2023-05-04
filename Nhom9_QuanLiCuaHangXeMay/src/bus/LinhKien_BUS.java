package bus;

import java.util.ArrayList;

import dao.LinhKien_DAO;
import entity.LinhKien;

public class LinhKien_BUS {
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
}
