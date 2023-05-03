package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.Xe;
import interfaces.iXe;

public class Xe_DAO implements iXe{

	@Override
	public ArrayList<Xe> getAllList() {
		// TODO Auto-generated method stub
		ArrayList<Xe> listXe = new ArrayList<>();
		Connection con = ConnectDB.getConnection();
		String query = "Select * from Xe";
		try {
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(query);
			while(rs.next()) {
				Xe temp;
				String maXe = rs.getString("maXe");
				String tenXe = rs.getString("tenXe");
				String loaiXe = rs.getString("loaiXe");
				String nuocSX = rs.getString("nuocSX");
				String soPK_string = rs.getString("soPK");
				double soPK = Double.parseDouble(soPK_string);
				String soKhung = rs.getString("soKhung");
				String soSuon = rs.getString("soSuon");
				String mauXe = rs.getString("mauXe");
				String giaXe_string = rs.getString("giaXe");
				double giaXe = Double.parseDouble(giaXe_string);
				String imagePath = rs.getString("imagePath");
				
				temp = new Xe(maXe, tenXe, loaiXe, nuocSX, soPK, soKhung, soSuon, mauXe, giaXe, imagePath);
				listXe.add(temp);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return listXe;
	}

	@Override
	public ArrayList<Xe> findXe(String keywords) {
		ArrayList<Xe> listxe = new ArrayList<Xe>();
		Connection con = ConnectDB.getConnection();
//		String query = "SELECT * FROM Xe WHERE maXe LIKE CONCAT('%',?,'%') OR tenXe LIKE CONCAT('%',?,'%') OR loaiXe LIKE CONCAT('%',?,'%') OR nuocSX LIKE CONCAT('%',?,'%') OR soPK=? OR soKhung LIKE CONCAT('%',?,'%') OR soSuon LIKE CONCAT('%',?,'%') OR mauXe LIKE CONCAT('%',?,'%') OR  giaXe=? "
		return null;
	}

}