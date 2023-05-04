package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.ChiTietSuaChua;
import entity.LinhKien;
import entity.NhaCungCap;
import interfaces.ILinhKien;

public class LinhKien_DAO implements ILinhKien {
	Connection con = ConnectDB.getConnection();

	@Override
	public ArrayList<LinhKien> getAllLinhKien() throws Exception {
		// TODO Auto-generated method stub
		ArrayList<LinhKien> list = new ArrayList<>();
		String query = "Select * from LinhKien";
		try {
			Statement stm = con.createStatement();
			ResultSet results = stm.executeQuery(query);
			while (results.next()) {
				String maLK = results.getString("MaLinhKien");
				String maNCC = results.getString("MaNCC");
				int maCTSC = results.getInt("MaCTSuaChua");
				String tenLK = results.getString("TenLinhKien");
				String imgPath = results.getString("ImgPath");
				double gia = results.getDouble("GiaBan");

				int soLuongBan = results.getInt("SoLuongBan");
				int soLuongKho = results.getInt("SoLuongKho");
				NhaCungCap nhaCungCap = new NhaCungCap(maNCC);
				ChiTietSuaChua ctsc = new ChiTietSuaChua(maCTSC);

				LinhKien lk = new LinhKien(maLK, tenLK, imgPath, nhaCungCap, ctsc, gia, soLuongKho, soLuongBan);

				list.add(lk);
			}
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public void updateSoLuongKho(int newSL, String maLK) {
		// TODO Auto-generated method stub
		String sql = "UPDATE LinhKien SET SoLuongKho = " + newSL + " WHERE MaLinhKien = '" + maLK + "'";
		try {
			Statement stm = con.createStatement();
			stm.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void updateSoLuongBan(int newSL, String maLK) {
		// TODO Auto-generated method stub
		String sql = "UPDATE LinhKien SET SoLuongBan = " + newSL + " WHERE MaLinhKien = '" + maLK + "'";
		try {
			Statement stm = con.createStatement();
			stm.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public String getTenByMa(String maLK) {
		// TODO Auto-generated method stub
		String sql = "Select * from LinhKien where MaLinhKien = '" + maLK + "'";
		try {
			Statement stm = con.createStatement();
			ResultSet results = stm.executeQuery(sql);
			if (results.next()) return results.getString("TenLinhKien");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<LinhKien> findLinhKien(String keywords) throws Exception {
		ArrayList<LinhKien> list = new ArrayList<LinhKien>();
		Connection conn = ConnectDB.getConnection();
		String query = "SELECT * FROM LinhKien WHERE MaLinhKien LIKE CONCAT('%', ?, '%') OR TenLinhKien LIKE CONCAT('%', ?, '%');";
		try {
			PreparedStatement pstm = conn.prepareStatement(query);
			pstm.setString(1, keywords);
			pstm.setString(2, keywords);
			ResultSet results = pstm.executeQuery();
			while (results.next()) {
				String maLK = results.getString("MaLinhKien");
				String maNCC = results.getString("MaNCC");
				int maCTSC = results.getInt("MaCTSuaChua");
				String tenLK = results.getString("TenLinhKien");
				String imgPath = results.getString("ImgPath");
				double gia = results.getDouble("GiaBan");

				int soLuongBan = results.getInt("SoLuongBan");
				int soLuongKho = results.getInt("SoLuongKho");
				NhaCungCap nhaCungCap = new NhaCungCap(maNCC);
				ChiTietSuaChua ctsc = new ChiTietSuaChua(maCTSC);

				LinhKien lk = new LinhKien(maLK, tenLK, imgPath, nhaCungCap, ctsc, gia, soLuongKho, soLuongBan);

				list.add(lk);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

}
