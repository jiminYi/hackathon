<%@page import="java.sql.PreparedStatement"%>
<%@ page language="java" contentType="text/html; charset=utf-8" import="java.sql.*"
    pageEncoding="utf-8"%>
<%

String product_id = request.getParameter("product_id");

request.setCharacterEncoding("utf-8");

try {
	
	
	Class.forName("com.mysql.jdbc.Driver");  
	String DB_URL ="jdbc:mysql://localhost/jaj7884";

	Connection con =  DriverManager.getConnection(DB_URL, "jaj7884", "wkddj1960!");
	
	String sql = "SELECT *FROM product WHERE product_id=?";
	
	PreparedStatement pstmt = con.prepareStatement(sql);
	
	pstmt.setString(1, product_id);

	ResultSet rs = pstmt.executeQuery();
	
	if(rs.next()) {
	
%> 
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>EReceipt</title>

<style type="text/css">

  html, body {
  font-family: Arial, sans-serif;
  background: #fff;
  margin: 0;
  padding: 0;
  border: 0;
  position: absolute;
  height: 100%;
  min-width: 100%;
  font-size: 13px;
  color: #404040;
  direction: ltr;
  -webkit-text-size-adjust: none;
  }

#content {

	top:  50px;
	left: 20%;
	width: 60%;
	height: 500px;
	background-color: gray;
	display: inline-block;
	position: fixed;
}

.form {
	top: 60px;
	position: relative;
}


</style>

<script>
function chk_blank() {
	
	   if(document.modify_form.product_name.value=="") {
			alert("상품명을 입력하세요");	
			return false;		
		} 
	   
	   if(document.modify_form.product_price.value=="") {
			alert("가격을 입력하세요");	
			return false;	
		} 
	   if(document.modify_form.product_category.value=="") {
			alert("분류를 입력하세요");	
			return false;	
		} 
}

</script>

</head>
<body>

<div class="wrapper">


<div id="content" align="center">
<h2>전자영수증 관리체계</h2>

<form name="modify_form" method="post" action="product_modify_do.jsp?product_id=<%=product_id %>">
<div class="form">
<p>상품명</p><input type="text" name="product_name" value="<%=rs.getString("product_name") %>" size="12"><br>
<p>가격</p><input type="number" name="product_price" value="<%=rs.getString("product_price") %>" min="0" step="1"><br>
<p>분류</p><input type="text" name="product_category" value="<%=rs.getString("product_category") %>" size="12"><br>
<br>
<input type="submit" value="수정" onclick="return chk_blank()">
</div>
</form>

<%
	}
rs.close();	
pstmt.close();
con.close();

}catch(SQLException e) {
out.print(e);
return;
}

%>


</div>


</div>


</body>
</html>