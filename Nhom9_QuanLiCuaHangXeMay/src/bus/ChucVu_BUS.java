package bus;

import java.util.ArrayList;

import dao.ChucVu_DAO;
import entity.ChucVu;

public class ChucVu_BUS {
	ChucVu_DAO cv_DAO;

	public ChucVu_BUS() {
		super();
		// TODO Auto-generated constructor stub
		cv_DAO = new ChucVu_DAO();
	}
	
	public ArrayList<ChucVu> getAllChuchVu() throws Exception {
		return cv_DAO.getAllChuchVu();
	}
	
}
