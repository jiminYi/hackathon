<%@page import="StoreDB.ProductList"%>
<%@ page contentType="text/html;charset=utf-8" 
			import="java.sql.*"%>
			
<%

request.setCharacterEncoding("utf-8");

String store_id = request.getParameter("store_id");
String product_name = request.getParameter("product_name");
String product_price = request.getParameter("product_price");
String product_category = request.getParameter("product_category");



try {
	
	Class.forName("com.mysql.jdbc.Driver");  
	String DB_URL ="jdbc:mysql://localhost/jaj7884";

	Connection con =  DriverManager.getConnection(DB_URL, "jaj7884", "wkddj1960!");
	
	String sql = "INSERT INTO product (store_id, product_name, product_price, product_category) VALUES(?,?,?,?)";
	
	PreparedStatement pstmt = con.prepareStatement(sql);

	pstmt.setInt(1, Integer.parseInt(store_id));
	pstmt.setString(2, product_name);
	pstmt.setInt(3, Integer.parseInt(product_price));
	pstmt.setString(4, product_category);

	pstmt.executeUpdate();
	
	pstmt.close();
	con.close();
	
}catch(SQLException e) {
	out.print(e);
	return;
}

response.sendRedirect("product_save.jsp");
%>