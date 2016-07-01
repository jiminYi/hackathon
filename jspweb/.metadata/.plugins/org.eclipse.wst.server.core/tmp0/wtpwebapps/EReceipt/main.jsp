<%@ page language="java" contentType="text/html; charset=utf-8" session="false"
    pageEncoding="utf-8"%>
<%

	HttpSession session = request.getSession(false);
	if(session == null) {
		response.sendRedirect("login.jsp");
			return;
	}

	String store_id = (String)session.getAttribute("login.store_id");
	String id = (String)session.getAttribute("login.id");
	String pwd = (String)session.getAttribute("login.pwd");
	String store_name = (String)session.getAttribute("login.store_name");
	String store_address = (String)session.getAttribute("login.store_address");

%>
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>EReceipt</title>

<link href="main_contents.css" rel="stylesheet" type="text/css" />
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
					<img src="http://placehold.it/635x100" alt="배너">
				</div>
				<div class="news1">
					<h3>empty <span></span></h3>
					<div>empty</div>
					
					<ul class="news2">
						<li>empty</li>
						<li><span>|</span>empty</li>
						<li><span>|</span>empty</li>
						<li><span>|</span>empty</li>
						<li><span>|</span>empty</li>
					</ul>
				</div>
				<div class="newslist">
					<div class="news_tit">
						<h2>empty<span></span></h2>
						<div>
							<strong>empty</strong> <span>|</span> empty
						</div>
					</div>
					<div class="newsCont">
						<ul>
							<li><img src="http://placehold.it/81x73" alt="언론사 목록"></li>
							<li><img src="http://placehold.it/81x73" alt="언론사 목록"></li>
							<li><img src="http://placehold.it/81x73" alt="언론사 목록"></li>
							<li><img src="http://placehold.it/81x73" alt="언론사 목록"></li>
							<li><img src="http://placehold.it/81x73" alt="언론사 목록"></li>
							<li><img src="http://placehold.it/81x73" alt="언론사 목록"></li>
							<li><img src="http://placehold.it/81x73" alt="언론사 목록"></li>
							<li><img src="http://placehold.it/81x73" alt="언론사 목록"></li>
							<li><img src="http://placehold.it/81x73" alt="언론사 목록"></li>
							<li><img src="http://placehold.it/81x73" alt="언론사 목록"></li>
							<li><img src="http://placehold.it/81x73" alt="언론사 목록"></li>
							<li><img src="http://placehold.it/81x73" alt="언론사 목록"></li>
						</ul>
						<div class="news_ft">
							<span class="ico">설정</span> <span class="col_gr">|</span>
							<span>[알림]</span>
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
							<label for="login_id" class="login_label">아이디</label>
							아이디: <%=id %>
						</div>
						<div class="login_box">
							<label for="login_pwd" class="login_label">비밀번호</label>
							비밀번호: <%=pwd %>
						</div>
						<div class="login_box">
							<label for="store_name" class="login_label">매장명</label>
							매장명: <%=store_name %>
						</div>
						<div class="login_box">
							<label for="store_address" class="login_label">주소</label>
							주소: <%=store_address %>
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
					<h3>empty <span></span></h3>
					<div class="today_link">
						<strong>10.13.</strong>(월)<span>|</span> empty
					</div>
					<ul class="today_cont">
						<li><strong>empty</strong><span></span>empty</li>
						<li><strong>empty</strong><span></span>empty</li>
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
