package sakila.query;

public class StatsQuery {
	//오늘 날짜의 접속 정보
	public final static String SELECT_DAY = "SELECT * FROM stats WHERE day=?";
	// 오늘 날짜가 없을 때 접속자 수 1로
	public final static String INSERT_STATS = "INSERT INTO stats(day, cnt) VALUES(?, 1)";
	// 오늘 날짜가 있을 때 접속자 수 +1
	public final static  String UPDATE_STATS = "UPDATE stats SET cnt=cnt+1 WHERE day=?";
	// 전체 접속자 수
	public final static String SELECT_TOTAL_STATS = "SELECT SUM(cnt) FROM stats";
}
