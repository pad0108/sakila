package sakila.util;

import java.sql.*;

public class DBUtil {
	//DB에 연결하는 메소드
	public static Connection getConnection() throws Exception{
		final String DB_URL = "jdbc:mariadb://localhost:3306/sakila";
		final String DB_USER = "root";
		final String DB_PASSWORD = "java1004";
		
		//DB 연결 되는지 확인
		System.out.println("-----연결확인-----");
		
		final Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
		return conn;	
	}
}
