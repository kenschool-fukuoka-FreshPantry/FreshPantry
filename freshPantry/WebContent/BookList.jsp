<!--
	@author 佐藤裕章
	中級演習問題5　問題3
 -->
<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page import="exercise05.BookBean"%>

<%
	List<BookBean> bookList = (List<BookBean>)request.getAttribute("bookList");
 %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>書籍一覧</title>
</head>
<body>
		<h2>書籍一覧</h2>

		<table border=1>
			<tr>
				<td>ID</td>
				<td>タイトル</td>
				<td>価格</td>
			</tr>

<%
	if (bookList != null) {
		for(int i=0; i< bookList.size(); i++){
			BookBean bookBean = bookList.get(i);
 %>
			<tr>
				<td><%= bookBean.getId() %></td>
				<td><%= bookBean.getTitle() %></td>
				<td><%= bookBean.getPrice() %></td>
			</tr>

<%
			}
		}
 %>
		</table>

</body>
</html>