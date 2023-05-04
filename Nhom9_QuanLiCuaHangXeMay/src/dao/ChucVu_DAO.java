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
	Connection con = ConnectDB.getConnection(); 

	@Override
	public ArrayList<ChucVu> getAllChuchVu() throws Exception {
		ArrayList<ChucVu> list = new ArrayList<>();
		String query = "Select * from ChucVu";
		try {
			Statement stm = con.createStatement();
			ResultSet results = stm.executeQuery(query);
			while (results.next()) {
				int maCV = results.getInt("MaCV");
				String tenCV = results.getString("TenCV");

				ChucVu cv = new ChucVu(maCV, tenCV);
				list.add(cv);
			}
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

}
