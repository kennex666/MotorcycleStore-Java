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
import interfaces.IKhachHang;
import utilities.ProcessDate;

public class KhachHang_DAO implements IKhachHang {
	Connection con = ConnectDB.getConnection(); 
	@Override
	public ArrayList<KhachHang> getAllKhachHang() throws Exception{
		ArrayList<KhachHang> list = new ArrayList<>();
		String query = "Select * from KhachHang";
		try {
			Statement stm = con.createStatement();
			ResultSet results = stm.executeQuery(query);
			while (results.next()) {
				String maKH = results.getString("MaKH");
				String tenKH = results.getString("TenKH");
				String diaChi = results.getString("DiaChi");
				String sdt = results.getString("SDT");
				String cccd = results.getString("SoCCCD");
				boolean gioiTinhString = results.getBoolean("GioiTinh");
				Date ngaySinh = results.getDate("NgaySinh");
				String email = results.getString("Email");

				KhachHang kh = new KhachHang(maKH, tenKH, diaChi, sdt, cccd, gioiTinhString, ngaySinh.toLocalDate(), email);
				list.add(kh);
			}
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}
	@Override
	public String getHoTenByMa(String maKH) {
		String query = "Select * from KhachHang WHERE MaKH = '" + maKH + "'";
		try {
			Statement stm = con.createStatement();
			ResultSet results = stm.executeQuery(query);
			if (results.next()) return results.getString("TenKH");
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public boolean addCustomer(KhachHang kHTTMoi) {
		boolean result = false;
		Connection conn = ConnectDB.getConnection();

		String query = "INSERT INTO KhachHang (maKH, tenKH, diaChi, SDT, soCCCD, gioiTinh, ngaySinh, email) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		try {

			PreparedStatement prestm = conn.prepareStatement(query);

			prestm.setString(1, kHTTMoi.getMaKhachHang());
			prestm.setString(2, kHTTMoi.getTenKhachHang());
			prestm.setString(3, kHTTMoi.getDiaChi());
			prestm.setString(4, kHTTMoi.getSoDT());
			prestm.setString(5, kHTTMoi.getSoCCCD());
			prestm.setBoolean(6, kHTTMoi.isGioiTinh());
			prestm.setDate(7, ProcessDate.localDate2Date(kHTTMoi.getNgaySinh()));
			prestm.setString(8, kHTTMoi.getEmail());

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
			if (rs.next())
				return rs.getInt("soLuong");
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}

		return -1;
	}
	@Override
	public ArrayList<KhachHang> findCustomers(String keywords) {
		// TODO Auto-generated method stub// TODO Auto-generated method stub
		ArrayList<KhachHang> listKhachHang = new ArrayList<KhachHang>();
		Connection conn = ConnectDB.getConnection();
		String query = "SELECT * FROM KhachHang WHERE MaKH LIKE CONCAT('%', ?, '%') OR TenKH LIKE CONCAT('%', ?, '%') OR SDT LIKE CONCAT('%', ?, '%') OR SoCCCD LIKE CONCAT('%', ?, '%') OR Email LIKE CONCAT('%', ?, '%')";
		try {
			PreparedStatement pstm = conn.prepareStatement(query);
			pstm.setString(1, keywords);
			pstm.setString(2, keywords);
			pstm.setString(3, keywords);
			pstm.setString(4, keywords);
			pstm.setString(5, keywords);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				KhachHang temp;
				String maKH = rs.getString("MaKH");
				String tenKH = rs.getString("TenKH");
				String diaChi = rs.getString("DiaChi");
				String SDT = rs.getString("SDT");
				String soCCCD = rs.getString("SoCCCD");
				boolean gt = rs.getBoolean("GioiTinh");
				String email = rs.getString("Email");
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
}
