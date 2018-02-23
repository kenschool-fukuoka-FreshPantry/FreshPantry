<!--
	@author 佐藤裕章
	中級演習問題5　問題4
 -->
<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>書籍登録</title>
</head>
<body>
		<h2>書籍登録</h2>

		<form action="BookEntryResultServlet" method="post">
			<table border=1>
				<tr>
					<td>ID</td>
					<td><input type="text" name="id" size="5"></td>
				</tr>
				<tr>
					<td>タイトル</td>
					<td><input type="text" name="title" size="40"></td>
				</tr>
				<tr>
					<td>価格</td>
					<td><input type="text" name="price" size="10"></td>
				</tr>
			</table>
			<br>
			<input type="submit" value="登録">
		</form>

</body>
</html>