package sakila.dao;

import java.sql.*;


import sakila.query.StatsQuery;
import sakila.vo.Stats;

public class StatsDao {
	//��¥�� �޾ƿ� �� �� ���� �����ڰ� ���� �Ǻ��ϴ� �޼���
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
	//�湮���� ���� 1�� �ʱ�ȭ ��Ű�� �޼���
	public void insertStats(Connection conn, Stats stats) throws Exception {
		PreparedStatement stmt = conn.prepareStatement(StatsQuery.INSERT_STATS);
		stmt.setString(1, stats.getDay());
		
		stmt.executeUpdate();
	}
	//�湮���� ���� 1�� ���� �ϴ� �޼���
	public void updateStats(Connection conn, Stats stats) throws Exception {
		PreparedStatement stmt = conn.prepareStatement(StatsQuery.UPDATE_STATS);
		stmt.setString(1, stats.getDay());
		
		stmt.executeUpdate();
	}
	//��ü �湮�� �� ���ϴ� �޼���
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
