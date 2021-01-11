package Ex02;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

public class ConvertDataTime {

	public static void main(String[] args) {
		
		Date date = new Date();
		
		System.out.println(date);
		
		System.out.println(toLocalDate(date));
		System.out.println(toLocalTime(date));
		System.out.println(toLocalDataTime(date));
		
		System.out.println();
		
		

	}
	
	public static LocalDate toLocalDate(Date date) {
		
		ZonedDateTime zonedDataTime =date.toInstant().atZone(ZoneId.systemDefault());
		return zonedDataTime.toLocalDate();
		
	}
	public static LocalTime toLocalTime(Date date) {
		
		ZonedDateTime zonedDateTime = date.toInstant().atZone(ZoneId.systemDefault());
		
		return zonedDateTime.toLocalTime();
	}
	
	public static LocalDateTime toLocalDataTime(Date date) {
		
		ZonedDateTime zonedDateTime = date.toInstant().atZone(ZoneId.systemDefault());
		
		return zonedDateTime.toLocalDateTime();
		
	}

}
