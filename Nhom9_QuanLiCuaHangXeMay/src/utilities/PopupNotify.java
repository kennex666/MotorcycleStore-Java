package utilities;

import javafx.scene.control.Alert;

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
}
