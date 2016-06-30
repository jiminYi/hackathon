<%@ page  contentType="text/html;charset=utf-8" import="java.sql.*" %>
<%


request.setCharacterEncoding("utf-8");

String productidx = request.getParameter("productidx"); 

try {

	Class.forName("com.mysql.jdbc.Driver");
	String DB_URL ="jdbc:mysql://localhost:3306/ereceiptdb?useSSL=false";

	Connection con =  DriverManager.getConnection(DB_URL, "admin", "1234"); 

	String sql = "DELETE FROM product_list WHERE productidx=?";
	
	
	PreparedStatement pstmt = con.prepareStatement(sql);
	
	pstmt.setInt(1, Integer.parseInt(productidx));

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