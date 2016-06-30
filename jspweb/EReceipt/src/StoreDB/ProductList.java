package StoreDB;

public class ProductList {
	private int store_id;
	private String product_name;
	private int product_price;
	private String product_category;
	
	public ProductList() {
	}
	
	public void setStore_id(int store_id) {
		this.store_id = store_id;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public void setProduct_price(int product_price) {
		this.product_price = product_price;
	}
	public void setProduct_category(String product_category) {
		this.product_category = product_category;
	}
	
	public int getStore_id() {
		return store_id;
	}
	public String getProduct_name() {
		return product_name;
	}
	public int getProduct_price() {
		return product_price;
	}
	public String getProduct_category() {
		return product_category;
	}

}
