package Dao;

import java.sql.SQLException;
import java.util.Map;

import pojo.Player;
import pojo.Team;

public interface PlayerDao {
	Player authenticatePlayer(String playername,String dob,int wickets,double batting_avg,int teamid) throws SQLException;	
}
