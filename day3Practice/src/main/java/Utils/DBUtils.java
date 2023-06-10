package Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {
private static Connection cn;

public static Connection openConnection() throws SQLException {
	String url="jdbc:mysql://localhost:3306/sss?createDatabaseIfNotExist=true&useSSL=false&allowPublicKeyRetrieval=true";
	cn=DriverManager.getConnection(url,"root","8007992007");
	
	System.out.println("Connection Established");
	
	return cn;
}
public static void closeConnection() throws SQLException {
	if(cn!=null) {
		cn.close();
		System.out.println("Connection closed...");
	}
}


}
