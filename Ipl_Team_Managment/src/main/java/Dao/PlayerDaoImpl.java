package Dao;

import static utils.DBconnection.openConnection;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;

import static utils.DBconnection.closeConnection;
import pojo.Player;
import static utils.Validations.validateAge;
public class PlayerDaoImpl implements PlayerDao {
private Connection cn;
private static PreparedStatement pst1;
public PlayerDaoImpl() throws SQLException {
	cn=openConnection();
	pst1=cn.prepareStatement("insert into player values(default,?,?,?,?,?)");
}
	
	@Override
	public Player authenticatePlayer(String playername, String dob, int wickets, double batting_avg,
			int teamid) throws SQLException {
		
		pst1.setString(1, playername);
		pst1.setString(2,dob);
	Date d=	Date.valueOf(dob);
		pst1.setInt(3, wickets);
		pst1.setDouble(4,batting_avg);
		pst1.setInt(5,teamid);
		int result=pst1.executeUpdate();
		if(result==1) {
			return new Player(10, playername, d, wickets, batting_avg, teamid);
		}
		
		 throw new SQLException("invalid details....");
	}
	
	public static void cleanUp() throws SQLException {
		if(pst1!=null) {
			pst1.close();
			closeConnection();
		}
}

}
