package bus;

import java.util.ArrayList;

import dao.Xe_DAO;
import entity.Xe;
import interfaces.IXe;

public class Xe_BUS implements IXe {
	private Xe_DAO xe_DAO;


	public Xe_BUS() {
		super();
		xe_DAO = new Xe_DAO();
	}
	
	public ArrayList<Xe> getAllXe() throws Exception {
		return xe_DAO.getAllXe();
	}
	
	public void updateSoLuongKho(int newSL, String maXe) {
		xe_DAO.updateSoLuongKho(newSL, maXe);
	}
	
	public void updateSoLuongBan(int newSL, String maXe) {
		xe_DAO.updateSoLuongBan(newSL, maXe);
	}
	
	public String getTenByMa(String maXe) {
		return xe_DAO.getTenByMa(maXe);
	}

	@Override
	public ArrayList<Xe> findXe(String keywords) {
		Xe_DAO xe_dao = new Xe_DAO();
		return xe_dao.findXe(keywords);
	}

	@Override
	public boolean editXe(Xe xeCanSua) {
		Xe_DAO xe_DAO = new Xe_DAO();
		return xe_DAO.editXe(xeCanSua);
	}

	@Override
	public int totalXe() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean addXe(Xe xe) {
		Xe_DAO xe_DAO = new Xe_DAO();
		return xe_DAO.addXe(xe);
	}

	@Override
	public boolean deleteXe(Xe xe) {
		Xe_DAO xe_DAO = new Xe_DAO();
		return xe_DAO.deleteXe(xe);
	}
}
