package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.ChiTietHoaDon;
import entity.HoaDon;
import interfaces.IChiTietHoaDon;

public class ChiTietHoaDon_DAO implements IChiTietHoaDon{
	Connection con = ConnectDB.getConnection();

	@Override
	public ArrayList<ChiTietHoaDon> getCTHDByMaHD(String maHD) throws Exception {
		ArrayList<ChiTietHoaDon> list = new ArrayList<>();
		String query = "Select * from ChiTietHoaDon WHERE MaHD = '" + maHD + "'";;
		try {
			Statement stm = con.createStatement();
			ResultSet results = stm.executeQuery(query);
			while (results.next()) {
				String maCTHD = results.getString("MaCTHD");
				HoaDon hd = new HoaDon(results.getString("MaHD"));
				int soLuong = results.getInt("SoLuong");
				String maSP = results.getString("MaSP");
				double giaBan = results.getDouble("GiaBan");
				
				ChiTietHoaDon cthd = new ChiTietHoaDon(maCTHD, soLuong, giaBan, maSP, hd);
				
				list.add(cthd);
			}
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public boolean taoCTHD(ChiTietHoaDon cthd) {
		// TODO Auto-generated method stub
				String maCTHD = cthd.getId();
				String maHD = cthd.getHd().getId();
				String maSP = cthd.getMaSP();
				int soLuong = cthd.getSoLuongXe();
				double giaBan = cthd.getGiaBan();
				String sql = "INSERT INTO ChiTietHoaDon (MaCTHD, MaHD, MaSP, SoLuong, GiaBan) VALUES (?, ?, ?, ?, ?)";
				PreparedStatement preparedStatement;
				try {
					preparedStatement = con.prepareStatement(sql);
					preparedStatement.setString(1, maCTHD); // mã hóa đơn
					preparedStatement.setString(2, maHD); // mã khách hàng
					preparedStatement.setString(3, maSP); // mã nhân viên
					preparedStatement.setInt(4, soLuong); // ngày lập hóa đơn
					preparedStatement.setDouble(5, giaBan); // tổng tiền
					preparedStatement.executeUpdate();
					return true;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return false;
	}

}
