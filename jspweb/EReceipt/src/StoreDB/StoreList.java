package StoreDB;

public class StoreList {
	private String id;
	private String pwd;
	private String store_name;
	private String store_address;
	
	public StoreList() {
	}
	
	public void setId(String id) {
		this.id = id;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public void setStore_name(String store_name) {
		this.store_name = store_name;
	}
	public void setStore_address(String store_address) {
		this.store_address = store_address;
	}
	
	public String getId() {
		return id;
	}
	public String getPwd() {
		return pwd;
	}
	public String getStore_name() {
		return store_name;
	}
	public String getStore_address() {
		return store_address;
	}

}
