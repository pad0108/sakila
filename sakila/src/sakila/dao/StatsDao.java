package sakila.dao;

import java.sql.Connection;
import sakila.vo.Stats;

public class StatsDao {
	//���� ��¥ ���� Ȯ��
	public boolean selectDay(Connection conn, Stats stats) throws Exception {
		//rs.next() false �� ��� insert�� �Ѿ
		/*if(rs.next()) {
		return true;
		}
		*/
		return false;
	}
	//���ο� ��¥�� ���
	public void insertStats(Connection conn, Stats stats) throws Exception {
		
	}
	//�湮�� ���ӽ� Stat �߰�
	public void updateStats(Connection conn) throws Exception {
		
	}
	
}
