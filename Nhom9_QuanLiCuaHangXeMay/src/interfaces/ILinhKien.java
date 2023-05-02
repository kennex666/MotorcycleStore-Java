package interfaces;

import java.util.ArrayList;

import entity.LinhKien;

public interface ILinhKien {
	public ArrayList<LinhKien> getAllLinhKien();
	public ArrayList<LinhKien> findLinhKien(String keyword);
	
	
}
