<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>新規登録・変更・削除</title>
<link rel="stylesheet" type="text/css" href="fpbase.css" />

</head>
<body>
<div align="center">
<h1><font color="green">新規登録・変更・削除</font></h1>
<br/>
<form action="EntryEditMenuService" method="post">

  <input type="hidden" name="sub_menu_id" value="001" />
	<input type="submit" value="     食材入力     " />
  <br/><br/><br/>
	<input type="hidden" name="sub_menu_id" value="002" />
	<input type="submit" value="    レシピ入力    " />
  <br/><br/><br/>
  <input type="hidden" name="sub_menu_id" value="003" />
	<input type="submit" value="登録内容変更・削除" />
  <br/><br/>
</form>

<br/>
<p><input type="button" onClick="location.href='Main.jsp'" value="戻る" /></p>
</div>

</body>
</html>
