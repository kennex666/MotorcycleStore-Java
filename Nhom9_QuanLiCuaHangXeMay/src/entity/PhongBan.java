package entity;

import java.util.Objects;

public class PhongBan {
	private int id;
	private String tenPB;
	public PhongBan() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PhongBan(int id, String tenPB) throws Exception {
		super();
		setId(id);
		setTenPB(tenPB);
	}
	public PhongBan(int id) throws Exception {
		super();
		setId(id);
	}
	public int getId() {
		return id;
	}
	public void setId(int id) throws Exception {
		if (id<=0)
			throw new Exception("Đã có lỗi trong quá trình phát sinh ID phòng ban");
		this.id = id;
	}
	public String getTenPB() {
		return tenPB;
	}
	public void setTenPB(String tenPB) throws Exception {
		if (tenPB.trim()=="" || tenPB.isBlank() || tenPB.isEmpty())
			throw new Exception("Tên phòng ban là trường bắt buộc ");
		this.tenPB = tenPB;
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
		PhongBan other = (PhongBan) obj;
		return id == other.id;
	}
	@Override
	public String toString() {
		return "PhongBan [id=" + id + ", tenPB=" + tenPB + "]";
	}
	
	
}
