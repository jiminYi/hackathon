<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
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
	left: 30%;
	width: 40%;
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
	
	   if(document.login_form.id.value=="") {
			alert("아이디를 입력하세요");	
			return false;
			
		} 
	   
	   if(document.login_form.pwd.value=="") {
			alert("비밀번호를 입력하세요");	
			return false;
			
		} 
}

</script>

</head>
<body>

<div class="wrapper">


<div id="content" align="center">
<h2>전자영수증 관리체계</h2>

<form name="login_form" method="post" action="login_do.jsp">
<div class="form">
<p>아이디</p><input type="text" name="id" placeholder="아이디" maxlength="10"><br>
<p>비밀번호</p><input type="password" name="pwd" placeholder="비밀번호"><br>
<br>
<input type="submit" value="로그인" onclick="return chk_blank()">
</div>
</form>


</div>


</div>


</body>
</html>