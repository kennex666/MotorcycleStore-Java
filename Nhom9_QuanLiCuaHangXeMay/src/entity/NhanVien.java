package entity;

import java.time.LocalDate;
import java.util.Objects;

public class NhanVien {
	private String maNhanVien, tenNhanVien, diaChi, soDT, soCCCD, email, trinhDo, bacTho;
	private boolean gioiTinh;
	private LocalDate ngaySinh;
	private ChucVu chucVu;
	private PhongBan phongBan;
	
	public NhanVien() {
		super();
		// TODO Auto-generated constructor stub
	}
	public NhanVien(String maNhanVien, String tenNhanVien, String diaChi, String soDT, String soCCCD,
			boolean gioiTinh, LocalDate ngaySinh, String email, String trinhDo, String bacTho, ChucVu chucVu, PhongBan phongBan) throws Exception{
		super();
		setMaNhanVien(maNhanVien);
		setTenNhanVien(tenNhanVien);
		setDiaChi(diaChi);
		setSoDT(soDT);
		setSoCCCD(soCCCD);
		setGioiTinh(gioiTinh);
		setNgaySinh(ngaySinh);
		setEmail(email);
		setTrinhDo(trinhDo);
		setBacTho(bacTho);
		setChucVu(chucVu);
		setPhongBan(phongBan);
	}
	public NhanVien(String maNhanVien) throws Exception{
		super();
		setMaNhanVien(maNhanVien);
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMaNhanVien() {
		return maNhanVien;
	}
	public void setMaNhanVien(String maNhanVien) throws Exception{
		if (maNhanVien.trim() == "" || maNhanVien.isBlank() || maNhanVien.isEmpty())
			throw new Exception("Mã khách hàng rỗng! Đã có lỗi trong quá trình phát sinh");
		this.maNhanVien = maNhanVien;
	}
	public String getTenNhanVien() {
		return tenNhanVien;
	}
	public void setTenNhanVien(String tenNhanVien) throws Exception{
		if (tenNhanVien.trim() == "" || tenNhanVien.isBlank() || tenNhanVien.isEmpty())
			throw new Exception("Tên khách hàng là trường bắt buộc!");
		this.tenNhanVien = tenNhanVien;
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
	public String getTrinhDo() {
		return trinhDo;
	}
	public void setTrinhDo(String trinhDo) {
		this.trinhDo = trinhDo;
	}
	public String getBacTho() {
		return bacTho;
	}
	public void setBacTho(String bacTho) {
		this.bacTho = bacTho;
	}
	public ChucVu getChucVu() {
		return chucVu;
	}
	public void setChucVu(ChucVu chucVu) {
		this.chucVu = chucVu;
	}
	public PhongBan getPhongBan() {
		return phongBan;
	}
	public void setPhongBan(PhongBan phongBan) {
		this.phongBan = phongBan;
	}
	@Override
	public String toString() {
		return "NhanVien [maNhanVien=" + maNhanVien + ", tenNhanVien=" + tenNhanVien + ", diaChi=" + diaChi
				+ ", soDT=" + soDT + ", soCCCD=" + soCCCD + ", gioiTinh=" + gioiTinh + ", ngaySinh=" + ngaySinh + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(maNhanVien);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NhanVien other = (NhanVien) obj;
		return Objects.equals(maNhanVien, other.maNhanVien);
	}
	
	
	
}
