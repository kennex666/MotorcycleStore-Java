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
}
