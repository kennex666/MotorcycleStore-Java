package entity;

public class PhieuSuaChua {
	 private int ID;
	 private String NhanXet;
	 private double GiaTien;
	public PhieuSuaChua(int iD, String nhanXet, double giaTien) {
		super();
		ID = iD;
		NhanXet = nhanXet;
		GiaTien = giaTien;
	}
	public PhieuSuaChua() {
		super();
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getNhanXet() {
		return NhanXet;
	}
	public void setNhanXet(String nhanXet) {
		NhanXet = nhanXet;
	}
	public double getGiaTien() {
		return GiaTien;
	}
	public void setGiaTien(double giaTien) {
		GiaTien = giaTien;
	}
	@Override
	public String toString() {
		return "PhieuSuaChua [ID=" + ID + ", NhanXet=" + NhanXet + ", GiaTien=" + GiaTien + "]";
	}
	 
}
