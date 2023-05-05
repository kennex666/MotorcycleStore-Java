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
import entity.KhachHang;
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
		String query = "SELECT * FROM NhanVien nv JOIN PhongBan pb ON nv.MaPB = pb.MaPB JOIN ChucVu cv ON cv.MaCV = nv.MaCV WHERE maNV LIKE CONCAT('%', ?, '%') OR HoTenNV LIKE CONCAT('%', ?, '%') OR sdt LIKE CONCAT('%', ?, '%') OR soCCCD LIKE CONCAT('%', ?, '%') OR email LIKE CONCAT('%', ?, '%')";
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
					phongBan = new PhongBan(rs.getInt("MaPB"), rs.getString("tenPB"));
					chucVu = new ChucVu(rs.getInt("MaCV"), rs.getString("tenCV"));
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
		String query = "SELECT * FROM NhanVien nv JOIN PhongBan pb ON nv.MaPB = pb.MaPB JOIN ChucVu cv ON cv.MaCV = nv.MaCV";
		try {
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(query);
			while (rs.next()) {
				 NhanVien temp;
				 String manv = rs.getString("MaNV");
				 PhongBan phongBan = null;
				 ChucVu chucVu = null;
				 try {
					phongBan = new PhongBan(rs.getInt("MaPB"), rs.getString("tenPB"));
					chucVu = new ChucVu(rs.getInt("MaCV"), rs.getString("tenCV"));
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
		
		String query = "UPDATE NhanVien SET HoTenNV = ?, DiaChi = ?, SDT = ?, soCCCD = ?, gioiTinh = ?, ngaySinh = ?, email = ?, maPB = ?, maCV = ?, trinhDoHocVan = ?, bacTho = ? WHERE MaNV = ?";
		try {

			PreparedStatement prestm = conn.prepareStatement(query);
			
			prestm.setString(1, nv.getTenNhanVien());
			prestm.setString(2, nv.getDiaChi());
			prestm.setString(3, nv.getSoDT());
			prestm.setString(4, nv.getSoCCCD());
			prestm.setBoolean(5, nv.isGioiTinh());
			prestm.setDate(6, ProcessDate.localDate2Date(nv.getNgaySinh()));
			prestm.setString(7, nv.getEmail());
			prestm.setInt(8, nv.getPhongBan().getId());
			prestm.setInt(9, nv.getChucVu().getMaChucVu());
			prestm.setString(10, nv.getTrinhDo());
			prestm.setString(11, nv.getBacTho());
			prestm.setString(12, nv.getMaNhanVien());

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
		
		String query = "INSERT INTO NhanVien (hoTenNV, diaChi, SDT, soCCCD, gioiTinh, ngaySinh, email, maPB, maCV, trinhDoHocVan, bacTho, manv) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {

			PreparedStatement prestm = conn.prepareStatement(query);
			
			prestm.setString(1, nv.getTenNhanVien());
			prestm.setString(2, nv.getDiaChi());
			prestm.setString(3, nv.getSoDT());
			prestm.setString(4, nv.getSoCCCD());
			prestm.setBoolean(5, nv.isGioiTinh());
			prestm.setDate(6, ProcessDate.localDate2Date(nv.getNgaySinh()));
			prestm.setString(7, nv.getEmail());
			prestm.setInt(8, nv.getPhongBan().getId());
			prestm.setInt(9, nv.getChucVu().getMaChucVu());
			prestm.setString(10, nv.getTrinhDo());
			prestm.setString(11, nv.getBacTho());
			prestm.setString(12, nv.getMaNhanVien());

			return (prestm.executeUpdate() > 0) ? true : false;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
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
	
	@Override
	public String getTenByMaNV(String maNV) {
		
		Connection conn = ConnectDB.getConnection();
		String query = "Select * from NhanVien WHERE MaNV = '" + maNV + "'";
		try {
			Statement stm = conn.createStatement();
			ResultSet results = stm.executeQuery(query);
			if (results.next())
				return results.getString("HoTenNV");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public ArrayList<NhanVien> findEmployeeAdvanced(Object[] obj) {
		// TODO Auto-generated method stub
		String ten = (String) obj[0];
		boolean isTimNam = (boolean) obj[1];
		boolean isTimNu = (boolean) obj[2];
		int tuTuoi = (int) obj[3];
		int denTuoi = (int) obj[4];
		int thangSinh = (int) obj[5];
		int maPb = (int) obj[6], maCV = (int) obj[7];
		ArrayList<NhanVien> listNv = new ArrayList<NhanVien>();
		Connection conn = ConnectDB.getConnection();
		String query = "SELECT * FROM NhanVien nv JOIN PhongBan pb ON nv.MaPB = pb.MaPB JOIN ChucVu cv ON cv.MaCV = nv.MaCV WHERE hoTenNV LIKE CONCAT('%', ?, '%') ";


		
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
			query += "AND MONTH(ngaySinh) = " + thangSinh + " ";
		}
		
		if (maCV != 0) {
			query += "AND nv.maCV = '" + maCV + "' ";
		}
		if (maPb != 0) {
			query += "AND nv.maPB = '" + maPb + "' ";
		}

		try {
			PreparedStatement pstm = conn.prepareStatement(query);
			pstm.setString(1, ten);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				NhanVien temp;
				 String manv = rs.getString("MaNV");
				 PhongBan phongBan = null;
				 ChucVu chucVu = null;
				 try {
					phongBan = new PhongBan(rs.getInt("MaPB"), rs.getString("tenPB"));
					chucVu = new ChucVu(rs.getInt("MaCV"), rs.getString("tenCV"));
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
					 listNv.add(temp);
				 }catch (Exception e) {
					// TODO: handle exception
				}
			}
			return listNv;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	
	public NhanVien_DAO() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "NhanVien_DAO []";
	}

}
