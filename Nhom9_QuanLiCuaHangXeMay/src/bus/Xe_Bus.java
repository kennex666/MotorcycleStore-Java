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

}
