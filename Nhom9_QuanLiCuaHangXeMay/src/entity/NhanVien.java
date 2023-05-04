package entity;

import java.time.LocalDate;
import java.util.Objects;

public class NhanVien {
	private String ID;
	private int NhanVienID;
	private int PhongBanID;
	private String HoTenNV;
	private LocalDate NgaySinh;
	private String SDT;
	private String SoCCCD;
	private String DiaChi;
	private String Email;
	private String GioiTinh;
	private String TrinhDoHocVan;
	private String BacTho;
	private String NhiemVu;
	private String Discriminator;
	
	public NhanVien() {
		super();
	}

	public NhanVien(String maNV) {
		this.setID(maNV);
	}

	public String getID() {
		return ID;
	}



	public void setID(String iD) {
		ID = iD;
	}



	public NhanVien(String iD, int nhanVienID, int phongBanID, String hoTenNV, LocalDate ngaySinh, String sDT,
			String soCCCD, String diaChi, String email, String gioiTinh, String trinhDoHocVan, String bacTho,
			String nhiemVu, String discriminator) {
		super();
		ID = iD;
		NhanVienID = nhanVienID;
		PhongBanID = phongBanID;
		HoTenNV = hoTenNV;
		NgaySinh = ngaySinh;
		SDT = sDT;
		SoCCCD = soCCCD;
		DiaChi = diaChi;
		Email = email;
		GioiTinh = gioiTinh;
		TrinhDoHocVan = trinhDoHocVan;
		BacTho = bacTho;
		NhiemVu = nhiemVu;
		Discriminator = discriminator;
	}



	public int getNhanVienID() {
		return NhanVienID;
	}

	public void setNhanVienID(int nhanVienID) {
		NhanVienID = nhanVienID;
	}

	public int getPhongBanID() {
		return PhongBanID;
	}

	public void setPhongBanID(int phongBanID) {
		PhongBanID = phongBanID;
	}

	public String getHoTenNV() {
		return HoTenNV;
	}

	public void setHoTenNV(String hoTenNV) {
		HoTenNV = hoTenNV;
	}

	public LocalDate getNgaySinh() {
		return NgaySinh;
	}

	public void setNgaySinh(LocalDate ngaySinh) {
		NgaySinh = ngaySinh;
	}

	public String getSDT() {
		return SDT;
	}

	public void setSDT(String sDT) {
		SDT = sDT;
	}

	public String getSoCCCD() {
		return SoCCCD;
	}

	public void setSoCCCD(String soCCCD) {
		SoCCCD = soCCCD;
	}

	public String getDiaChi() {
		return DiaChi;
	}

	public void setDiaChi(String diaChi) {
		DiaChi = diaChi;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getGioiTinh() {
		return GioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		GioiTinh = gioiTinh;
	}

	public String getTrinhDoHocVan() {
		return TrinhDoHocVan;
	}

	public void setTrinhDoHocVan(String trinhDoHocVan) {
		TrinhDoHocVan = trinhDoHocVan;
	}

	public String getBacTho() {
		return BacTho;
	}

	public void setBacTho(String bacTho) {
		BacTho = bacTho;
	}

	public String getNhiemVu() {
		return NhiemVu;
	}

	public void setNhiemVu(String nhiemVu) {
		NhiemVu = nhiemVu;
	}

	public String getDiscriminator() {
		return Discriminator;
	}

	public void setDiscriminator(String discriminator) {
		Discriminator = discriminator;
	}

	@Override
	public String toString() {
		return "NhanVien [NhanVienID=" + NhanVienID + ", PhongBanID=" + PhongBanID + ", HoTenNV=" + HoTenNV
				+ ", NgaySinh=" + NgaySinh + ", SDT=" + SDT + ", SoCCCD=" + SoCCCD + ", DiaChi=" + DiaChi + ", Email="
				+ Email + ", GioiTinh=" + GioiTinh + ", TrinhDoHocVan=" + TrinhDoHocVan + ", BacTho=" + BacTho
				+ ", NhiemVu=" + NhiemVu + ", Discriminator=" + Discriminator + "]";
	}



	@Override
	public int hashCode() {
		return Objects.hash(ID, NhanVienID, PhongBanID, SDT, SoCCCD);
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
		return ID == other.ID && NhanVienID == other.NhanVienID && PhongBanID == other.PhongBanID
				&& Objects.equals(SDT, other.SDT) && Objects.equals(SoCCCD, other.SoCCCD);
	}
	
	
	
	
}
