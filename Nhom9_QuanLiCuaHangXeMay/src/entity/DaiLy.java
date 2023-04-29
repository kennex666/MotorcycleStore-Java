package entity;

import java.util.Objects;

public class DaiLy {
	private int maDaiLy;
	private String tenDaiLy, diaChi;

	public DaiLy(int maDaiLy, String tenDaiLy, String diaChi) throws Exception{
		super();
		setDiaChi(diaChi);
		setMaDaiLy(maDaiLy);
		setTenDaiLy(tenDaiLy);
	}

	public DaiLy() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DaiLy(int maDaiLy) throws Exception{
		super();
		setMaDaiLy(maDaiLy);
	}
	
	public int getMaDaiLy() {
		return maDaiLy;
	}

	public void setMaDaiLy(int maDaiLy) throws Exception{
		if (maDaiLy == 0 || maDaiLy < 0)
			throw new Exception("Mã đại lí rỗng hoặc có lỗi trong quá trình phát sinh!");
		this.maDaiLy = maDaiLy;
	}

	public String getTenDaiLy() {
		return tenDaiLy;
	}

	public void setTenDaiLy(String tenDaiLy) throws Exception{
		if (tenDaiLy.trim() == "" || tenDaiLy.isEmpty() || tenDaiLy.isBlank())
			throw new Exception("Tên đại lí là một trường bắt buộc!");
		
		this.tenDaiLy = tenDaiLy;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) throws Exception{
		if (diaChi.trim() == "" || diaChi.isEmpty() || diaChi.isBlank())
			throw new Exception("Địa chỉ là một trường bắt buộc!");
		this.diaChi = diaChi;
	}

	@Override
	public String toString() {
		return "DaiLy [maDaiLy=" + maDaiLy + ", tenDaiLy=" + tenDaiLy + ", diaChi=" + diaChi + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(maDaiLy);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DaiLy other = (DaiLy) obj;
		return Objects.equals(maDaiLy, other.maDaiLy);
	}
	
	
}
