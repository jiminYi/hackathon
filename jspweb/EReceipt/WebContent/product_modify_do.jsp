<%@ page contentType="text/html;charset=utf-8" 
			import="java.sql.*"%>
<%
request.setCharacterEncoding("utf-8");

String productidx = request.getParameter("productidx");
String productname = request.getParameter("productname");
String productprice = request.getParameter("productprice");
String productcategory = request.getParameter("productcategory");

try {
	Class.forName("com.mysql.jdbc.Driver"); 
	String DB_URL ="jdbc:mysql://localhost:3306/ereceiptdb?useSSL=false";

	Connection con =  DriverManager.getConnection(DB_URL, "admin", "1234");
	
	
	String sql = "UPDATE product_list SET productname=?,productprice=?,productcategory=? WHERE productidx=?";
	
	PreparedStatement pstmt = con.prepareStatement(sql);
	
	 
	pstmt.setString(1, productname);
	pstmt.setString(2, productprice);
	pstmt.setString(3, productcategory);
	pstmt.setString(4, productidx);

	pstmt.executeUpdate();

	pstmt.close();
	con.close();
}catch(SQLException e) {
	out.print(e);
	return;
}
%>
<script>
opener.location.reload(true);
window.close();
</script>