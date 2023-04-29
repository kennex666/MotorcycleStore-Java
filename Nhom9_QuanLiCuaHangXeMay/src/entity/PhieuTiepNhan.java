package entity;

public class PhieuTiepNhan {
	private int ID;
	private int XeID;
	private int PhieuSuaChuaID;
	
	public PhieuTiepNhan() {
		super();
	}

	public PhieuTiepNhan(int iD, int xeID, int phieuSuaChuaID) {
		super();
		ID = iD;
		XeID = xeID;
		PhieuSuaChuaID = phieuSuaChuaID;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public int getXeID() {
		return XeID;
	}

	public void setXeID(int xeID) {
		XeID = xeID;
	}

	public int getPhieuSuaChuaID() {
		return PhieuSuaChuaID;
	}

	public void setPhieuSuaChuaID(int phieuSuaChuaID) {
		PhieuSuaChuaID = phieuSuaChuaID;
	}

	@Override
	public String toString() {
		return "PhieuTiepNhan [ID=" + ID + ", XeID=" + XeID + ", PhieuSuaChuaID=" + PhieuSuaChuaID + "]";
	}
	

}
