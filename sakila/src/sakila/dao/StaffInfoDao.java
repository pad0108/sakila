package sakila.dao;

import java.sql.*;
import sakila.query.*;
import sakila.vo.*;
import sakila.service.*;

public class StaffInfoDao {
	//관리자 정보를 불러오는 메소드
	public StaffInfo selectStaffInfo(Connection conn, StaffInfo staffInfo) throws Exception{
		//디버깅
		System.out.println("selectStaffInfo 실행 -------");
		
		StaffInfo returnStaffInfo = null;
		
		PreparedStatement stmt = conn.prepareStatement(StaffInfoQuery.SELECT_STAFF_INFO);
		stmt.setInt(1, staffInfo.getStaffId());
		ResultSet rs = stmt.executeQuery();
		
		if(rs.next()) {
			returnStaffInfo = new StaffInfo();
			
			returnStaffInfo.setAddress(rs.getString("staff.username"));
			returnStaffInfo.setCity(rs.getString("staff_list.city"));
			returnStaffInfo.setCountry(rs.getString("staff_list.country"));
			returnStaffInfo.setEmail(rs.getString("staff.email"));
			returnStaffInfo.setFirstName(rs.getString("staff.firs_tname"));
			returnStaffInfo.setLastName(rs.getString("staff.last_name"));
			returnStaffInfo.setPhone(rs.getInt("staff_list.phone"));
			returnStaffInfo.setUserName(rs.getString("staff.username"));
		}
		
		return returnStaffInfo;
	}
}
