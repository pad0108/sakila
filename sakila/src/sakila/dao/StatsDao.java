package sakila.dao;

import java.sql.Connection;
import sakila.vo.Stats;

public class StatsDao {
	//오늘 날짜 여부 확인
	public boolean selectDay(Connection conn, Stats stats) throws Exception {
		//rs.next() false 일 경우 insert로 넘어감
		/*if(rs.next()) {
		return true;
		}
		*/
		return false;
	}
	//새로운 날짜일 경우
	public void insertStats(Connection conn, Stats stats) throws Exception {
		
	}
	//방문자 접속시 Stat 추가
	public void updateStats(Connection conn) throws Exception {
		
	}
	
}
