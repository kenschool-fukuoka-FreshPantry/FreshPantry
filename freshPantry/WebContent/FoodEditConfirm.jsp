<!--
	@author 藤本
	変更内容確認画面
	@version 1.0
 -->
<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%-- FoodBeanをimport?? --%>
<%@ page import="fPBean.FoodBean"%>
<%
    FoodBean foodManage = (FoodBean) session.getAttribute("foodManage");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>変更内容確認</title>



</head>
<body>

 <p>登録します？</p>

   <form action="FoodEditConfirmService" method="post" />

   <table style="width:750px;" border="0" cellspacing="20">		<%--スマートフォンのサイズ=750px --%>

 <%--<tr>
       <td>食材No:<%=foodManage.getFoodNo()%></td>       ←必要ないかも
     </tr>  --%>

     <tr>
       <td>食材名:<%=foodManage.getFoodName()%></td>
     </tr>
     <tr>
       <td>残量:<%=foodManage.getQuantity()%></td>
     </tr>
     <tr>
       <td>購入日:<%=foodManage.getExpirationDate()%></td>
     </tr>
     <tr>
       <td>賞味期限:<%=foodManage.getPurchaseDate()%></td>
     </tr>
     <tr>
       <td>カテゴリー:<%=foodManage.getCategoryName()%></td>
     </tr>

    <input type="submit" value="登録" onload="window.alert("登録しました") />
    <input type="reset" value="キャンセル" onclick="window.confirm("キャンセルしますか？") />

	</table>
	</form>

	<input type="button" value="戻る" onclick="history.back()" />
</body>
</html>