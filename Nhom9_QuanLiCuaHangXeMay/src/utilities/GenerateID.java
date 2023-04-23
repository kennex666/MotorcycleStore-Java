package utilities;

/*
 * Phát sinh ID theo quy tắc
 */
public class GenerateID {
	
	public static String taoIDLinhKien(String id) {
		return "";
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
}
