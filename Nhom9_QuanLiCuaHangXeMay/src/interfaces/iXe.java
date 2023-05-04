package interfaces;

import java.util.ArrayList;

import entity.Xe;

public interface iXe {
	public ArrayList<Xe> getAllXe() throws Exception;
	public ArrayList<Xe> findXe(String keywords);
	public boolean editXe(Xe xeCanSua);
	public int totalXe();
	public boolean addXe(Xe xe);
	public boolean deleteXe(Xe xe);
}
