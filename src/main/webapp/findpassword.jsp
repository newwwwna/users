<%@page import="com.javalec.users.vo.UsersVO"%>
<%@page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>새글등록</title>

</head>
<body>




				<center>
					<h3>비밀번호 찾기</h3>
					<hr>
					<form action="searchpw.do" method="post" >
						<table border="1" cellpadding="0" cellspacing="0" width="700">
							<tr>
								<td width=30%>아이디</td>
								<td ><input type="text" name="id" size="20" /></td>
							</tr>
							<tr>
								<td >비밀번호</td>
								<td ><h2><font color="blue"><%if(request.getAttribute("password")!=null) { %>							
								<%=request.getAttribute("password") %>
								<%} %>
								<%if(session.getAttribute("error")!=null) { %>		
							<%=session.getAttribute("error") %>
							<%} %>
								
								</font></h2></td>
							</tr>
							<tr>
								<td colspan="2" align="center">
								<input type="submit" value="비밀번호찾기" /></td>
							</tr>
						</table>
					</form>
					<a href="login.jsp"><h3>로그인하기</h3></a>
					<hr>
				</center>

</body>
</html>