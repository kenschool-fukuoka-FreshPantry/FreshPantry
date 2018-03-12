<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>食材入力</title>
<script type="text/javascript">
function add()
{
    var div_element = document.createElement("div");
    div_element.innerHTML = '<table border="1">'
     +'<tbody  id="histTablebody"><tr id="histrow1"><td id="num">1</td><td><input type="text" name="COMPANY_NAME1" id="txt"></td></tr></tbody></table>';
    var parent_object = document.getElementById("piyo");
    parent_object.appendChild(div_element);
}
var num = 1;
function add2()

{
	num++;
	var nutrientName = "nutrient"+num;
	var nutrientNametxt = "nutrienttxt"+num;

	var input = document.createElement("div");
	input.setAttribute("type","text");
	input.setAttribute("name",nutrientName);
	input.setAttribute("id",nutrientNametxt);
	parent_object.appendChild(input);
}

function input(){
	num++;
	var inputName = "num"+num;
	var input = document.createElement("input");
	input.setAttribute("type","text");
	input.setAttribute("name",inputName);
	input.setAttribute("value",inputName);
	document.getElementById("input").appendChild(input);

	var br = document.createElement("p");
	document.getElementById("p").appendChild(br);
}
</script>
</head>
<body>


<%-- サーブレットとつなげられているか --%>
<%-- 栄養素の入力欄の表示方法探し中--%>
<%-- 戻る、次へボタンで画面遷移するか --%>
<%-- 必須項目の入力チェックとポップアップの表示未設定 --%>



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
	<th align="left">・残量<font color="red">（必須）</font></th>
 		<td><input type="text" name="quantity" size="5" />
 			<select name="unit">
        	 <option value="">単位</opution>	<%-- value=""bean見て入力する --%>
        	 <option value="">ｇ</option>
        	 <option value="">個</option>
         	 <option value="">本</option>
         	 <option value="">匹</option>
        	 <option value="">ｍｌ</option>
         	 <option value="">丁</option>
         	 <option value="">尾</option>
         	 <option value="">束</option>
         	 <option value="">枚</option>
         	 <option value="">杯</option>

       		 </select></td>
 	</tr>
 	<tr>
 	<th align="left">・購入日</th>
 		<td><input type="text" name="purchase_date" size="25" /></td>
 	</tr>
 	<tr>
 	<th align="left">・賞味期限<font color="red">（必須）</font></th>
 		<td><input type="text" name="expiration_date" size="25" /></td>
 	</tr>
 	<tr>
 	<th align="left">・カテゴリー<font color="red">（必須）</font></th>
 		<td><select name="ｃategory_id">
         <option value="">選択してください</opution>
         <option value="">肉類</option>					<%-- value=""bean見て入力する --%>
         <option value="">魚介類</option>
         <option value="">野菜類</option>
         <option value="">乳製品・卵</option>
         <option value="">加工品</option>
         <option value="">飲料</option>
         <option value="">その他</option>
        </select></td>
 	</tr>
 	<tr>
 	<th align="left">・栄養素</th>
<%
String name1 ="+1";
int cnt = 1;
%>

</br>

	<form action="TestMenu2" method="post">
		<td><input type="text" name="num1" value="v1">
		<div id="input">
		</div>
		<input type="button" value="栄養素追加" onClick="input()">
		<input type="reset" value="クリア" /></td>
	</form>
 	</tr>
</table>
 </form>
</br></br>
	<p><input type="button" value="戻る" onClick="history.back()" />
	<input type="submit"  value="次へ" /></p>
	<br/>
</div>
</body>
</html>
