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

	<h1><font color="blue">食材変更</h1>

	<table style="width:750px;" border="1" cellspacing="10">
	 <tr>
	   <td>食材名</td>
	   <td><input type="text" name="food_name" /></td>
	 </tr>
	 <tr>
	   <td>残量(半角数字) <font color="red">（必須）</font></td>
	   <td><input type="text" name="quantity" size="5" /></td>
	   <td><select name="unit">
        	 <option value="0">単位</option>
        	 <option value="1">ｇ</option>
        	 <option value="2">個</option>
         	 <option value="3">本</option>
         	 <option value="4">匹</option>
        	 <option value="5">ｍｌ</option>
         	 <option value="6">丁</option>
         	 <option value="7">尾</option>
         	 <option value="8">束</option>
         	 <option value="9">枚</option>
         	 <option value="10">杯</option>
		</td>
       	   </select>
	 </tr>
	 <tr>
	   <td>購入日 (半角数字)</td>
	    <td><input type="text" name="purchase_date" size="25" /></td>
	  </tr>
	  <tr>
	    <td>賞味期限 (半角数字) <font color="red">（必須）</font></td>
	    <td><input type="text" name="expiration_date" size="25" /></td>
	  </tr>
	    <td>カテゴリー <font color="red">（必須）</font></td>
	    <td><select name="category_id">
	   		<option value="0">選択してください</option>			<%-- 消えるかも。必須項目の為 --%>
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
	  </br>
	<input type="submit" value="次へ" /></div>
	</form>

	<button><a href="Main.jsp">戻る</button>
  </div>
</body>
</html>