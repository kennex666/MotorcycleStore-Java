package entity;

public class Kho {
	private int maKho; //ID Tự tăng
	private int soLuong; 
	
	public Kho() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Kho(int maKho) throws Exception {
		super();
		this.setMaKho(maKho);
	}

	public Kho(int maKho, int soLuong) throws Exception {
		super();
		this.setMaKho(maKho);
		this.setSoLuong(soLuong);
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) throws Exception {
		if (soLuong < 0) {
			throw new Exception("Số lượng không hợp lệ");
		}
		else this.soLuong = soLuong;
	}

	public int getMaKho() {
		return maKho;
	}

	public void setMaKho(int maKho) throws Exception {
		if (maKho <= 0) {
			throw new Exception("Mã kho không hợp lệ");
		}
		else this.maKho = maKho;
	}
	
}
