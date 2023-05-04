package interfaces;

import java.util.ArrayList;

import entity.NhaCungCap;

public interface INhaCungCap {
	public String getTenByMa(String maNCC);
	public ArrayList<NhaCungCap> getAllNCC();
}
