package bus;

import java.util.ArrayList;

import dao.Xe_DAO;
import entity.Xe;

public class Xe_BUS {
	private Xe_DAO xe_DAO;

	public Xe_BUS() {
		super();
		xe_DAO = new Xe_DAO();
	}
	
	public ArrayList<Xe> getAllXe() throws Exception {
		return xe_DAO.getAllXe();
	}
	
	public void updateSLKho(int newSL, String maXe) {
		xe_DAO.updateSoLuongKho(newSL, maXe);
	}
	
	public void updateSLBan(int newSL, String maXe) {
		xe_DAO.updateSoLuongBan(newSL, maXe);
	}
	
	public String getTenByMa(String maXe) {
		return xe_DAO.getTenByMa(maXe);
	}
}
