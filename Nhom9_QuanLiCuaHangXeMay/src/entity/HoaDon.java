package entity;

import java.util.Date;
import java.util.Objects;

public class HoaDon {
	private String id;
	private Date ngayLapHoaDon;
	public HoaDon() {
		super();
		// TODO Auto-generated constructor stub
	}
	public HoaDon(String id, Date ngayLapHoaDon) throws Exception {
		super();
		setId(id);
		this.ngayLapHoaDon = ngayLapHoaDon;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) throws Exception {
		if (id.trim()=="" || id.isBlank() || id.isEmpty())
			throw new Exception("Đã có lỗi trong quá trình phát sinh ID hóa đơn");
		this.id = id;
	}
	public Date getNgayLapHoaDon() {
		return ngayLapHoaDon;
	}
	public void setNgayLapHoaDon(Date ngayLapHoaDon) {
		this.ngayLapHoaDon = ngayLapHoaDon;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HoaDon other = (HoaDon) obj;
		return id == other.id;
	}
	@Override
	public String toString() {
		return "HoaDon [id=" + id + ", ngayLapHoaDon=" + ngayLapHoaDon + "]";
	}
	
	
	
}
