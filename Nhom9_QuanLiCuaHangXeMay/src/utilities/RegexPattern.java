package utilities;

import java.time.LocalDate;

public class RegexPattern {
	public static final String HOTEN = "^[A-ZÀÁẠẢÃÂẦẤẬẨẪĂẰẮẶẲẴÈÉẸẺẼÊỀẾỆỂỄÌÍỊỈĨÒÓỌỎÕÔỒỐỘỔỖƠỜỚỢỞỠÙÚỤỦŨƯỪỨỰỬỮỲÝỴỶỸĐ][a-zàáạảãâầấậẩẫăằắặẳẵèéẹẻẽêềếệểễìíịỉĩòóọỏõôồốộổỗơờớợởỡùúụủũưừứựửữỳýỵỷỹđ]*(?:[ ][A-ZÀÁẠẢÃÂẦẤẬẨẪĂẰẮẶẲẴÈÉẸẺẼÊỀẾỆỂỄÌÍỊỈĨÒÓỌỎÕÔỒỐỘỔỖƠỜỚỢỞỠÙÚỤỦŨƯỪỨỰỬỮỲÝỴỶỸĐ][a-zàáạảãâầấậẩẫăằắặẳẵèéẹẻẽêềếệểễìíịỉĩòóọỏõôồốộổỗơờớợởỡùúụủũưừứựửữỳýỵỷỹđ]*)*$";

	public static final String SDTVN = "^[0][\\d]{9}$";
	
	public static final String EMAIL = "^(([A-Za-z0-9]+)(([\\.]?)([A-Za-z0-9]+))+)(@)(([A-Za-z0-9]+\\.)([A-Za-z0-9]+))+$";
	
	public static String getRegexCCCD(LocalDate dob, boolean gioiTinh) {
		String regex = "";
		int maTheKiVaGioiTinh = (((dob.getYear() / 100) + 1) % 20) * 2 + (gioiTinh ? 0 : 1);
		String maNamSinh = ((dob.getYear() / 10) % 10 )+ "" + (dob.getYear() % 10) ;
		regex = "^(([\\d]{3}(" + maTheKiVaGioiTinh +")(" + maNamSinh +")(\\d{6}))|([\\d]{9}))$";
		System.out.println(regex);
		return regex;
	}
}