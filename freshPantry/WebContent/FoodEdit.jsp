<!--
	@author 藤本
	@version 1.0
	食材変更画面
	未完成
 -->
<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	<%-- FoodBeanをimport?? --%>
<%@ page import="fPBean.FoodBean"%>

	<%-- foodManageか確認未 --%>
<%
    FoodBean foodManage = (FoodBean) session.getAttribute("foodManage");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>食材変更</title>
  <link rel="stylesheet" type="text/css" href="fpbase.css" />

<script type="text/javascript">
<!--
	function dataCheck(obj){
		var msg = "";
		if(obj.food_name.value.length < 1){
			msg += " 食材名は必須項目です。\n";
		}
		if(!obj.quantity.value.match(/^[0-9]+$/g)){
			msg += "残量は必須項目です。"
		}
		if(!obj.expiration_date.value.match(/^[0-9]+$/g)){
			msg += "残量は必須項目です。"
		}

}
</script>


</head>
<body>

	<div align="center">

	<h1><font color="blue">食材変更</font></h1>
	<hr/>

	<form action="FoodEditService" method="post" onsubmit="return dataCheck(this);">

	<table style="width:750px;" border="0" cellspacing="20">		<%--スマートフォンのサイズ=750px --%>
	 <tr>
	   <th align="left">食材名<font color="red">（必須）</font>
	   </th>
	     <td>
	<%--   <input type="text" name="food_name" value="<%=food_name%>" /> --%>

	     </td>
	 </tr>
	 <tr>
	   <th align="left">
	     残量(半角数字) <font color="red">（必須）</font>
	   </th>
	     <td>
	     <input type="text" name="quantity" value="<%= %>" size="5" />
	   	   <select name="unit" value="<%= %>">
        	 <option value="0">単位</option>		<%-- 消えるか、もしくはquantity --%>
        	 <option value="1">ｇ</option>
        	 <option value="2">個</option>			<%-- valueの値は変更するかも --%>
         	 <option value="3">本</option>
         	 <option value="4">匹</option>
        	 <option value="5">ｍｌ</option>
         	 <option value="6">丁</option>
         	 <option value="7">尾</option>
         	 <option value="8">束</option>
         	 <option value="9">枚</option>
         	 <option value="10">杯</option>
       	   </select>
         </td>
	  </tr>
	 <tr>
	   <th align="left">購入日 (半角数字)
	   </th>
	    <td><input type="text" name="purchase_date" value="<%= %>" size="25" />
	    </td>
	  </tr>
	  <tr>
	    <th align="left">賞味期限 (半角数字) <font color="red">（必須）</font>
	    </th>
	      <td><input type="text" name="expiration_date" value="<%= %>" size="25" />
	      </td>
	  </tr>
	    <th align="left">カテゴリー <font color="red">（必須）</font>
	    </th>
	      <td>
	      <select name="category_id" value="<%= %>" />
	   		<option value="0">選択してください</option>				<%-- 消えるか、もしくはcategory_name --%>
			<option value="1">肉類</option>
         	<option value="2">魚介類</option>
         	<option value="3">野菜類</option>
         	<option value="4">乳製品・卵</option>
         	<option value="5">加工品</option>
         	<option value="6">飲料</option>
         	<option value="7">その他</option>
          </select>
		  </td>
	  </table>
	  <br/>

	<div align="right"><input type="submit" value="次へ" /></div>
	</div>
	</form>
	<hr/>
	<br/>
	<input type="button" value="戻る" onclick="history.back()" />

  </div>
</body>
</html>