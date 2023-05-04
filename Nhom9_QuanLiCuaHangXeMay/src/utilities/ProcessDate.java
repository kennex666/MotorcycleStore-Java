package utilities;

import java.sql.Date;
import java.time.LocalDate;

public class ProcessDate {
	public static LocalDate date2LocalDate(Date date) {
		return date.toLocalDate();
	}
	
	public static Date localDate2Date(LocalDate lcd) {
		return java.sql.Date.valueOf(lcd);
	}
	public static boolean greaterThanEquals(LocalDate x, int year) {
		if (x == null)
			return false;
		LocalDate ldNow = LocalDate.now();
		if (ldNow.getYear() - x.getYear() < year)
			return false;
		if (ldNow.getYear() - x.getYear() > year)
			return true;
			
		if (ldNow.getMonthValue() - x.getDayOfMonth() > 0)
			return true;
			
		if (ldNow.getMonthValue() - x.getDayOfMonth() < 0)
			return false;
			
		if (ldNow.getDayOfMonth() - x.getDayOfMonth() < 0)
			return false;
		
		return true;
	}
}