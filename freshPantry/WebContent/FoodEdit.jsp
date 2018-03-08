<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>食材変更</title>



</head>

<body style="background-image:  ;
            "background-position:bottom;">

	<div align="center">
	<td  style="padding: 10px 5px 10px 5px;
	border-bottom: 2px #c0c0c0 dashed; background-color:#E0FFFF;">

	<h1><font color="blue">食材変更</h1>

	<form id=" " name=" " action="EditMenuService" method="post">

	<table style="width:750px;" border="0">
	 <tr>
	   <th>食材名</th> <td><input type="text" name="name" size="20"></td>
	 </tr>
	 <tr>
	   <th>残量</th> <td><input type="text" name="name" size="20"></td>
	 </tr>
	 <tr>
	   <th>購入日</th> <td><input type="text" name="name" size="20"></td>
	  </tr>
	  <tr>
	    <th>賞味期限</th> <td><input type="text" name="name" size="20"></td>
	  </tr>
	    <th>カテゴリー</th>
	    <td><select name="category">
	   		<option value="0">選択してください</option>






		</td>

	  </table>
	  </br>
	<input type="submit" value="次へ"></div>
	</form>

	<button><a href="Main.jsp">戻る</button>
  </div>
</body>
</html>