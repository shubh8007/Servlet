package utils;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;

public class Validations {
public static Date validateAge(String dob) throws SQLException {
	
	LocalDate date1=LocalDate.parse(dob);
	int years=Period.between(date1,LocalDate.now()).getYears();
	Date date=Date.valueOf(date1);
	if(years>22) 
		throw new SQLException("Invalid Age...");

	
	
	
	
	return date;
	
	
}
}
