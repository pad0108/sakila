package sakila.vo;

public class Staff {
	//11���� �ʵ�(�Ӽ�, �������)
	private int staffId;
	private String firstName;
	private String lastName;
	private int addressId;
	private String pricture;
	private String email;
	private int storeId;
	private int active;
	private String userName;
	private String password;
	private String lastUpdate;
	public int getStaffId() {
		return staffId;
	}
	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getAddressId() {
		return addressId;
	}
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
	public String getPricture() {
		return pricture;
	}
	public void setPricture(String pricture) {
		this.pricture = pricture;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getStoreId() {
		return storeId;
	}
	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}
	public int getActive() {
		return active;
	}
	public void setActive(int active) {
		this.active = active;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String username) {
		this.userName = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getLastUpdate() {
		return lastUpdate;
	}
	public void setLastUpdate(String lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	//toString �޼��� �������̵�
	@Override
	public String toString() {
		return "Staff [staffId=" + staffId + ", firstName=" + firstName + ", lastName=" + lastName + ", addressId="
				+ addressId + ", pricture=" + pricture + ", email=" + email + ", storeId=" + storeId + ", active="
				+ active + ", userName=" + userName + ", password=" + password + ", lastUpdate=" + lastUpdate + "]";
	}

}