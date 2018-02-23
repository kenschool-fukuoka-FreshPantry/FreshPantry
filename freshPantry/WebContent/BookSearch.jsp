<!--
	@author 佐藤裕章
	中級演習問題5　問題3
 -->
<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>書籍検索</title>
</head>
<body>
		<h2>書籍検索</h2>

		<form action="BookListServlet" method="post">
			<input type="text" name="title" size="20">
			<input type="submit" value="検索">
		</form>

</body>
</html>