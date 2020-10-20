package sakila.service;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;

import sakila.vo.Stats;
import sakila.dao.StatsDao;
import sakila.util.DBUtil;
public class StatsService {
	private StatsDao statsDao;
	// calender�� ����Ͽ� ���� ��¥�� ���ϴ� �޵�
	private Stats getToday() {
		Calendar today = Calendar.getInstance();
		//simpleDateFormat�� ����Ͽ� ���ϴ� �������� ��¥ ���
		SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
		//today������ string���� ����
		String day = formater.format(today.getTime());

		// stats�� ���� ��¥ �߰�
		Stats stats = new Stats();
		stats.setDay(day);
		
		// �����
		System.out.println(stats.getDay() + "<--getToday() today");
		
		return stats;
	}
	//�湮�� �� ��ȸ�ϴ� �޼���
	public Map<String,Object> getStats() {
		Map<String, Object> map = null;
		statsDao = new StatsDao();
		Stats todayStats = new Stats();
		Connection conn = null;
		
		try {
			//DBUtil���� �ҷ���
			conn = DBUtil.getConnection();
			conn.setAutoCommit(false);//����Ŀ�� ��� X
			//�ߺ��Ǵ� �����̹Ƿ� getToday�� ������
			todayStats = getToday();
			//db���� ���� ��¥�� �ִ��� Ȯ��
			todayStats = statsDao.selectDay(conn, todayStats);
			int totalCnt = statsDao.selectTotalCnt(conn);
			// �����
			System.out.println(todayStats.getDay() + "<--getStats().todayStats Day");
			System.out.println(todayStats.getCount() + "<--getStats().todayStats Cnt");
			System.out.println(totalCnt + "<--getStats() totalCnt");		
			
			map = new HashMap<String, Object>();
			map.put("todayStats", todayStats);
			map.put("totalCnt", totalCnt);
			
			conn.commit();
		} catch(Exception e) { // DB���� , ������ ���� ��
			try {
				conn.rollback();
			} catch (SQLException e1) { // �ѹ� ���� ��
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) { // conn.close ���� ��
				e.printStackTrace();
			}
		}
		return map;
		//return 
	}
	public void countStats() { // �湮�� ���� 1 ���ϴ� �޼ҵ�
		Stats stats = new Stats();
		statsDao = new StatsDao();
		Connection conn = null;
		try {
			//DBUtil���� �ҷ���
			conn = DBUtil.getConnection();
			conn.setAutoCommit(false); // ���� Ŀ�� ��� X
			//�ߺ� �Ǵ� �����̹Ƿ� getToday ���
			stats = getToday();
			//db���� ���� ��¥�� �ִ��� Ȯ��
			stats = statsDao.selectDay(conn, stats);
			if(stats == null) {
				stats = getToday();
				// �湮�ڰ� ������ + 1				
				statsDao.insertStats(conn, stats);
			}else {
				// ù �湮�ڸ� ���� ����
				statsDao.updateStats(conn, stats);
			}
			conn.commit();
		}catch(Exception e) { //DB ����, �������� ���� �߻� ��
			try {
				conn.rollback();
			} catch(SQLException e1) { // �ѹ� ���� ��
				e1.getStackTrace();
			}
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch(SQLException e) { // conn.close() ���� ��
				e.printStackTrace();
			}
		}
	}
}
