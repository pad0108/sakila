package sakila.query;

public class StaffInfoQuery {
	//관리자 정보 출력
	public final static String SELECT_STAFF_INFO="SELECT staff.staff_id , staff.first_name, staff.last_name, staff_list.address, staff_list.phone, staff_list.city, staff_list.country, staff.email, staff.username FROM staff_list JOIN staff ON staff.staff_id = staff_list.ID WHERE staff.staff_id = ?";
}
