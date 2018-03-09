<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="fPBean.FoodBean"%>
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
<title>Insert title here</title>
</head>
<body>
result:
<%= res %>
<hr/>
<%
if ("2".equals(res)){
%>
	</br>(単品で渡した)次への<%= food_name %>がでます。(<%= no %>)
	</br>(Beanで渡した)次への<%= fBean.getFoodName() %>がでます。(<%= fBean.getFoodNo() %>)
<%
}
%>
<hr/>
<form action="buttonIn.jsp">
<button type = "submit">戻る</button>

</form>
</body>
</html>