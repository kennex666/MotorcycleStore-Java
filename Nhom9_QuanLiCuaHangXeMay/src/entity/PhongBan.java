package entity;

public class PhongBan {
	private String maPhongBan;
	private String tenPhongBan;
	public PhongBan() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public PhongBan(String maPhongBan) throws Exception {
		super();
		this.setMaPhongBan(maPhongBan);
	}

	public PhongBan(String maPhongBan, String tenPhongBan) throws Exception {
		super();
		this.setMaPhongBan(maPhongBan);
		this.setTenPhongBan(tenPhongBan);
	}

	public String getMaPhongBan() {
		return maPhongBan;
	}

	public void setMaPhongBan(String maPhongBan) throws Exception {
		if (maPhongBan.trim().equals("")) {
			throw new Exception("Mã phòng ban không được để trống");
		}
		else this.maPhongBan = maPhongBan;
	}

	public String getTenPhongBan() {
		return tenPhongBan;
	}

	public void setTenPhongBan(String tenPhongBan) throws Exception {
		if (tenPhongBan.trim().equals("")) {
			throw new Exception("Tên phòng ban không được để trống");
		}
		else this.tenPhongBan = tenPhongBan;
	}
	
}
