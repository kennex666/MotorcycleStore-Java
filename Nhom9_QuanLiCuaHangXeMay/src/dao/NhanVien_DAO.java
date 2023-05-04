package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.ChucVu;
import entity.NhanVien;
import entity.PhongBan;
import interfaces.INhanVien;
import utilities.ProcessDate;

public class NhanVien_DAO implements INhanVien{

	@Override
	public ArrayList<NhanVien> findEmployee(String keywords) {
		// TODO Auto-generated method stub// TODO Auto-generated method stub
		ArrayList<NhanVien> listNhanVien = new ArrayList<NhanVien>();
		Connection conn = ConnectDB.getConnection();
		String query = "SELECT * FROM NhanVien WHERE maNV LIKE CONCAT('%', ?, '%') OR tennv LIKE CONCAT('%', ?, '%') OR sdt LIKE CONCAT('%', ?, '%') OR soCCCD LIKE CONCAT('%', ?, '%') OR email LIKE CONCAT('%', ?, '%')";
		try {
			PreparedStatement pstm = conn.prepareStatement(query);
			pstm.setString(1, keywords);
			pstm.setString(2, keywords);
			pstm.setString(3, keywords);
			pstm.setString(4, keywords);
			pstm.setString(5, keywords);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				 NhanVien temp;
				 String manv = rs.getString("MaNV");
				 PhongBan phongBan = null;
				 ChucVu chucVu = null;
				 try {
					phongBan = new PhongBan(rs.getInt("MaPB"));
					chucVu = new ChucVu(rs.getInt("MaCV"));
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				 String tennv = rs.getString("HoTenNV");
				 LocalDate ngaySinh = ProcessDate.date2LocalDate(rs.getDate("ngaySinh"));
				 String SDT = rs.getString("SDT");
				 String soCCCD = rs.getString("soCCCD");
				 String diaChi = rs.getString("diaChi");
				 String email = rs.getString("email");
				 boolean gt = rs.getBoolean("gioiTinh");
				 String trinhDo = rs.getString("TrinhDoHocVan");
				 String bacTho = rs.getString("BacTho");
				 try {
					 temp = new NhanVien(manv, tennv, diaChi, SDT, soCCCD, gt, ngaySinh, email, trinhDo, bacTho, chucVu, phongBan);
					 listNhanVien.add(temp);
				 }catch (Exception e) {
					// TODO: handle exception
				}
			}
			return listNhanVien;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	@Override
	public ArrayList<NhanVien> getAllEmployees() {
		// TODO Auto-generated method stub
		ArrayList<NhanVien> listNhanVien = new ArrayList<NhanVien>();
		Connection conn = ConnectDB.getConnection();
		String query = "SELECT * FROM NhanVien";
		try {
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(query);
			while (rs.next()) {
				 NhanVien temp;
				 String manv = rs.getString("MaNV");
				 PhongBan phongBan = null;
				 ChucVu chucVu = null;
				 try {
					phongBan = new PhongBan(rs.getInt("MaPB"));
					chucVu = new ChucVu(rs.getInt("MaCV"));
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				 String tennv = rs.getString("HoTenNV");
				 LocalDate ngaySinh = ProcessDate.date2LocalDate(rs.getDate("ngaySinh"));
				 String SDT = rs.getString("SDT");
				 String soCCCD = rs.getString("soCCCD");
				 String diaChi = rs.getString("diaChi");
				 String email = rs.getString("email");
				 boolean gt = rs.getBoolean("gioiTinh");
				 String trinhDo = rs.getString("TrinhDoHocVan");
				 String bacTho = rs.getString("BacTho");
				 try {
					 temp = new NhanVien(manv, tennv, diaChi, SDT, soCCCD, gt, ngaySinh, email, trinhDo, bacTho, chucVu, phongBan);
					 listNhanVien.add(temp);
				 }catch (Exception e) {
					// TODO: handle exception
				}
			}
			return listNhanVien;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean editEmployee(NhanVien nv) {
		boolean result = false;
		Connection conn = ConnectDB.getConnection();
		
		String query = "UPDATE NhanVien SET tennv = ?, diaChi = ?, SDT = ?, soCCCD = ?, gioiTinh = ?, ngaySinh = ?, email = ? WHERE manv = ?";
		try {

			PreparedStatement prestm = conn.prepareStatement(query);
			
			prestm.setString(1, nv.getTenNhanVien());
			prestm.setString(2, nv.getDiaChi());
			prestm.setString(3, nv.getSoDT());
			prestm.setString(4, nv.getSoCCCD());
			prestm.setBoolean(5, nv.isGioiTinh());
			prestm.setDate(6, ProcessDate.localDate2Date(nv.getNgaySinh()));
			prestm.setString(7, nv.getEmail());
			prestm.setString(8, nv.getMaNhanVien());

			return (prestm.executeUpdate() > 0) ? true : false;
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		return result;
	}
	
	@Override
	public int totalEmployees() {
		// TODO Auto-generated method stub
		try {
			Connection conn = ConnectDB.getConnection();
			String query = "SELECT Count(*) AS soLuong FROM NhanVien";
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(query);
			if (rs.next())
				return rs.getInt("soLuong");
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}

		return -1;
	}
	
	public boolean addEmployee(NhanVien nv) {
		boolean result = false;
		Connection conn = ConnectDB.getConnection();
		
		String query = "INSERT INTO NhanVien (manv, tennv, diaChi, SDT, soCCCD, gioiTinh, ngaySinh, email) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		try {

			PreparedStatement prestm = conn.prepareStatement(query);

			prestm.setString(1, nv.getMaNhanVien());
			prestm.setString(2, nv.getTenNhanVien());
			prestm.setString(3, nv.getDiaChi());
			prestm.setString(4, nv.getSoDT());
			prestm.setString(5, nv.getSoCCCD());
			prestm.setBoolean(6, nv.isGioiTinh());
			prestm.setDate(7, ProcessDate.localDate2Date(nv.getNgaySinh()));
			prestm.setString(8, nv.getEmail());

			return (prestm.executeUpdate() > 0) ? true : false;
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		return result;
	}
	
	@Override
	public boolean deleteEmployee(NhanVien nv) {
		boolean result = false;
		Connection conn = ConnectDB.getConnection();
		
		String query = "DELETE FROM NhanVien WHERE manv = ?";
		try {

			PreparedStatement prestm = conn.prepareStatement(query);
			prestm.setString(1, nv.getMaNhanVien());
			return (prestm.executeUpdate() > 0) ? true : false;
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return result;
	}
	
	public NhanVien_DAO() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "NhanVien_DAO []";
	}

}
