<%@ page  contentType="text/html;charset=utf-8" import="java.sql.*" %>
<%


request.setCharacterEncoding("utf-8");

String product_id = request.getParameter("product_id"); 

try {

	Class.forName("com.mysql.jdbc.Driver");
	String DB_URL ="jdbc:mysql://localhost/jaj7884";

	Connection con =  DriverManager.getConnection(DB_URL, "jaj7884", "wkddj1960!"); 

	String sql = "DELETE FROM product WHERE product_id=?";
	
	
	PreparedStatement pstmt = con.prepareStatement(sql);
	
	pstmt.setInt(1, Integer.parseInt(product_id));

	pstmt.executeUpdate();

	
	pstmt.close();
	con.close();

}catch(ClassNotFoundException e) {
	out.print(e);
	return;
}catch(SQLException e) {
	out.print(e);
	return;
}catch(Exception e) {
	out.print(e);
	return;
}

response.sendRedirect("product_save.jsp");
%>