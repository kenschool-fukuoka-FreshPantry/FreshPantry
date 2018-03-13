<!--
	@author 藤本
	(庫内リスト)食材情報表示
	@version 1.0
 -->
<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>

<%@page import="fPBean.FoodBean"%>

<%
	List<FoodBean> foodList = (List<FoodBean>)request.getAttribute("foodList");
 %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
 <head>
 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title>食材情報表示</title>


 </head>
 <body>
  <div align="center">
	<h2>食材情報表示</h2>

		<table border="1">
			<tr>
				<td>ID</td>
				<td>タイトル</td>
				<td>価格</td>
			</tr>

<%
	if (foodList != null) {
		for(int i=0; i< foodList.size(); i++){
			FoodBean foodBean = foodList.get(i);
 %>
			<tr>
				<td><%= foodBean.getFoodData() %></td>
			</tr>

<%
			}
		}
 %>
   </div>
		</table>

	<p><input type="button" onclick="location.href='FoodSearch.jsp'" value="戻る" />
		<input type="button" onclick="location.href='Entry.jsp'" value="メニューへ" />
	</p>
 </body>
 </html>