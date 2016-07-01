<%@ page contentType="text/html;charset=utf-8" 
			import="java.sql.*"%>
<%
request.setCharacterEncoding("utf-8");

String product_id = request.getParameter("product_id");
String product_name = request.getParameter("product_name");
String product_price = request.getParameter("product_price");
String product_category = request.getParameter("product_category");

try {
	Class.forName("com.mysql.jdbc.Driver"); 
	String DB_URL ="jdbc:mysql://localhost/jaj7884";

	Connection con =  DriverManager.getConnection(DB_URL, "jaj7884", "wkddj1960!");
	
	
	String sql = "UPDATE product SET product_name=?,product_price=?,product_category=? WHERE product_id=?";
	
	PreparedStatement pstmt = con.prepareStatement(sql);
	
	 
	pstmt.setString(1, product_name);
	pstmt.setString(2, product_price);
	pstmt.setString(3, product_category);
	pstmt.setString(4, product_id);

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