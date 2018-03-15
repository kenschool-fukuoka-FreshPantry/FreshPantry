<!--
	@author 藤本
	@version 1.0
	登録内容変更・削除画面
	未完成
 -->
<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>	登録内容変更・削除</title>
  <link rel="stylesheet" type="text/css" href="fpbase.css" />


</head>

<body>

	<div align="center">

	<h1><font color="blue">登録内容変更・削除</h1>
	<form id=" " name=" " action="EditMenuService" method="post">
	<table style="width:750px;" border="0"  cellspacing="20">		<%--スマートフォンのサイズ=750px --%>

	 <tr>
	 <hr/>
	  <th><a href="FoodSelect.jsp">食材変更・削除</th>				<%-- 水谷さん式に変更するかも --%>
	 </tr>
	 <tr>
	 <th><a href="RecipSelect.jsp">レシピ変更・削除</th>			<%-- 上に同じ --%>
	 </tr>
	  <tr>
	   <th><a href="NutrientSelect.jsp">栄養素変更・削除</th>			<%-- 上に同じ --%>
	  </tr>
	  </table>
	  </br>

	</form>
	 </div>
	 <hr/>
	 <br/>
	<input type="button" onClick="location.href='Main.jsp'" value="戻る">

</body>
</html>