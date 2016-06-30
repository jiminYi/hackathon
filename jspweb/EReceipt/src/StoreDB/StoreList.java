package StoreDB;

public class StoreList {
	private String id;
	private String pwd;
	private String username;
	private String useraddress;
	
	public StoreList() {
	}
	
	public void setId(String id) {
		this.id = id;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setUseraddress(String useraddress) {
		this.useraddress = useraddress;
	}
	
	public String getId() {
		return id;
	}
	public String getPwd() {
		return pwd;
	}
	public String getUsername() {
		return username;
	}
	public String getUseraddress() {
		return useraddress;
	}

}
