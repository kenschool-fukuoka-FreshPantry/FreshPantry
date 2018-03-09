<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String delMessage = (String)request.getAttribute("message");
 %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>
</head>
<body>

<%
if (delMessage == null){
%>
	・メッセージは空です。

<%
}else{
%>
	<%= delMessage %>

<%
}

%>


<hr/>


<form action="TestButton" method="post">
ボタン削除？を押すと、値1が渡って削除ボタンおしました。になる。
<br />
<button type=submit name ="buttonOn" value ="1">
ボタン削除？
</button>


<hr />
ボタン次へ！を押すと、値2がわたって次への何かがでます。になる。
<br />
<button type=submit name ="buttonOn" value ="2">
ボタン次へ！
</button>
</form>

</body>
</html>