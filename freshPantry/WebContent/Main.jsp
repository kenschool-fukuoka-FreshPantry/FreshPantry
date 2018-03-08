<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>メニュー</title>
</head>
<body>
<center>
<h1><font color="blue">メニュー</font></h1>
<br/>
<form action="MainService" method="post">
	<input type="hidden" name="menu_id" value="001" />
	<input type="submit" value="新規登録・変更・削除" />
	<br/><br/><br/>
	<input type="hidden" name="menu_id" value="002" />
	<input type="submit" value="レシピ検索" />
	<br/><br/><br/>
	<input type="hidden" name="menu_id" value="003" />
	<input type="submit" value="庫内リスト" />
	<br/><br/><br/>
	<input type="hidden" name="menu_id" value="004" />
	<input type="submit" value="必要リスト" />
	<br/><br/><br/>
	<p><font color="red">※登録されたデータは残量が"０"になってから３カ月後に消去されます。</font></p>

</form>
</center>
</body>
</html>