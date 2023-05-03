package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.KhachHang;
import entity.Xe;
import interfaces.iXe;
import utilities.ProcessDate;

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
				String soLuongKho_string = rs.getString("soLuongKho");
				double soLuongKho = Double.parseDouble(soLuongKho_string);
				String soLuongBan_string = rs.getString("soLuongBan");
				double soLuongBan = Double.parseDouble(soLuongBan_string);
				String imagePath = rs.getString("imagePath");
				
				temp = new Xe(maXe, tenXe, loaiXe, nuocSX, soPK, soKhung, soSuon, mauXe, giaXe, soLuongKho, soLuongBan, imagePath);
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
		ArrayList<Xe> listXe = new ArrayList<Xe>();
		Connection conn = ConnectDB.getConnection();
		String query = "SELECT * FROM Xe WHERE maXe LIKE CONCAT('%', ?, '%') OR tenXe LIKE CONCAT('%', ?, '%') OR nuocSX LIKE CONCAT('%', ?, '%') OR soKhung LIKE CONCAT('%', ?, '%') OR soSuon LIKE CONCAT('%', ?, '%') OR mauXe LIKE CONCAT('%', ?, '%') OR soPk=? OR giaXe=?";
		try {
			PreparedStatement pstm = conn.prepareStatement(query);
			pstm.setString(1, keywords);
			pstm.setString(2, keywords);
			pstm.setString(3, keywords);
			pstm.setString(4, keywords);
			pstm.setString(5, keywords);
			pstm.setString(6, keywords);
			pstm.setString(7, keywords);
			pstm.setString(8, keywords);
			pstm.setString(9, keywords);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
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
					String soLuongKho_string = rs.getString("soLuongKho");
					double soLuongKho = Double.parseDouble(soLuongKho_string);
					String soLuongBan_string = rs.getString("soLuongBan");
					double soLuongBan = Double.parseDouble(soLuongBan_string);
					String imagePath = rs.getString("imagePath");
				 try {
					 temp = new Xe(maXe, tenXe, loaiXe, nuocSX, soPK, soKhung, soSuon, mauXe, giaXe, soLuongKho, soLuongBan, imagePath);
					 listXe.add(temp);
				 }catch (Exception e) {
					// TODO: handle exception
				}
			}
			return listXe;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public boolean editXe(Xe xeCanSua) {
		
		boolean result = false;
		Connection conn = ConnectDB.getConnection();
		
		String query = "UPDATE Xe SET tenKH = ?, loaiXe = ?, nuocSX = ?, soPK = ?, soKhung = ?, soSuon = ?, mauXe = ?, giaXe = ?, imagePath = ?    WHERE maXe = ?";
		try {

			PreparedStatement prestm = conn.prepareStatement(query);
			
			prestm.setString(1, xeCanSua.getTenXe());
			prestm.setString(2, xeCanSua.getLoaiXe());
			prestm.setString(3, xeCanSua.getNuocSX());
			prestm.setDouble(4, xeCanSua.getSoPK());
			prestm.setString(5, xeCanSua.getSoKhung());
			prestm.setString(6, xeCanSua.getSoSuon());
			prestm.setString(7, xeCanSua.getMauXe());
			prestm.setDouble(8, xeCanSua.getGiaXe());
			prestm.setString(9, xeCanSua.getImagePath());
			prestm.setString(10, xeCanSua.getMaXe());

			return (prestm.executeUpdate() > 0) ? true : false;
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		return result;
	}
	
	public int totalXe() {
		
		try {
			Connection conn = ConnectDB.getConnection();
			String query = "SELECT Count(*) AS soLuong FROM Xe";
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(query);
			return rs.getInt("soLuong");
		} catch (Exception e) {
			// TODO: handle exception
		}
		return -1;
		
	}
	
	@Override
	public boolean addXe(Xe xe) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		int n =0;
//		try {
//			statement = con.prepareStatement("insert into" + " Xe values(?,?,?,?,?,?,?,?,?,?,?,?)");
//			statement.setString(1, xe.getMaXe());
//			statement.setString(2,nv.getHo());
//			statement.setString(3,nv.getTen());
//			statement.setInt(4, nv.getTuoi());
//			statement.setBoolean(5, nv.isPhai());
//			statement.setString(6, nv.getPhong().getMaPhong());
//			statement.setFloat(7, nv.getTienLuong());
//			n = statement.executeUpdate();
//		} catch (Exception e) {
//			e.printStackTrace();
//			// TODO: handle exception
//		
//		}
		return n>0;
	}
	
	@Override
	public boolean deleteXe(Xe xe) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
