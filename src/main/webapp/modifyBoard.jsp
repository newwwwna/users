<%@page import="com.javalec.users.vo.BoardVO"%>
<%@page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>글 상세</title>
</head>
<body>

				<center>
					<h1>게시글 수정</h1>
					<hr>
					<form action="modify.do" method="post">
					<input type="hidden" name="seq" value="${board.seq}">
						<table border="1" cellpadding="0" cellspacing="0" width=700px>
							<tr>
								<td  width=20%>제목</td>
								<td >&nbsp;&nbsp;<input name="title" type="text" value="${board.title}"
									 /></td>
							</tr>
							<tr>
								<td >작성자</td>
								<td >&nbsp;&nbsp;<input name="writer" type="text" value="${board.writer}"
									 /></td>
							</tr>
							<tr>
								<td >내용</td>
								<td >&nbsp;&nbsp;<textarea name="content" cols="70" rows="10">${board.content}</textarea>
								</td>
							</tr>
							<tr>
								<td >등록일</td>
								<td >${board.regdate}</td>
							</tr>
							<tr>
								<td >조회수</td>
								<td >${board.cnt}</td>
							</tr>
							<tr>
								<td colspan="2" align="center"><input type="submit"
									value="글 수정" /></td>
							</tr>
						</table>
					</form>
					<hr>
				</center>
				<div align="center"	width:100%	height:50px  margin:20px auto;>
					<a href="list.do" >목록</a>
				</div>
</body>
</html>
