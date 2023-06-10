package dao;

import static Utils.DBUtils.closeConnection;

import static Utils.DBUtils.openConnection;
import static Utils.Validation.validateAge;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.el.util.Validation;

import pojos.User;

public class UserDaoImpl implements UserDao {
	private Connection cn;
	private PreparedStatement pst1, pst2;

	public UserDaoImpl() throws SQLException {
		cn = openConnection();

		pst1 = cn.prepareStatement("select * from users where email=? and password=?");
		pst2 = cn.prepareStatement("insert into users values(Default,?,?,?,?,?,'0','voter')");
		System.out.println("run");
	}

	@Override
	public User authenticateUser(String email, String password) throws SQLException {
		pst1.setString(1, email);
		pst1.setString(2, password);

		try (ResultSet rst = pst1.executeQuery()) {

			if (rst.next()) {
				return new User(rst.getInt(1), rst.getString(2), rst.getString(3), email, password, rst.getDate(6),
						rst.getBoolean(7), rst.getString(8));
			}
			return null;
		}
	}

	public User registerUser(String FirstName, String LastName, String email, String password, String dob)
			throws SQLException {

		
		System.out.println("Hello shubhzz");
	
		Date Dob =validateAge(dob);
		pst2.setString(1, FirstName);
		pst2.setString(2, LastName);
		pst2.setString(3, email);
		pst2.setString(4, password);
		pst2.setDate(5, Dob);
		System.out.println("Hello shubhzz");
		int a = pst2.executeUpdate();
		if (a == 1) {
			System.out.println("User inserted");
		}

		return new User(10, FirstName, LastName, email, password, Dob, false, "voter");
	}

	public void claenUp() throws SQLException {
		if (pst2 != null) {
			pst2.close();
			closeConnection();
		}
	}
//		

}
