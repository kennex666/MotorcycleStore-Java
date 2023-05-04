package bus;

import java.util.ArrayList;

import dao.ChucVu_DAO;
import dao.PhongBan_DAO;
import entity.ChucVu;
import entity.PhongBan;
import interfaces.IChucVu;
import interfaces.IPhongBan;

public class PhongBan_BUS implements IPhongBan{
	private PhongBan_DAO pb_DAO;

	public PhongBan_BUS() {
		super();
		// TODO Auto-generated constructor stub
		pb_DAO = new PhongBan_DAO();
	}
	
	public ArrayList<PhongBan> getAllPhongBan() {
		return pb_DAO.getAllPhongBan();
	}
	
}