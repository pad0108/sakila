package sakila.util;

import java.sql.*;

public class DBUtil {
	//DB�� �����ϴ� �޼ҵ�
	public static Connection getConnection() throws Exception{
		final String DB_URL = "jdbc:mariadb://localhost:3306/sakila";
		final String DB_USER = "root";
		final String DB_PASSWORD = "java1004";
		
		//DB ���� �Ǵ��� Ȯ��
		System.out.println("-----���� Ȯ��-----");
		
		final Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
		return conn;	
	}
}
