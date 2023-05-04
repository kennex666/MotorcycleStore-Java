package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.HoaDon;
import entity.KhachHang;
import entity.NhanVien;
import interfaces.IHoaDon;

public class HoaDon_DAO implements IHoaDon {
	Connection con = ConnectDB.getConnection();
	@Override
	public ArrayList<HoaDon> getAllHoaDon() throws Exception {
		ArrayList<HoaDon> list = new ArrayList<>();
		String query = "Select * from HoaDon";
		try {
			Statement stm = con.createStatement();
			ResultSet results = stm.executeQuery(query);
			while (results.next()) {
				String maHD = results.getString("MaHD");
				Date ngayLap = results.getDate("NgayLapHoaDon");
				KhachHang kh = new KhachHang(results.getString("MaKH"));
				NhanVien nv = new NhanVien(results.getString("MaNV"));
				double tongTien = results.getDouble("TongTien");
				
				HoaDon hd = new HoaDon(maHD, ngayLap, kh, nv, tongTien);
				
				list.add(hd);
			}
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}
	@Override
	public boolean taoHoaDon(HoaDon hd) {
		// TODO Auto-generated method stub
		String maHD = hd.getId();
		String maKH = hd.getKh().getMaKhachHang();
		String maNV = hd.getNv().getID();
		java.util.Date ngayLap = hd.getNgayLapHoaDon();
		double tongTien = hd.getTongTien();
		String sql = "INSERT INTO hoa_don (MaHD, MaKH, MaNV, NgayLapHoaDon, TongTien) VALUES (?, ?, ?, ?, ?)";
		PreparedStatement preparedStatement;
		try {
			preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, maHD); // mã hóa đơn
			preparedStatement.setString(2, maKH); // mã khách hàng
			preparedStatement.setString(3, maNV); // mã nhân viên
			preparedStatement.setDate(4, (Date) ngayLap); // ngày lập hóa đơn
			preparedStatement.setDouble(5, tongTien); // tổng tiền
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}
