package sakila.service;

public class StatsQuery {
	//�������� ���� ���� �����Ƿ� final ���, static���� �����Ͽ� ������ ��ü ���� X
	public final static String SELECT_DAY = "SELECT * FROM stats WHERE day=?";
	public final static String INSERT_STATS = "INSERT INTO stats(day, count) VALUES(?, 1)";
	public final static  String UPDATE_STATS = "UPDATE stats SET count=count+1 WHERE day=?";
	public final static String SELECT_TOTAL_STATS = "SELECT SUM(count) FROM stats";
}
