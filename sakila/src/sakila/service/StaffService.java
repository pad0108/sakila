package sakila.service;

import java.sql.Connection;

import sakila.vo.Staff;
import sakila.dao.StaffDao;
import sakila.util.*;
public class StaffService {
	private StaffDao staffDao;
	public Staff getStaffByKey(Staff staff) {
		Staff returnStaff = null;
		
		Connection conn = null;
		
		staffDao = new StaffDao();
		
		try {
			conn = DBUtil.getConnection();
			staffDao = new StaffDao();
			//연결 확인
			System.out.println(conn + "conn확인------");
			
			returnStaff = staffDao.selectStaffByKey(conn, staff);
			
			System.out.println(staff.getStaffId() + "staffId------");
			System.out.println(staff.getUserName() +"username-----");
			
			conn.commit(); // 커밋
		}catch(Exception e){ //커밋 실패 시 예외 처리
			e.printStackTrace();
			try { // 롤백
				conn.rollback();
			} catch(Exception e1){ //롤백 실패 시 예외 처리
				e1.printStackTrace();
				
			}
		}finally{
			try {
				conn.close();
			}catch(Exception e) { //conn.close() 실패시 예외 처리
				e.printStackTrace();
			}
			
		}
		
		return returnStaff;
	}
}
