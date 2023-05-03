package bus;

import java.util.ArrayList;

import dao.Xe_DAO;
import entity.Xe;
import interfaces.iXe;

public class Xe_Bus implements iXe{

	@Override
	public ArrayList<Xe> getAllList() {
		Xe_DAO xe_dao = new Xe_DAO();
		return xe_dao.getAllList();
	}

	@Override
	public ArrayList<Xe> findXe(String keywords) {
		Xe_DAO xe_dao = new Xe_DAO();
		return xe_dao.findXe(keywords);
	}

	@Override
	public boolean editXe(Xe xeCanSua) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int totalXe() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public boolean addXe(Xe xe) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public boolean deleteXe(Xe xe) {
		// TODO Auto-generated method stub
		return false;
	}
	

}
