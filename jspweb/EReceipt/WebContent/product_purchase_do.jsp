<%@page import="StoreDB.ProductList"%>
<%@ page contentType="text/html;charset=utf-8" session="false" 
			import="java.sql.*"%>
<%

	HttpSession session = request.getSession(false);
	if(session == null) {
		response.sendRedirect("login.jsp");
			return;
	}
	String store_id = (String)session.getAttribute("login.store_id");

request.setCharacterEncoding("utf-8");

String[] product_id = request.getParameterValues("product_id");
String[] amount = request.getParameterValues("amount");
String card_company = request.getParameter("card_company");
String card_number = request.getParameter("card_number");
String purchase_date = request.getParameter("purchase_date");
String nfc_id = request.getParameter("nfc_id");

int receipt_id = 0;


try {
	
	Class.forName("com.mysql.jdbc.Driver");  
	String DB_URL ="jdbc:mysql://localhost/jaj7884";

	Connection con =  DriverManager.getConnection(DB_URL, "jaj7884", "wkddj1960!");
	
	String sql = "SELECT COUNT(purchase_date) FROM receipt";
	PreparedStatement pstmt = con.prepareStatement(sql);
	ResultSet rs = pstmt.executeQuery();
	if(rs.next()) {
	receipt_id = (rs.getInt(1)+1)*1000+Integer.parseInt(store_id);
	}
	String receipt_sql = "INSERT INTO receipt (receipt_id,store_id, card_company, card_number, purchase_date) VALUES(?,?,?,?,?)";
	String item_sql = "INSERT INTO item (product_id, amount, receipt_id) VALUES(?,?,?)";
	String receipt_user_sql = "INSERT INTO receipt_user (receipt_id, nfc_id) VALUES(?,?)";
	
	PreparedStatement pstmt1 = con.prepareStatement(receipt_sql);
	PreparedStatement pstmt2 = con.prepareStatement(item_sql);
	PreparedStatement pstmt3 = con.prepareStatement(receipt_user_sql);

	pstmt1.setInt(1, receipt_id);
	pstmt1.setInt(2, Integer.parseInt(store_id));
	pstmt1.setString(3, card_company);
	pstmt1.setInt(4, Integer.parseInt(card_number));
	pstmt1.setString(5, purchase_date);
		
	for(int i=0;i<product_id.length;i++) {
	
		pstmt2.setInt(1, Integer.parseInt(product_id[i]));
		pstmt2.setInt(2, Integer.parseInt(amount[i]));
		pstmt2.setInt(3, receipt_id);
		
		pstmt2.executeUpdate();
		
		pstmt2.clearParameters();
		
	}
	
	pstmt3.setInt(1, receipt_id);
	pstmt3.setString(2, nfc_id);
	

	pstmt1.executeUpdate();
	pstmt3.executeUpdate();
	
	rs.close();
	pstmt.close();
	pstmt1.close();
	pstmt2.close();
	pstmt3.close();
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