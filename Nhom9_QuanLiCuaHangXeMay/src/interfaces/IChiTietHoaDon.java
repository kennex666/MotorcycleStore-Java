package interfaces;

import java.util.ArrayList;

import entity.ChiTietHoaDon;

public interface IChiTietHoaDon {

	ArrayList<ChiTietHoaDon> getCTHDByMaHD(String maHD) throws Exception;
	boolean taoCTHD(ChiTietHoaDon cthd);
}
