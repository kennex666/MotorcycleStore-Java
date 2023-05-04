package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import connectDB.ConnectDB;
import interfaces.INhanVien;

public class NhanVien_DAO implements INhanVien {
	Connection con = ConnectDB.getConnection(); 

	@Override
	public String getTenByMaNV(String maNV) {
		String query = "Select * from NhanVien WHERE MaNV = '" + maNV + "'";
		try {
			Statement stm = con.createStatement();
			ResultSet results = stm.executeQuery(query);
			if (results.next()) return results.getString("HoTenNV");
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
