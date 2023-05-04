package entity;

public class ChiTietSuaChua {
	private int ID;
	private int SoLuong;
	private int LinhKienID;
	private int PhieuSuaChuaID;
	public ChiTietSuaChua(int iD, int soLuong, int linhKienID, int phieuSuaChuaID) {
		super();
		ID = iD;
		SoLuong = soLuong;
		LinhKienID = linhKienID;
		PhieuSuaChuaID = phieuSuaChuaID;
	}
	
	public ChiTietSuaChua(int iD) {
		super();
		ID = iD;
	}

	public ChiTietSuaChua() {
		super();
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public int getSoLuong() {
		return SoLuong;
	}
	public void setSoLuong(int soLuong) {
		SoLuong = soLuong;
	}
	public int getLinhKienID() {
		return LinhKienID;
	}
	public void setLinhKienID(int linhKienID) {
		LinhKienID = linhKienID;
	}
	public int getPhieuSuaChuaID() {
		return PhieuSuaChuaID;
	}
	public void setPhieuSuaChuaID(int phieuSuaChuaID) {
		PhieuSuaChuaID = phieuSuaChuaID;
	}
	@Override
	public String toString() {
		return "ChiTietSuaChua [ID=" + ID + ", SoLuong=" + SoLuong + ", LinhKienID=" + LinhKienID + ", PhieuSuaChuaID="
				+ PhieuSuaChuaID + "]";
	}
	

}
