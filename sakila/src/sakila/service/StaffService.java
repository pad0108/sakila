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
			//���� Ȯ��
			System.out.println(conn + "connȮ��------");
			
			returnStaff = staffDao.selectStaffByKey(conn, staff);
			
			System.out.println(staff.getStaffId() + "staffId------");
			System.out.println(staff.getUserName() +"username-----");
			
			conn.commit(); // Ŀ��
		}catch(Exception e){ //Ŀ�� ���� �� ���� ó��
			e.printStackTrace();
			try { // �ѹ�
				conn.rollback();
			} catch(Exception e1){ //�ѹ� ���� �� ���� ó��
				e1.printStackTrace();
				
			}
		}finally{
			try {
				conn.close();
			}catch(Exception e) { //conn.close() ���н� ���� ó��
				e.printStackTrace();
			}
			
		}
		
		return returnStaff;
	}
}
