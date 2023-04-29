package application;

import java.io.IOException;

import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.*;

public class Ctrl_Login {
	@FXML
	private TextField txtUsername;

	@FXML
	private PasswordField txtPassword;
	
	@FXML
	private Button btnLogin;
	
	@FXML
	private void checkLogin() {
		
		if (txtUsername.getText().equals("admin") && txtPassword.getText().equals("admin")) {
			 Stage stageTheLabelBelongs = (Stage) txtUsername.getScene().getWindow();
			 BorderPane root;
			try {
				root = (BorderPane)FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
				Scene scene = new Scene(root,1300, 750);
				stageTheLabelBelongs.setScene(scene);
				stageTheLabelBelongs.centerOnScreen();

				
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if (txtUsername.getText().equals("ql001") && txtPassword.getText().equals("ql001")) {
			 Stage stageTheLabelBelongs = (Stage) txtUsername.getScene().getWindow();
			 BorderPane root;
			try {
				root = (BorderPane)FXMLLoader.load(getClass().getResource("QuanLi.fxml"));
				Scene scene = new Scene(root,1300, 750);
				stageTheLabelBelongs.setScene(scene);
				stageTheLabelBelongs.centerOnScreen();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			Alert noti = new Alert(Alert.AlertType.ERROR);
			noti.setHeaderText("Sai tài khoản hoặc mật khẩu!");
			noti.setTitle("Đăng nhập thất bại");
			noti.setContentText("Nếu đã quên mật khẩu, hãy liên hệ với quản trị viên hệ thống nhé!");
			noti.show();
		}
	}
}