<%@page import="StoreDB.ProductList"%>
<%@ page contentType="text/html;charset=utf-8" 
			import="java.sql.*"%>
			
<%

request.setCharacterEncoding("utf-8");

String store_id = request.getParameter("store_id");
String product_name = request.getParameter("product_name");
String product_price = request.getParameter("product_price");
String product_category = request.getParameter("product_category");

ProductList pl = new ProductList();


pl.setStore_id(Integer.parseInt(store_id));
pl.setProduct_name(product_name);
pl.setProduct_price(Integer.parseInt(product_price));
pl.setProduct_category(product_category);



try {
	
	Class.forName("com.mysql.jdbc.Driver");  
	String DB_URL ="jdbc:mysql://localhost:3306/ereceiptdb?useSSL=false";

	Connection con =  DriverManager.getConnection(DB_URL, "admin", "1234");
	
	String sql = "INSERT INTO product (store_id, product_name, product_price, product_category) VALUES(?,?,?,?)";
	
	PreparedStatement pstmt = con.prepareStatement(sql);

	pstmt.setInt(1, pl.getStore_id());
	pstmt.setString(2, pl.getProduct_name());
	pstmt.setInt(3, pl.getProduct_price());
	pstmt.setString(4, pl.getProduct_category());

	pstmt.executeUpdate();
	
	pstmt.close();
	con.close();
	
}catch(SQLException e) {
	out.print(e);
	return;
}

response.sendRedirect("product_save.jsp");
%>