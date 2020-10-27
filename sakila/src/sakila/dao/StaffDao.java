package sakila.dao;

import java.sql.*;

import sakila.query.StaffQuery;
import sakila.vo.Staff;

public class StaffDao {
	//로그인하기 위해 아이디와 패스워드를 받는 메소드
	public Staff selectStaffByKey(Connection conn,Staff staff) throws Exception {
		Staff returnStaff = null;
		
		System.out.println(staff.getEmail() +"staffDao에서 ID 확인 -----------------");
		System.out.println(staff.getPassword() +"staffDao에서 pw 확인 -----------------");
		
		PreparedStatement stmt = conn.prepareStatement(StaffQuery.SELECT_STAFF_BY_KEY);
		stmt.setString(1, staff.getEmail());
		stmt.setString(2, staff.getPassword());
		
		
		ResultSet rs = stmt.executeQuery();
		if(rs.next()) {
			returnStaff = new Staff();

			returnStaff.setEmail(rs.getString("email"));
			returnStaff.setUserName(rs.getString("username"));
			returnStaff.setStoreId(rs.getInt("store_id"));
		}
				
		return returnStaff;
	}
}

