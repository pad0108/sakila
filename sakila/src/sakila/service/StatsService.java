package sakila.service;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.sql.Connection;

import sakila.vo.Stats;
import sakila.dao.StatsDao;
public class StatsService {
	private StatsDao statsDao;
	public void countStats() {
		statsDao = new StatsDao();
		//변경 사항 없으므로 final
		final String URL = "";
		final String USER = "root";
		final String PASSWORD = "java1004";
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			conn.setAutoCommit(false);
			//여기서 오늘 날짜가 없을 시 insert 함
			Calendar today = Calendar.getInstance();
			SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
			String day = formater.format(today);
			Stats stats = new Stats();
			stats.setDay(day);
			if(statsDao.selectDay(conn, stats)) {
				statsDao.updateStats(conn);
			}else {
				statsDao.insertStats(conn, stats);
			}
			conn.commit();
		}catch(Exception e) {
			try {
				conn.rollback();
			} catch(SQLException e1) {
				e1.getStackTrace();
			}
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
