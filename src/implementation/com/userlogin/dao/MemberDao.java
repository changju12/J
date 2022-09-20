package implementation.com.userlogin.dao;

public class MemberDao {
	private String user_id;
	private String user_pass;
	private String user_name;
	private String phone_num;
	private String address;
	private String user_lvl;
	
	public MemberDao() {}
	
	public MemberDao(String user_lvl) {
		this.user_lvl = user_lvl;
	}
	
	public MemberDao(String user_id,String user_pass, String user_name, String phone_num, String address, String user_lvl ) {
		this.user_id = user_id;
		this.user_pass = user_pass;
		this.user_name = user_name;
		this.phone_num = phone_num;
		this.address = address;
		this.user_lvl = user_lvl;
	}
	
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_pass() {
		return user_pass;
	}
	public void setUser_pass(String user_pass) {
		this.user_pass = user_pass;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getPhone_num() {
		return phone_num;
	}
	public void setPhone_num(String phone_num) {
		this.phone_num = phone_num;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getUser_lvl() {
		return user_lvl;
	}
	public void setUser_lvl(String user_lvl) {
		this.user_lvl = user_lvl;
	}
	
	}
