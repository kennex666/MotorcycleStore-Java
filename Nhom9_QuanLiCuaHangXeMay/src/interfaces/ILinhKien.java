package interfaces;

import java.util.ArrayList;

import entity.LinhKien;

public interface ILinhKien {
	public ArrayList<LinhKien> getAllLinhKien() throws Exception;
	void updateSoLuongKho(int newSL, String maLK);
	void updateSoLuongBan(int newSL, String maLK);
	String getTenByMa(String maLK);
	public boolean themLinhKien(LinhKien lk);
	public boolean xoaLinhKien(LinhKien lk);
	public boolean editLinhKien(LinhKien lk);
	public ArrayList<LinhKien> findLinhKien(String keyword) throws Exception;
}