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
	List<FoodBean> foodList = (List<FoodBean>)request.getAttribute("foodList");
 %>

<%
	String no = (String)request.getAttribute("no");
	String food_name = (String)request.getAttribute("food_name");

	FoodBean fBean = (FoodBean)request.getAttribute("foodB");

	String res = (String)request.getAttribute("result");
 %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
 <head>
 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title>食材情報表示</title>
  <link rel="stylesheet" type="text/css" href="fpbase.css" />

 </head>
 <body>
	<div align="center">

	<h1><font color="pink">食材情報表示</font></h1>		<%--<form action="FoodDataService" method="post" />--%>
	<br/>

<%
	if (foodList != null) {
		for(int i=0; i< foodList.size(); i++){
			FoodBean foodBean = foodList.get(i);
%>

	<table border="0">
	<tr>
       <th>・食材名</th><td><%=fBean.getFoodName()%></td>
     </tr>
     <tr>
       <th>・残量</th><td><%=fBean.getQuantity()%><%=fBean.getUnitName()%></td>
     </tr>
     <tr>
       <th>・購入日</th><td><%=fBean.getPurchaseDate()%></td>
     </tr>
     <tr>
       <th>・賞味期限</th><td><%=fBean.getExpirationDate()%></td>
     </tr>
     <tr>
       <th>・カテゴリー</th><td><%=fBean.getCategoryName()%></td>
     </tr>
     <tr>
       <th>・栄養素</th><td><%=fBean.getNutrientList()%></td>			<%--<input type="submit" value=" 登録 " /></td>--%>
     </tr>
     <br/>
     </table>

<%
			}
		}
 %>

	<p>
	<input type="button" onclick="location.href='FoodEntry.jsp'" value="戻る" />
	<input type="button" onclick="location.href='Entry.jsp'" value="キャンセル" />
	</p>
	</div>
 </body>
</html>