package entity;

import java.util.Objects;

public class LinhKien {
	private String id, ten;
	private double soLuongKho,soLuongBan;
	private String imagePath;
	public LinhKien() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LinhKien(String id) throws Exception{
		super();
		setId(id);
	}
	
	public LinhKien(String id, String ten, double soLuongKho, double soLuongBan, String imagePath) throws Exception {
		super();
		this.setId(id);
		this.setTen(ten);
		this.setSoLuongKho(soLuongKho);
		this.setSoLuongBan(soLuongBan);
		this.setImagePath(imagePath);
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		// Nếu không có sẽ được gắn hình mặc định.
		this.imagePath = imagePath;
	}
	public String getId() {
		return id;
	}

	public String getTen() {
		return ten;
	}
	public void setId(String id) throws Exception{
		if (id.trim() == "" || id.isEmpty() || id.isBlank())
			throw new Exception("ID không hợp lệ. Lỗi trong quá trình phát sinh!");
		this.id = id;
	}
	
	

	
	public double getSoLuongKho() {
		return soLuongKho;
	}
	public void setSoLuongKho(double soLuongKho) throws Exception {
		if (soLuongKho<0)
			throw new Exception("Hết linh kiện trong kho!");
		this.soLuongKho = soLuongKho;
	}
	public double getSoLuongBan() {
		return soLuongBan;
	}
	public void setSoLuongBan(double soLuongBan) {
		this.soLuongBan = soLuongBan;
	}
	public void setTen(String ten) throws Exception{
		if (ten.trim() == "" || ten.isEmpty() || ten.isBlank())
			throw new Exception("Tên linh kiện rỗng!");
		this.ten = ten;
	}
	@Override
	public String toString() {
		return "LinhKien [id=" + id + ", ten=" + ten + "]";
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
		LinhKien other = (LinhKien) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
}
