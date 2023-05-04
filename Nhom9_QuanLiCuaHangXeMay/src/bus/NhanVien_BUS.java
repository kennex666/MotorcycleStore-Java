package bus;

import dao.NhanVien_DAO;

public class NhanVien_BUS {
	NhanVien_DAO nv_DAO;
	
	public NhanVien_BUS() {
		super();
		nv_DAO = new NhanVien_DAO();
	}

	public String getTenByMa(String maNV) {
		return nv_DAO.getTenByMaNV(maNV);
	}
}
