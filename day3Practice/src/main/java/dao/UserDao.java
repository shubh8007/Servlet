package dao;

import java.sql.Date;
import java.sql.SQLException;

import javax.servlet.ServletException;

import pojos.User;

public interface UserDao {
User authenticateUser(String email,String password) throws SQLException;
public User registerUser(String FirstName,String LastName,String email,String password,String dob) throws SQLException, ServletException;
}
