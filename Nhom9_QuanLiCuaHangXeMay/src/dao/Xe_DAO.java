package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.KhachHang;
import entity.NhaCungCap;
import entity.Xe;
import interfaces.IXe;
import utilities.ProcessDate;

public class Xe_DAO implements IXe {

	Connection con = ConnectDB.getConnection();

	@Override
	public ArrayList<Xe> getAllXe() throws Exception {
		ArrayList<Xe> list = new ArrayList<>();
		String query = "Select * from Xe x JOIN NhaCungCap ncc ON x.Mancc = ncc.mancc";
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

				NhaCungCap ncc = new NhaCungCap(maNCC, results.getString("ten"));

				Xe xe = new Xe(maXe, tenXe, loaiXe, nuocSX, soPK, soKhung, soSuon, mauXe, giaXe, imgPath, ncc,
						soLuongKho, soLuongBan);
				list.add(xe);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public ArrayList<Xe> findXe(String keywords) {
		ArrayList<Xe> listXe = new ArrayList<Xe>();
		Connection conn = ConnectDB.getConnection();
		String query = "SELECT * FROM Xe x JOIN NhaCungCap ncc ON x.Mancc = ncc.mancc WHERE maXe LIKE CONCAT('%', ?, '%') OR tenXe LIKE CONCAT('%', ?, '%') OR nuocSX LIKE CONCAT('%', ?, '%') OR soKhung LIKE CONCAT('%', ?, '%') OR soSuon LIKE CONCAT('%', ?, '%') OR mauXe LIKE CONCAT('%', ?, '%') OR soPk=? OR gia=?";
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
				int soLuongKho = Integer.parseInt(soLuongKho_string);
				String soLuongBan_string = rs.getString("soLuongBan");
				int soLuongBan = Integer.parseInt(soLuongBan_string);
				String imagePath = rs.getString("imagePath");
				String maNcc = rs.getString("mancc");
				NhaCungCap ncc = new NhaCungCap(maNcc, rs.getString("ten"));
				try {
					temp = new Xe(maXe, tenXe, loaiXe, nuocSX, soPK, soKhung, soSuon, mauXe, giaXe, imagePath, ncc,
							soLuongKho, soLuongBan);
					listXe.add(temp);
				} catch (Exception e) {
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

		String query = "UPDATE Xe SET tenXe = ?, loaiXe = ?, nuocSX = ?, soPK = ?, soKhung = ?, soSuon = ?, mauXe = ?, gia = ?, imgPath = ?,soluongkho=?,soluongban=?,mancc=?    WHERE maXe = ?";
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
			prestm.setInt(10, xeCanSua.getSoLuongKho());
			prestm.setInt(11, xeCanSua.getSoLuongBan());
			prestm.setString(12, xeCanSua.getNcc().getMaNCC());
			prestm.setString(13, xeCanSua.getMaXe());
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
			System.out.println("Lỗi khi cập nhật xe: " + e.getMessage());
		}
		return -1;

	}

	@Override
	public boolean addXe(Xe xe) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		String query = "insert into Xe values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		int n = 0;
		try {
			statement = con.prepareStatement(query);
			statement.setString(1, xe.getMaXe());
			statement.setString(2, xe.getNcc().getMaNCC());
			statement.setString(3, xe.getTenXe());
			statement.setString(4, xe.getLoaiXe());
			statement.setString(5, xe.getNuocSX());
			statement.setDouble(6, xe.getSoPK());
			statement.setString(7, xe.getSoKhung());
			statement.setString(8, xe.getSoSuon());
			statement.setString(9, xe.getMauXe());
			statement.setDouble(10, xe.getGiaXe());
			statement.setString(11, xe.getImagePath());
			statement.setInt(12, xe.getSoLuongKho());
			statement.setInt(13, xe.getSoLuongBan());
			n = statement.executeUpdate();
			System.out.println("Load DUoc");

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception

		}
		return n > 0;
	}

	@Override
	public boolean deleteXe(Xe xe) {
		String query = "DELETE FROM Xe WHERE maXe = ?";

		try {
			PreparedStatement statement = con.prepareStatement(query);
			statement.setString(1, xe.getMaXe());
			return statement.executeUpdate() > 0;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
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
			if (results.next())
				return results.getString("TenXe");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}