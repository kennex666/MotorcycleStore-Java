package bus;

import java.util.ArrayList;

import dao.ChiTietHoaDon_DAO;
import entity.ChiTietHoaDon;

public class ChiTietHoaDon_BUS {
	ChiTietHoaDon_DAO cthd_DAO;

	public ChiTietHoaDon_BUS() {
		super();
		// TODO Auto-generated constructor stub
		cthd_DAO = new ChiTietHoaDon_DAO();
	}
	
	public ArrayList<ChiTietHoaDon> getCTHDByMaHD(String maHD) throws Exception {
		return cthd_DAO.getCTHDByMaHD(maHD);
	}
	
	public void taoChiTietHoaDon(ChiTietHoaDon cthd) {
		cthd_DAO.taoCTHD(cthd);
	}
	
}
