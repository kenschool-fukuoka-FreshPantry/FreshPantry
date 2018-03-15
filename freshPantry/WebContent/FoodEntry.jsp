<!--
 @author 水谷
 @version 1.0
 -->

<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="fPBean.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>食材入力</title>
<link rel="stylesheet" type="text/css" href="fpbase.css" />

<script type="text/javascript">
var num = 1;
function input(){
	num++;
	var inputName = "num"+num;
	var input = document.createElement("input");
	input.setAttribute("type","text");
	input.setAttribute("name",inputName);
	document.getElementById("inputArea").appendChild(input);
	var p = document.createElement("br");
	document.getElementById("inputArea").appendChild(p);
}
</script>
<script type="text/javascript">
<!--
	function dataCheck(obj){
		var msg = "";
		if(obj.food_name.value.length < 1){
			msg += "食材名は必須項目です。\n";
		}
		if(!obj.quantity.value.match(/^[0-9]+$/g)||obj.unit.value == ""){
			msg += "残量は必須項目です。\n"
		}
		if(!obj.expiration_date.value.match(/^[0-9]+$/g)){
			msg += "賞味期限は必須項目です。\n";
		}
		if(obj.ｃategory_id.value == ""){
			msg += "カテゴリーは必須項目です。";
		}

		if(msg.length > 0){
			alert(msg);
			return false;
		}else{
			return true;
		}
}
//-->
</script>
</head>
<body>
<div align="center">
<h1><font color="orange">食材入力</font></h1>
<br/>
	<form action="FoodEntryService" method="post" onSubmit="return dataCheck(this);">
	<table border="0">
	<tr>
	<th align="left">・食材名<font color="red">（必須）</font></th>
		<td><input type="text" name="food_name" size="25" /></td>
		</tr>
	<tr>
	<th align="left">・残量（半角数字）<font color="red">（必須）</font></th>
 		<td><input type="text" name="quantity" size="5" />
 			<select name="unit">
        	 <option value="">単位</option>
<%
	ArrayList<UnitBean> ul = UnitBean.getUnitIdList();

	for(int i = 0; i <ul.size() ;i++){
		UnitBean u = ul.get(i);
		String unit=u.getUnit();

%>	<option value="<%=unit%>"><%=u.getUnitName() %></option>

<%
}
%>

       		 </select></td>
 	</tr>
 	<tr>
 	<th align="left">・購入日（半角数字）</th>
 		<td><input type="text" name="purchase_date" size="25" /></td>
 	</tr>
 	<tr>
 	<th align="left">　<font size="2">（入力例：20180316）</font></th>
 	</tr>
 	<tr>
 	<th align="left">・賞味期限（半角数字）<font color="red">（必須）</font></th>
 		<td><input type="text" name="expiration_date" size="25" /></td>
 	</tr>
 	<tr>
 	<th align="left">　<font size="2">（入力例：20180316）</font></th>
 	</tr>
 	<tr>
 	<th align="left">・カテゴリー<font color="red">（必須）</font></th>
 		<td><select name="ｃategory_id">

 		<option value="">選択してください</option>
<%
	ArrayList<CategoryBean> cl = CategoryBean.getCategoryIdList();

	for(int i = 0; i <cl.size() ;i++){
		CategoryBean c = cl.get(i);
		String category=c.getCategoryId();

%>
<% if("000".equals(category)){

%>
<%}else{

 %>
 <option value="<%=category%>"><%=c.getCategoryName() %></option>
<%} %>

<%
}
%>
        </select></td>
 	</tr>
 	<tr>
 	<th align="left">・栄養素</th>
<%
String name1 ="+1";
int cnt = 1;
%>

<br/>
	<form action="FoodEntryService" method="post">
		<td><input type="text" name="num1">
		<div id="inputArea">
		</div>
		<input type="button" value="栄養素追加" onClick="input()">
		<input type="reset" value="クリア" /></td>
	</form>
 	</tr>
</table>
 </form>
<br/><br/>
	<p><input type="button" onClick="location.href='Entry.jsp'" value="戻る" />
	 <button type=submit name ="buttonOn" value ="001">登録</button>

	<br/>
</div>
</body>
</html>
