package entity;

import java.time.LocalDate;
import java.util.Objects;

public class KhachHang {
	private String maKhachHang, tenKhachHang, diaChi, soDT, soCCCD;
	private boolean gioiTinh;
	private LocalDate ngaySinh;
	
	public KhachHang() {
		super();
		// TODO Auto-generated constructor stub
	}
	public KhachHang(String maKhachHang, String tenKhachHang, String diaChi, String soDT, String soCCCD,
			boolean gioiTinh, LocalDate ngaySinh) throws Exception{
		super();
		setMaKhachHang(maKhachHang);
		setTenKhachHang(tenKhachHang);
		setDiaChi(diaChi);
		setSoDT(soDT);
		setSoCCCD(soCCCD);
		setGioiTinh(gioiTinh);
		setNgaySinh(ngaySinh);
	}
	public KhachHang(String maKhachHang) throws Exception{
		super();
		setMaKhachHang(maKhachHang);
	}
	
	public String getMaKhachHang() {
		return maKhachHang;
	}
	public void setMaKhachHang(String maKhachHang) throws Exception{
		if (maKhachHang.trim() == "" || maKhachHang.isBlank() || maKhachHang.isEmpty())
			throw new Exception("Mã khách hàng rỗng! Đã có lỗi trong quá trình phát sinh");
		this.maKhachHang = maKhachHang;
	}
	public String getTenKhachHang() {
		return tenKhachHang;
	}
	public void setTenKhachHang(String tenKhachHang) throws Exception{
		if (tenKhachHang.trim() == "" || tenKhachHang.isBlank() || tenKhachHang.isEmpty())
			throw new Exception("Tên khách hàng là trường bắt buộc!");
		this.tenKhachHang = tenKhachHang;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) throws Exception{
		if (diaChi.trim() == "" || diaChi.isBlank() || diaChi.isEmpty())
			throw new Exception("Địa chỉ là một trường bắt buộc!");
		
		this.diaChi = diaChi;
	}
	public String getSoDT() {
		return soDT;
	}
	public void setSoDT(String soDT) throws Exception{
		if (soDT.trim() == "" || soDT.isBlank() || soDT.isEmpty())
			throw new Exception("Số điện thoại là một trường bắt buộc!");
		this.soDT = soDT;
	}
	public String getSoCCCD() {
		return soCCCD;
	}
	public void setSoCCCD(String soCCCD) throws Exception{
		if (soCCCD.trim() == "" || soCCCD.isBlank() || soCCCD.isEmpty())
			throw new Exception("Số căn cước công dân là một trường bắt buộc!");
		this.soCCCD = soCCCD;
	}
	public boolean isGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public LocalDate getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(LocalDate ngaySinh) throws Exception{
		this.ngaySinh = ngaySinh;
	}
	@Override
	public String toString() {
		return "KhachHang [maKhachHang=" + maKhachHang + ", tenKhachHang=" + tenKhachHang + ", diaChi=" + diaChi
				+ ", soDT=" + soDT + ", soCCCD=" + soCCCD + ", gioiTinh=" + gioiTinh + ", ngaySinh=" + ngaySinh + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(maKhachHang);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		KhachHang other = (KhachHang) obj;
		return Objects.equals(maKhachHang, other.maKhachHang);
	}
	
	
	
}
