<!--
	@author 藤本
	食材選択画面
	@version 1.0
	森川
 -->
<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page import="fPBean.FoodBean"%>

<%
	List<FoodBean> foodList = (List<FoodBean>)request.getAttribute("foodList");
 %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>食材選択</title>

<script type="text/javascript">
<!--

function checkForm(){
	if( window.alert('選択してください')){     // 警告ダイアログを表示
		return false;
	}
}
function checkForm2(){
	if(window.confirm('削除しますか？')){     // 確認ダイアログを表示
		return true;     // 「OK」時は削除を実行
	}
	return false;
}
// -->
</script>
</head>
<body>
		<h2>食材選択</h2>

		<form action="FoodDeleteService" method="post">
		<table style="width:750px" border="1">			<%--スマートフォンのサイズ=750px --%>
<%
	if (foodList != null) {
		for(int i=0; i< foodList.size(); i++){
			FoodBean foodBean = foodList.get(i);
 %>

		<tr>
			<td><input type="radio" name="food" value="<%=foodBean.getFoodName() %>">
			</input>
			</td>
		</tr>

<%
			}
		}


 %>
 		<form action= "/FoodDeleteService.java" method="get">
 		<input type="hidden" value="002" />
		<input type="submit" name="input-submit" value="次へ" onclick="return checkForm();" />
		</form>

		<form action= "/FoodDeleteService.java" method="get">
		<input type="hidden" value="001" />
 		<input type="reset" name="input-reset" value="削除" onclick="return checkForm()" onclick="return checkForm2();" />
 		</form>

 	<%--  もしくは、onclick="return confirm('削除しますか？');">  --%>

 		</input>
		</table>
		</form>

		<input type="button" value="戻る" onclick="history.back()" />
</body>
</html>