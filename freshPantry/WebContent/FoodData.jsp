<!--
	@author 藤本
	@version 1.0
	(庫内リスト)食材情報表示
 -->
<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="fPBean.FoodBean"%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>

<%
	ArrayList<FoodBean> foodList = (ArrayList<FoodBean>)request.getAttribute("resultList");
 %>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
 <head>
 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title>食材情報表示</title>
  <link rel="stylesheet" type="text/css" href="fpbase.css" />
  <style>
    th {align:left;}

  </style>

 </head>
 <body>
	<div align="center">

	<h1><font color="pink">食材情報表示</font></h1>
	<br/>
	<hr/>

<%
	if (foodList != null) {
		for(int i=0; i< foodList.size(); i++){
			FoodBean foodBean = foodList.get(i);
%>

	<table align="center" border="0">
	<tr>
       <th>・食材名</th><td><%=foodBean.getFoodName()%></td>
     </tr>
     <tr>
       <th>・残量</th><td><%=foodBean.getQuantity()%>
						  <%=foodBean.getUnitName()%></td>
     </tr>
     <tr>
       <th>・購入日</th><td><%=foodBean.getPurchaseDate()%></td>
     </tr>
     <tr>
       <th>・賞味期限</th><td><%=foodBean.getExpirationDate()%></td>
     </tr>
     <tr>
       <th>・カテゴリー</th><td><%=foodBean.getCategoryName()%></td>
     </tr>
     <br/>
     </table>
	<hr/>
<%
			}
		}
 %>
	<p>
	<input type="button" onclick="location.href='FoodSearch.jsp'" value="戻る" />
	<input type="button" onclick="location.href='Entry.jsp'" value="メニューへ" />
	</p>
	</div>
 </body>
</html>