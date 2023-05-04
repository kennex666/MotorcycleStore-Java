package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.ChucVu;
import interfaces.IChucVu;

public class ChucVu_DAO implements IChucVu {

	@Override
	public ArrayList<ChucVu> getAllChucVu() {
		Connection con = ConnectDB.getConnection(); 
		ArrayList<ChucVu> list = new ArrayList<ChucVu>();
		String query = "SELECT * FROM ChucVu";
		try {
			Statement stm = con.createStatement();
			ResultSet results = stm.executeQuery(query);
			while (results.next()) {
				int maCV = results.getInt("MaCV");
				String tenCV = results.getString("TenCV");

				ChucVu cv;
				try {
					cv = new ChucVu(maCV, tenCV);
					list.add(cv);
				} catch (Exception e) {
				}
			}
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

}