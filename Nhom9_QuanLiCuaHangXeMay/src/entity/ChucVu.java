package entity;

public class ChucVu {
	private int maChucVu; // ID -> Tự tăng
	private String tenChucVu;
	public ChucVu() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ChucVu(int maChucVu) throws Exception {
		super();
		this.setMaChucVu(maChucVu);
	}

	public ChucVu(int maChucVu, String tenChucVu) throws Exception {
		super();
		this.setMaChucVu(maChucVu);
		this.setTenChucVu(tenChucVu);
	}

	public int getMaChucVu() {
		return maChucVu;
	}

		public void setMaChucVu(int maChucVu) throws Exception {
			if (maChucVu <= 0) {
				throw new Exception("Mã chức vụ không hợp lệ");
			}
			else this.maChucVu = maChucVu;
		}

	public String getTenChucVu() {
		return tenChucVu;
	}

	public void setTenChucVu(String tenChucVu) throws Exception {
		if (tenChucVu.trim().equals("")) {
			throw new Exception("Màu xe không được để trống");
		}
		else this.tenChucVu = tenChucVu;
	}


}
