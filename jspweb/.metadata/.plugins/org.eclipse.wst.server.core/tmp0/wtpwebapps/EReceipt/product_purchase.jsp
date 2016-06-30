<%@ page language="java" contentType="text/html; charset=utf-8" session="false" import="java.sql.*"
    pageEncoding="utf-8" %>
<%

	HttpSession session = request.getSession(false);
	if(session == null) {
		response.sendRedirect("login.jsp");
			return;
	}

	String useridx = (String)session.getAttribute("login.useridx");
	String id = (String)session.getAttribute("login.id");
	String pwd = (String)session.getAttribute("login.pwd");
	String username = (String)session.getAttribute("login.username");
	String useraddress = (String)session.getAttribute("login.useraddress");

%>
<%
Class.forName("com.mysql.jdbc.Driver");

String DB_URL = "jdbc:mysql://localhost:3306/ereceiptdb?useSSL=false";

Connection con= null;
Statement stmt = null;
ResultSet rs   = null;

try {
    
    con = DriverManager.getConnection(DB_URL, "admin", "1234"); 

    stmt = con.createStatement(); 

    String query = "SELECT * FROM product_list WHERE useridx="+useridx; 
    
    rs = stmt.executeQuery(query);
   

%>


<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>EReceipt</title>
<link href="product_save_contents.css" rel="stylesheet" type="text/css" />

<script>

function chk_blank() {
	
	   if(document.product_form.productname.value=="") {
			alert("상품명을 입력하세요");	
			return false;
			
		} 
	   
	   if(document.product_form.productprice.value=="") {
			alert("가격을 입력하세요");	
			return false;
			
		} 
	   
	   if(document.product_form.productcategory.value=="") {
			alert("상품분류를 입력하세요");	
			return false;
			
		} 
	   
}

</script>


</head>

 <body>
 
	<header>
		<h1><img src="./images/logo.gif" alt="전자영수증 관리체계" ></h1>
		<div class="search">
			<span class="inp_search"><input type="text" title="검색어 입력" name="input1"></span>
			<button type="submit" class="btn_search"><span class="txt_hid">검색</span></button>
		</div>
		<nav class="gnb">
			<ul class="sub_menu1">
				<li><a href="product_save.jsp">상품등록</a></li>
				<li><a href="product_purchase.jsp">구매내용</a></li>
			</ul>
		</nav>
	</header>
	

	<div class="contents">
		 <div class="subcontents1">
			<section>
				<div class="banner">
					<h2>계산</h2>
				</div>

				<div class="newslist">
					<div class="news_tit">
						<h2 style="color:yellow;">신규품목 등록</h2><span></span>
						<div>
						<form name="product_form" action="product_save_do.jsp" method="get">
							<strong>상품명</strong><input type="text" name="productname" size="12"><span>|</span>
							<strong>가격</strong><input type="number" name="productprice" min="0" step="1"><span>&#8361;|</span>
							<strong>분류</strong><input type="text" name="productcategory" size="12"><span>|</span>
							<input type="text" name="useridx" value="<%=useridx %>" style="display: none; ">
							
							<input type="submit" value="등록" onclick="return chk_blank()">
						</form>
						
						</div>
					</div>
					<div class="newsCont">
						
							<table>
							<%
   							while(rs.next()) {
							%>
							<tr>
								<td>상품명 : <%=rs.getString("productname") %></td>
								<td>가격 : <%= rs.getInt("productprice")%></td>
								<td>분류 : <%=rs.getString("productcategory") %></td>
								<td><input type="button" value="삭제" onClick="location.href='product_delete.jsp?productidx=<%= rs.getInt("productidx")%>'"></td>
								<td><input type="button" value="수정" onClick="window.open('product_modify.jsp?productidx=<%= rs.getInt("productidx")%>','_blank()',
										'width=300,height=400,scrollbars=no,menubar=no,resizable=no')"></td>
							</tr>
							<%
   							}
							%>
							</table>
							<%
   							
								rs.close();     
    							stmt.close();     
    							con.close(); 	
									} catch (SQLException e) {
     							 out.println("err:"+e.toString());
      							return;
								} 
							%>
						
						<div class="news_ft">
							<span class="ico">구독설정</span> <span class="col_gr">|</span>
							<span>[알림]언론사별 주요뉴스를 메인에서 바로 볼 수 있어요!</span>
						</div>
					</div>
				</div>
			</section>
			<aside>
				<div class="login">
					<p class="join_link">
						<a href="#" title="회원가입 페이지로 이동">회원정보수정</a>
					</p>

					
						<div class="login_box">
							<label for="id" class="login_label">아이디</label>
							아이디: <%=id %>
						</div>
						<div class="login_box">
							<label for="login_pwd" class="login_label">비밀번호</label>
							비밀번호: <%=pwd %>
						</div>
						<div class="login_box">
							<label for="login_pwd" class="login_label">매장명</label>
							매장명: <%=username %>
						</div>
						<div class="login_box">
							<label for="login_pwd" class="login_label">주소</label>
							주소: <%=useraddress %>
						</div>						
								
						<form name="login_form" action="login.jsp">						
						<input type="image" src="http://14.63.212.205/html/18_ksaedu/01_user/images/total/btn/btn_logout2.gif" 
						title="로그아웃" alt="로그아웃" class="login_btn">
						</form>

						<div class="security">
							<div class="security_txt">IP보안 <span class="security_on">ON</span></div>
							<div class="dis_login_box"><a href="#" class="dis_login"><span>일회용 로그인</span></a></div>
						</div>
					
				</div>
				<div class="today_box">
					<h3>투데이 <span></span></h3>
					<div class="today_link">
						<strong>10.13.</strong>(월)<span>|</span> TV편성
					</div>
					<ul class="today_cont">
						<li><strong>신문1면</strong><span></span>"5.24제재, 남북 만나 대화로 풀어야"</li>
						<li><strong>학습</strong><span></span>영어로 듣는 뉴스 | 오늘의 글로벌 회화</li>
						<li><strong>스포츠</strong><span></span>'4홈런' 세인트루이스, NLCS 2차전 승리</li>
						<li><strong>증시</strong><span></span>코스닥 534.31</li>
					</ul>
				</div>
				<div class="ad">
					<img src="http://placehold.it/298x150" alt="광고배너">
				</div>
			</aside>
		 </div>

		 <div class="subcontents2"></div>
		 <div class="subcontents3"></div>
	</div>
	<footer></footer>

 </body>
</html>
