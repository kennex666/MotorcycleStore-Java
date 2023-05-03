package interfaces;

import java.util.ArrayList;

import entity.Xe;

public interface IXe {
	public ArrayList<Xe> getAllXe() throws Exception;
	void updateSoLuongKho(int newSL, String maXe);
	void updateSoLuongBan(int newSL, String maXe);
}
