package interfaces;

import java.util.ArrayList;

import entity.Xe;

public interface IXe {
	public ArrayList<Xe> getAllXe() throws Exception;

	void updateSoLuongKho(int newSL, String maXe);
	
	void updateSoLuongBan(int newSL, String maXe);

	String getTenByMa(String maXe);
	
	public ArrayList<Xe> findXe(String keywords);

	public boolean editXe(Xe xeCanSua);

	public int totalXe();

	public boolean addXe(Xe xe);

	public boolean deleteXe(Xe xe);
}
