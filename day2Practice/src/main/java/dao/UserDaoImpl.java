package dao;

import static Utils.DBUtils.openConnection;
import static Utils.DBUtils.closeConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import pojos.User;
public class UserDaoImpl implements UserDao{
             private Connection cn;
             private PreparedStatement pst1;
             public UserDaoImpl() throws SQLException {
            	 cn=openConnection();
            	 
            	 pst1=cn.prepareStatement("select * from users where email=? and password=?");
            	 System.out.println("run");
             }
	@Override
	public User authenticateUser(String email, String password) throws SQLException {
		pst1.setString(1,email);
		pst1.setString(2, password);
		
		try(ResultSet rst=pst1.executeQuery()){
			
			if(rst.next()) {
				return new User(rst.getInt(1), rst.getString(2), rst.getString(3),email ,password, rst.getDate(6), rst.getBoolean(7), rst.getString(8));
			}
			return null;
		}
	}
		public void claenUp() throws SQLException {
			if(pst1!=null) {
				pst1.close();
			closeConnection();
			}
		}
	

}
