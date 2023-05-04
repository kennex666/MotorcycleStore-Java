package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.NhaCungCap;
import entity.Xe;
import interfaces.INhaCungCap;

public class NhaCungCap_DAO implements INhaCungCap {

	Connection con = ConnectDB.getConnection(); 
	@Override
	public String getTenByMa(String maNCC) {
		// TODO Auto-generated method stub
		String query = "SELECT * FROM NhaCungCap WHERE MaNCC = '" + maNCC + "'";

		Statement stm;
		try {
			stm = con.createStatement();
			ResultSet results = stm.executeQuery(query);
			if (results.next()) {
				return results.getString("Ten");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public ArrayList<NhaCungCap> getAllNCC() {
		// TODO Auto-generated method stub
		ArrayList<NhaCungCap> list = new ArrayList<>();
		String query = "SELECT * FROM NhaCungCap";
		Statement stm;
		try {
			stm = con.createStatement();
			ResultSet results = stm.executeQuery(query);
			while (results.next()) {
				String maNCC = results.getString("MaNCC");
				String tenNCC = results.getString("Ten");
				NhaCungCap ncc = new NhaCungCap(maNCC, tenNCC);
				list.add(ncc);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

}
