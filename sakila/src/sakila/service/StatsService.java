package sakila.service;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;

import sakila.vo.Stats;
import sakila.dao.StatsDao;
import sakila.util.DBUtil;
public class StatsService {
	private StatsDao statsDao;
	// calender를 사용하여 오늘 날짜를 구하는 메소드
	private Stats getToday() {
		Calendar today = Calendar.getInstance();
		//simpleDateFormat을 사용하여 원하는 형식으로 날짜 출력
		SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
		//today변수를 string으로 넣음
		String day = formater.format(today.getTime());

		// stats에 오늘 날짜 추가
		Stats stats = new Stats();
		stats.setDay(day);
		
		// 디버깅
		System.out.println(stats.getDay() + "<--getToday() today");
		
		return stats;
	}
	//방문자 수 조회하는 메서드
	public Map<String,Object> getStats() {
		Map<String, Object> map = null;
		statsDao = new StatsDao();
		Stats todayStats = new Stats();
		Connection conn = null;
		
		try {
			//DBUtil에서 불러옴
			conn = DBUtil.getConnection();
			conn.setAutoCommit(false);//오토커밋 사용 X
			//중복되는 구문이므로 getToday를 가져옴
			todayStats = getToday();
			//db에서 오늘 날짜가 있는지 확인
			todayStats = statsDao.selectDay(conn, todayStats);
			int totalCnt = statsDao.selectTotalCnt(conn);
			// 디버깅
			System.out.println(todayStats.getDay() + "<--getStats().todayStats Day");
			System.out.println(todayStats.getCount() + "<--getStats().todayStats Cnt");
			System.out.println(totalCnt + "<--getStats() totalCnt");		
			
			map = new HashMap<String, Object>();
			map.put("todayStats", todayStats);
			map.put("totalCnt", totalCnt);
			
			conn.commit();
		} catch(Exception e) { // DB연결 , 쿼리문 오류 시
			try {
				conn.rollback();
			} catch (SQLException e1) {  // 롤백 실패 시
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) { // conn.close 실패 시
				e.printStackTrace();
			}
		}
		return map;
		//return 
	}
	public void countStats() { // 방문자 수를 1 더하는 메소드
		Stats stats = new Stats();
		statsDao = new StatsDao();
		Connection conn = null;
		try {
			//DBUtil에서 불러옴
			conn = DBUtil.getConnection();
			conn.setAutoCommit(false); // 오토 커밋 사용 X
			//중복 되는 구문이므로 getToday 사용
			stats = getToday();
			//db에서 오늘 날짜가 있는지 확인
			stats = statsDao.selectDay(conn, stats);
			if(stats == null) {
				stats = getToday();
				// 방문자가 있으면 + 1			
				statsDao.insertStats(conn, stats);
			}else {
				// 첫 방문자면 새로 만듬
				statsDao.updateStats(conn, stats);
			}
			conn.commit();
		}catch(Exception e) { //DB 연결, 쿼리에서 예외 발생 시
			try {
				conn.rollback();
			} catch(SQLException e1) { // 롤백 실패 시
				e1.getStackTrace();
			}
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch(SQLException e) { // conn.close() 실패 시
				e.printStackTrace();
			}
		}
	}
}
