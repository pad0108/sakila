package sakila.service;

public class StatsQuery {
	//쿼리문은 변경 되지 않으므로 final 사용, static으로 지정하여 여러번 객체 생성 X
	public final static String SELECT_DAY = "SELECT * FROM stats WHERE day=?";
	public final static String INSERT_STATS = "INSERT INTO stats(day, count) VALUES(?, 1)";
	public final static  String UPDATE_STATS = "UPDATE stats SET count=count+1 WHERE day=?";
	public final static String SELECT_TOTAL_STATS = "SELECT SUM(count) FROM stats";
}
