package StoreDB;

public class ProductList {
	private int useridx;
	private String productname;
	private int productprice;
	private String productcategory;
	
	public ProductList() {
	}
	
	public void setUseridx(int useridx) {
		this.useridx = useridx;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public void setProductprice(int productprice) {
		this.productprice = productprice;
	}
	public void setProductcategory(String productcategory) {
		this.productcategory = productcategory;
	}
	
	public int getUseridx() {
		return useridx;
	}
	public String getProductname() {
		return productname;
	}
	public int getProductprice() {
		return productprice;
	}
	public String getProductcategory() {
		return productcategory;
	}

}
