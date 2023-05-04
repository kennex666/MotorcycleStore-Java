package utilities;

import java.util.Optional;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;

public class PopupNotify {
	public static void showErrorField(String title, String headerText, String contentText) {
		Alert noti = new Alert(Alert.AlertType.ERROR);
		noti.setHeaderText(headerText);
		noti.setTitle(title);
		noti.setContentText(contentText);
		noti.show();
	}
	
	public static boolean regexValidNotification(String data, String partern, String title, String headerText, String contentText) {
		if (data.matches(partern))
			return true;
		else {
			Alert noti = new Alert(Alert.AlertType.ERROR);
			noti.setHeaderText(headerText);
			noti.setTitle(title);
			noti.setContentText(contentText);
			noti.show();
			return false;
		}
	}
	
	public static void successNotify(String title, String headerText, String contentText) {
		Alert noti = new Alert(Alert.AlertType.INFORMATION);
		noti.setHeaderText(headerText);
		noti.setTitle(title);
		noti.setContentText(contentText);
		noti.show();
	}
	
	public static boolean confirmNotification(String title, String headerText, String contentText) {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle(title);
		alert.setHeaderText(headerText);
		alert.setContentText(contentText);

		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == ButtonType.OK){
		    // ... user chose OK
			return true;
		}
		return false;
	}
}