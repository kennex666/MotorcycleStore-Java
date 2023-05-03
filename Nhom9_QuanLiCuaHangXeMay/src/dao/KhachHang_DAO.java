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
import entity.KhachHang;
import interfaces.IKhachHang;
import utilities.ProcessDate;

public class KhachHang_DAO implements IKhachHang{
	@Override
	public ArrayList<KhachHang> findCustomers(String keywords) {
		// TODO Auto-generated method stub// TODO Auto-generated method stub
		ArrayList<KhachHang> listKhachHang = new ArrayList<KhachHang>();
		Connection conn = ConnectDB.getConnection();
		String query = "SELECT * FROM KhachHang WHERE maKH LIKE CONCAT('%', ?, '%') OR tenKH LIKE CONCAT('%', ?, '%') OR sdt LIKE CONCAT('%', ?, '%') OR soCCCD LIKE CONCAT('%', ?, '%') OR email LIKE CONCAT('%', ?, '%')";
		try {
			PreparedStatement pstm = conn.prepareStatement(query);
			pstm.setString(1, keywords);
			pstm.setString(2, keywords);
			pstm.setString(3, keywords);
			pstm.setString(4, keywords);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				 KhachHang temp;
				 String maKH = rs.getString("maKH");
				 String tenKH = rs.getString("tenKH");
				 String diaChi = rs.getString("diaChi");
				 String SDT = rs.getString("SDT");
				 String soCCCD = rs.getString("soCCCD");
				 boolean gt = rs.getBoolean("gioiTinh");
				 String email = rs.getString("email");
				 LocalDate ngaySinh = ProcessDate.date2LocalDate(rs.getDate("ngaySinh"));
				 try {
					 temp = new KhachHang(maKH, tenKH, diaChi, SDT, soCCCD, gt, ngaySinh, email);
					 listKhachHang.add(temp);
				 }catch (Exception e) {
					// TODO: handle exception
				}
			}
			return listKhachHang;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	@Override
	public ArrayList<KhachHang> getAllCustomers() {
		// TODO Auto-generated method stub
		ArrayList<KhachHang> listKhachHang = new ArrayList<KhachHang>();
		Connection conn = ConnectDB.getConnection();
		String query = "SELECT * FROM KhachHang";
		try {
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(query);
			while (rs.next()) {
				 KhachHang temp;
				 String maKH = rs.getString("maKH");
				 String tenKH = rs.getString("tenKH");
				 String diaChi = rs.getString("diaChi");
				 String SDT = rs.getString("SDT");
				 String soCCCD = rs.getString("soCCCD");
				 boolean gt = rs.getBoolean("gioiTinh");
				 LocalDate ngaySinh = ProcessDate.date2LocalDate(rs.getDate("ngaySinh"));
				 String email = rs.getString("email");
				 try {
					 temp = new KhachHang(maKH, tenKH, diaChi, SDT, soCCCD, gt, ngaySinh, email);
					 listKhachHang.add(temp);
				 }catch (Exception e) {
					// TODO: handle exception
				}
			}
			return listKhachHang;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean editCustomer(KhachHang kHTTMoi) {
		boolean result = false;
		Connection conn = ConnectDB.getConnection();
		
		String query = "UPDATE KhachHang SET tenKH = ?, diaChi = ?, SDT = ?, soCCCD = ?, gioiTinh = ?, ngaySinh = ?, email = ? WHERE maKH = ?";
		try {

			PreparedStatement prestm = conn.prepareStatement(query);
			
			prestm.setString(1, kHTTMoi.getTenKhachHang());
			prestm.setString(2, kHTTMoi.getDiaChi());
			prestm.setString(3, kHTTMoi.getSoDT());
			prestm.setString(4, kHTTMoi.getSoCCCD());
			prestm.setBoolean(5, kHTTMoi.isGioiTinh());
			prestm.setDate(6, ProcessDate.localDate2Date(kHTTMoi.getNgaySinh()));
			prestm.setString(7, kHTTMoi.getEmail());
			prestm.setString(8, kHTTMoi.getMaKhachHang());

			return (prestm.executeUpdate() > 0) ? true : false;
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		return result;
	}
	
	@Override
	public int totalCustomers() {
		// TODO Auto-generated method stub
		try {
			Connection conn = ConnectDB.getConnection();
			String query = "SELECT Count(*) AS soLuong FROM KhachHang";
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(query);
			return rs.getInt("soLuong");
		} catch (Exception e) {
			// TODO: handle exception
		}
		return -1;
	}
	
	public KhachHang_DAO() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "KhachHang_DAO []";
	}

}
