package entity;

import java.util.Objects;

public class ChiTietHoaDon {
	private String id;
	private int soLuongXe;
	private HoaDon hd;
	private String maSP;
	private double giaBan;
	
	public ChiTietHoaDon() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ChiTietHoaDon(String id, int soLuongXe, double giaBan ,String maSP,  HoaDon hd) throws Exception {
		super();
		setId(id);
		setSoLuongXe(soLuongXe);
		setHd(hd);
		setMaSP(maSP);
		setGiaBan(giaBan);
	}
	public String getId() {
		return id;
	}
	
	public void setId(String id) throws Exception {
		if (id.equals(""))
			throw new Exception("Đã có lỗi trong quá trình phát sinh ID chi tiết hóa đơn");
		this.id = id;
	}
	public String getMaSP() {
		return maSP;
	}
	public void setMaSP(String maSP) {
		this.maSP = maSP;
	}
	public int getSoLuongXe() {
		return soLuongXe;
	}
	public void setSoLuongXe(int soLuongXe) throws Exception {
		if (soLuongXe<=0)
			throw new Exception("Số lượng xe phải lớn hơn 0");
		this.soLuongXe = soLuongXe;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ChiTietHoaDon other = (ChiTietHoaDon) obj;
		return id == other.id;
	}
	@Override
	public String toString() {
		return "ChiTietHoaDon [id=" + id + ", soLuongXe=" + soLuongXe + "]";
	}
	public HoaDon getHd() {
		return hd;
	}
	public void setHd(HoaDon hd) {
		this.hd = hd;
	}
	public double getGiaBan() {
		return giaBan;
	}
	public void setGiaBan(double giaBan) {
		this.giaBan = giaBan;
	}
	
	
}
