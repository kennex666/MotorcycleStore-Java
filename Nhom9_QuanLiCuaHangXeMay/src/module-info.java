module Nhom9_QuanLiCuaHangXeMay {
	requires javafx.controls;
	requires javafx.fxml;
	requires java.sql;
	requires java.base;

	
	opens application to javafx.graphics, javafx.fxml;
	
	opens entity to javafx.base;
}
