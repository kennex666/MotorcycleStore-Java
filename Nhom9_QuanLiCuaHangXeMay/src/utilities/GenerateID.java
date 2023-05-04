package utilities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class GenerateID {
	private static final String CHUOI_KY_TU = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	private static final Random random = new Random();
	public static final int MADAILY_FORTESTING = 2;
	public static final String[] MACHUCVU = {"QL", "BH", "KT"};
	public static String taoMaXe(String tenNCC) {
//		Tên NCC + ddmmYYYY + random 4 kí tự
		LocalDateTime thoiGianHienTai = LocalDateTime.now();
		String begin = tenNCC + thoiGianHienTai.format(DateTimeFormatter.ofPattern("ddmmyyyy"));
		String end = "";
		for (int i = 0; i < 4; i++) {
			end += CHUOI_KY_TU.charAt(random.nextInt(CHUOI_KY_TU.length()));
		}
		String maXe = begin + end;
		return maXe;
	}
	/* 
	 * type: KH (Khách hàng cá nhân), DN (Khách hàng doanh nghiệp)
	 * maDL: mã đại lí
	 * numberCustomer: số lượng khách hàng trên Database
	 */
	public static String taoIDKhachHang(int numberCustomer, int maDL, String type){
		return String.format("%s-%03d-%04d", type, maDL, numberCustomer + 1) ; // [Loại KH]-1[Mã đại lí]-[0000x]
		// KH cá nhân đăng kí lần đầu tại đại lí 2, tổng KH lúc đó là 12
		// Kết quả: DN-002-0013
  }
	public static String taoMaHD() {
		LocalDateTime thoiGianHienTai = LocalDateTime.now();
		return "HD" + thoiGianHienTai.format(DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS"));
	}
	public static String taoMaCTHD() {
		LocalDateTime thoiGianHienTai = LocalDateTime.now();
		return "CTHD" + thoiGianHienTai.format(DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS"));
	}

	/* 
	 * type: Truyền vào mã chức vụ
	 * maDL: mã đại lí
	 * numberCustomer: số lượng nhân vi trên Database
	 */
	public static String taoIDNhanVien(int numberEmployee, int maDL, int type){
		
		return String.format("%s-%03d-%04d", MACHUCVU[type - 1], maDL, numberEmployee + 1) ; // [Chức vụ]-1[Mã đại lí]-[0000x]
		// Nhân viên làm việc tại đại lí 2, tổng Nhân viên lúc đó là 20
		// Kết quả: NV-002-0021
	}
}
