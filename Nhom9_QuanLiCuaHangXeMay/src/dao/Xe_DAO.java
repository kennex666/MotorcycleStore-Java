package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.NhaCungCap;
import entity.Xe;
import interfaces.IXe;

public class Xe_DAO implements IXe {
	Connection con = ConnectDB.getConnection();

	@Override
	public ArrayList<Xe> getAllXe() throws Exception {
		// TODO Auto-generated method stub
		ArrayList<Xe> list = new ArrayList<>();
		String query = "Select * from Xe";
		try {
			Statement stm = con.createStatement();
			ResultSet results = stm.executeQuery(query);
			while (results.next()) {
				String maXe = results.getString("MaXe");
				String maNCC = results.getString("MaNCC");
				String tenXe = results.getString("TenXe");
				String loaiXe = results.getString("LoaiXe");
				String nuocSX = results.getString("nuocSX");
				double soPK = results.getDouble("SoPK");
				String soKhung = results.getString("SoKhung");
				String soSuon = results.getString("SoSuon");
				String mauXe = results.getString("MauXe");
				double giaXe = results.getDouble("Gia");
				String imgPath = results.getString("ImgPath");
				int soLuongBan = results.getInt("SoLuongBan");
				int soLuongKho = results.getInt("SoLuongKho");

				NhaCungCap ncc = new NhaCungCap(maNCC);

				Xe xe = new Xe(maXe, tenXe, loaiXe, nuocSX, soPK, soKhung, soSuon, mauXe, giaXe, imgPath, ncc, soLuongKho, soLuongBan);
				list.add(xe);
			}
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public void updateSoLuongKho(int newSL, String maXe) {
		// TODO Auto-generated method stub
		String sql = "UPDATE Xe SET SoLuongKho = " + newSL + " WHERE MaXe = '" + maXe + "'";
		try {
			Statement stm = con.createStatement();
			stm.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void updateSoLuongBan(int newSL, String maXe) {
		// TODO Auto-generated method stub
		String sql = "UPDATE Xe SET SoLuongBan = " + newSL + " WHERE MaXe = '" + maXe + "'";
		try {
			Statement stm = con.createStatement();
			stm.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public String getTenByMa(String maXe) {

		// TODO Auto-generated method stub
		String sql = "Select * from Xe where MaXe = '" + maXe + "'";
		try {
			Statement stm = con.createStatement();
			ResultSet results = stm.executeQuery(sql);
			if (results.next()) return results.getString("TenXe");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
