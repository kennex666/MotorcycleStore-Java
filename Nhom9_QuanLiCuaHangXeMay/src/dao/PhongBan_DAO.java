package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.PhongBan;
import interfaces.IPhongBan;

public class PhongBan_DAO implements IPhongBan {

	@Override
	public ArrayList<PhongBan> getAllPhongBan() {
		Connection conn = ConnectDB.getConnection(); 
		ArrayList<PhongBan> list = new ArrayList<PhongBan>();
		String query = "SELECT * FROM PhongBan";
		try {
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(query);
			while (rs.next()) {
				int maCV = rs.getInt("MaPB");
				String tenCV = rs.getString("TenPB");

				PhongBan cv;
				try {
					cv = new PhongBan(maCV, tenCV);
					list.add(cv);
				} catch (Exception e) {
				}
			}
		} 
		catch (SQLException e) {
		}

		return list;
	}

}