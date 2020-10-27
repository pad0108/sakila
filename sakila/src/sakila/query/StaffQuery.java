package sakila.query;

public class StaffQuery {
	//로그인 하기 위한 쿼리문
	public final static String SELECT_STAFF_BY_KEY="SELECT staff_id, username,email,store_id FROM staff WHERE email = ? AND password = PASSWORD(?)";
}
