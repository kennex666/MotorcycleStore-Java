package utilities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class GenerateID {
	private static final String CHUOI_KY_TU = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	private static final Random random = new Random();
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
}
