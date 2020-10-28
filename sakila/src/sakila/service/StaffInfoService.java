package sakila.service;

import java.util.*;
import java.sql.*;

import sakila.dao.*;
import sakila.vo.*;
import sakila.util.*;


public class StaffInfoService {
	private StaffInfoDao staffInfoDao;
	
	public StaffInfo getStaffInfo(StaffInfo staffInfo) {
		StaffInfo returnStaffInfo = null;
		
		staffInfoDao = new StaffInfoDao();
		Connection conn = null;
		
		try {
			DBUtil dbUtil = new DBUtil();
			conn = dbUtil.getConnection(); // 데이터베이스 연결
			
			returnStaffInfo = staffInfoDao.selectStaffInfo(conn, staffInfo);
			
			conn.commit(); // 커밋
		} catch(Exception e) {
			try {
				conn.rollback(); //롤백
			} catch(SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			try {
				conn.close(); // DB 접속 끝냄
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return returnStaffInfo;
	}
}
