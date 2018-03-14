<!--
	@author 藤本
	@version 1.0
	食材検索画面
 -->

<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String delMessage = (String)request.getAttribute("message");
 %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
 <head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title>食材検索</title>
 <link rel="stylesheet" type="text/css" href="fpbase.css" />

 </head>
 <body>

 <%
 if (delMessage == null){
 %>
 	・メッセージは空です。
 <%
 }else{
 %>
 	<%= delMessage %>
 <%
 }
 %>
  <div align="center">
  	<h2><font color="#FF6699">食材検索</font></h2>

	<hr/>

		<form id="foodsearch" name="foodsearch" action="FoodSearchService"
		method="post" onsubmit="return check();">

		<table style="width:750px;" border="0" cellspacing="20">
			<input type="text" name="food_name" size="20" />
			<input type="submit" value="検索" />
		</table>

		</form>

	<hr/>
  </div>

	<p><input type="button" onclick="location.href='Entry.jsp'" value="戻る" /></p>

 </body>
</html>