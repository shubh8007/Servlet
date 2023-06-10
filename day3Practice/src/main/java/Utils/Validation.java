package Utils;

import java.rmi.ServerException;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;

import javax.servlet.ServletException;

import pojos.User;

public class Validation {
	
	public static Date validateAge(String dob) throws SQLException {
		
		LocalDate newdate=LocalDate.parse(dob);
		
		int years=Period.between(newdate, LocalDate.now()).getYears();
		
		Date d1=Date.valueOf(newdate);
		if(years<=21)
			throw new SQLException("Invalid Age...!");
		
		
		return d1;
		
	}

}
