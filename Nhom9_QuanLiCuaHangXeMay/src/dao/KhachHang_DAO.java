package dao;

import java.sql.Connection;
import java.sql.Date;
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

public class KhachHang_DAO implements IKhachHang {

	@Override
	public ArrayList<KhachHang> getAllKhachHang() throws Exception {
		ArrayList<KhachHang> list = new ArrayList<>();
		String query = "Select * from KhachHang";
		Connection conn = ConnectDB.getConnection();

		try {
			Statement stm = conn.createStatement();
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

				KhachHang kh = new KhachHang(maKH, tenKH, diaChi, sdt, cccd, gioiTinhString, ngaySinh.toLocalDate(),
						email);
				list.add(kh);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public String getHoTenByMa(String maKH) {
		String query = "Select * from KhachHang WHERE MaKH = '" + maKH + "'";
		Connection conn = ConnectDB.getConnection();
		try {
			Statement stm = conn.createStatement();
			ResultSet results = stm.executeQuery(query);
			if (results.next())
				return results.getString("TenKH");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

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
			pstm.setString(5, keywords);
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
				} catch (Exception e) {
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
				} catch (Exception e) {
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
			if (rs.next())
				return rs.getInt("soLuong");
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}

		return -1;
	}

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
	public boolean deleteCustomer(KhachHang kh) {
		boolean result = false;
		Connection conn = ConnectDB.getConnection();

		String query = "DELETE FROM KhachHang WHERE maKH = ?";
		try {

			PreparedStatement prestm = conn.prepareStatement(query);
			prestm.setString(1, kh.getMaKhachHang());
			return (prestm.executeUpdate() > 0) ? true : false;
		} catch (Exception e) {
			// TODO: handle exception
		}

		return result;
	}
	
	@Override
	public ArrayList<KhachHang> findCustomersAdvanced(Object[] obj) {
		// TODO Auto-generated method stub
		String ten = (String) obj[0];
		boolean isTimNam = (boolean) obj[1];
		boolean isTimNu = (boolean) obj[2];
		int tuTuoi = (int) obj[3];
		int denTuoi = (int) obj[4];
		int thangSinh = (int) obj[5];
		ArrayList<KhachHang> listKhachHang = new ArrayList<KhachHang>();
		Connection conn = ConnectDB.getConnection();
		String query = "SELECT * FROM KhachHang WHERE tenKH LIKE CONCAT('%', ?, '%') ";


		
		if (!(isTimNu && isTimNam)) {
			if (isTimNam) {
				query += "AND gioiTinh = 1 ";
			}else {
				if (isTimNu == false && isTimNam == false) {
					query += "AND gioiTinh <> 0 AND gioiTinh <> 1 ";
				}else
					query += "AND gioiTinh = 0 ";
			}
		}

		if (tuTuoi != 0) {
			query += "AND (YEAR(GETDATE()) - YEAR(ngaySinh)) >= " + tuTuoi +" ";
		}
		if (denTuoi != 0) {
			query += "AND (YEAR(GETDATE()) - YEAR(ngaySinh)) <= " + denTuoi +" ";
		}

		if (thangSinh != 0) {
			query += "AND MONTH(ngaySinh) = " + thangSinh;
		}

		try {
			PreparedStatement pstm = conn.prepareStatement(query);
			pstm.setString(1, ten);
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
				} catch (Exception e) {
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

	public KhachHang_DAO() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "KhachHang_DAO []";
	}

}