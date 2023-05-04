package interfaces;

import java.util.ArrayList;

import entity.DaiLy;

public interface IDaiLy {
	public ArrayList<DaiLy> getAllDaiLy();
	public ArrayList<DaiLy> findDaiLy(String keyword);
}
