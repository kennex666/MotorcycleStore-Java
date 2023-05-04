package testing;

import bus.KhachHang_BUS;
import connectDB.ConnectDB;
import utilities.GenerateID;

public class TestGenerateID {
	public static void main(String[] args) {
		ConnectDB.getInstance().connect();
		KhachHang_BUS kh_bus = new KhachHang_BUS();
		System.err.println("Tổng SL KH: " + kh_bus.totalCustomers());
		System.out.println(GenerateID.taoIDKhachHang(12, 2, "DN"));
	}
}
