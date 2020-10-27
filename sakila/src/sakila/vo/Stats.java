package sakila.vo;

public class Stats {
	private String day;
	private int cnt;
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public int getCount() {
		return cnt;
	}
	public void setCount(int count) {
		this.cnt = count;
	}
	@Override
	public String toString() {
		return "Stats [day=" + day + ", count=" + cnt + "]";
	}
}
