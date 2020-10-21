package sakila.dao;

import java.sql.*;


import sakila.query.StatsQuery;
import sakila.vo.Stats;

public class StatsDao {
	//날짜를 받아온 후 그 날의 접속자가 유무 판별하는 메서드
	public Stats selectDay(Connection conn, Stats stats) throws Exception {
		Stats returnStats = null;
		PreparedStatement stmt = conn.prepareStatement(StatsQuery.SELECT_DAY);
		stmt.setString(1, stats.getDay());
		ResultSet rs = stmt.executeQuery();
		if(rs.next()) {
			returnStats = new Stats();
			returnStats.setDay(rs.getString("day"));
			returnStats.setCount(rs.getInt("count"));
		}
		return returnStats;
	}
	//방문자의 수를 1로 초기화 시키는 메서드
	public void insertStats(Connection conn, Stats stats) throws Exception {
		PreparedStatement stmt = conn.prepareStatement(StatsQuery.INSERT_STATS);
		stmt.setString(1, stats.getDay());
		
		stmt.executeUpdate();
	}
	//방문자의 수를 1씩 증가 하는 메서드
	public void updateStats(Connection conn, Stats stats) throws Exception {
		PreparedStatement stmt = conn.prepareStatement(StatsQuery.UPDATE_STATS);
		stmt.setString(1, stats.getDay());
		
		stmt.executeUpdate();
	}
	//전체 방문자 수 구하는 메서드
	public int selectTotalCnt(Connection conn) throws Exception{
		int total = 0;
		PreparedStatement stmt = conn.prepareStatement(StatsQuery.SELECT_TOTAL_STATS);
		ResultSet rs = stmt.executeQuery();
		if(rs.next()) {
			total = rs.getInt("SUM(count)");
		}
		return total;
	}
	
}
