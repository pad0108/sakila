package sakila.dao;

import java.sql.*;

import sakila.query.StaffQuery;
import sakila.vo.Staff;

public class StaffDao {
	//로그인하기 위해 아이디와 패스워드를 받는 메소드
	public Staff selectStaffByKey(Connection conn,Staff staff) throws Exception {
		Staff returnStaff = null;
		
		System.out.println(staff.getStaffId() +"staffDao���� ID Ȯ�� -----------------");
		System.out.println(staff.getPassword() +"staffDao���� pw Ȯ�� -----------------");
		
		PreparedStatement stmt = conn.prepareStatement(StaffQuery.SELECT_STAFF_BY_KEY);
		stmt.setInt(1, staff.getStaffId());
		stmt.setString(2, staff.getPassword());
		
		
		ResultSet rs = stmt.executeQuery();
		if(rs.next()) {
			returnStaff = new Staff();
			returnStaff.setStaffId(rs.getInt("staff_id"));
			returnStaff.setUserName(rs.getString("userName"));
		}
				
		return returnStaff;
	}
}

