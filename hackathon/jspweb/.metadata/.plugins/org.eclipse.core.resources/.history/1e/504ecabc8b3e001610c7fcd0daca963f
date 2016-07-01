<%@page import="StoreDB.ProductList"%>
<%@ page contentType="text/html;charset=utf-8" 
			import="java.sql.*"%>
			
<%

request.setCharacterEncoding("utf-8");

String useridx = request.getParameter("useridx");
String productname = request.getParameter("productname");
String productprice = request.getParameter("productprice");
String productcategory = request.getParameter("productcategory");

ProductList pl = new ProductList();


pl.setUseridx(Integer.parseInt(useridx));
pl.setProductname(productname);
pl.setProductprice(Integer.parseInt(productprice));
pl.setProductcategory(productcategory);



try {
	
	Class.forName("com.mysql.jdbc.Driver");  
	String DB_URL ="jdbc:mysql://localhost:3306/ereceiptdb?useSSL=false";

	Connection con =  DriverManager.getConnection(DB_URL, "admin", "1234");
	
	String sql = "INSERT INTO product_list (useridx, productname, productprice, productcategory) VALUES(?,?,?,?)";
	
	PreparedStatement pstmt = con.prepareStatement(sql);

	pstmt.setInt(1, pl.getUseridx());
	pstmt.setString(2, pl.getProductname());
	pstmt.setInt(3, pl.getProductprice());
	pstmt.setString(4, pl.getProductcategory());

	pstmt.executeUpdate();
	
	pstmt.close();
	con.close();
	
}catch(SQLException e) {
	out.print(e);
	return;
}

response.sendRedirect("product_save.jsp");
%>