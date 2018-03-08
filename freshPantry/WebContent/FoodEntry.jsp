<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>食材入力</title>


<%-- ここにエラーチェック入れる --%>

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
		if(obj.ｃategory_id.selectedIndex == 0){
			msg += "カテゴリーは必須項目です。"
		}
}
</script>

</head>
<body>


<%-- サーブレットとつなげられているか --%>
<%-- 栄養素の入力欄の表示方法探し中--%>
<%-- 戻る、次へボタンで画面遷移するか --%>
<%-- 必須項目の入力チェックとポップアップの表示未設定 --%>


<h1><font color="orange">食材入力</font></h1>
<br/>
	<form action="FoodEntryService" method="post" onSubmit="return dataCheck(this);">
	<p>・食材名<font color="red">（必須）</font>
		<input type="text" name="food_name" size="25" />
	</p>
 	<br/>
 	<p>・残量（半角数字）<font color="red">（必須）</font>
 		<input type="text" name="quantity" size="5" />
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

       		 </select>
 	</p>
 	<br/>
 	<p>・購入日（半角数字）
 		<input type="text" name="purchase_date" size="25" />
 	</p>
 	<br/>
 	<p>・賞味期限（半角数字）<font color="red">（必須）</font>
 		<input type="text" name="expiration_date" size="25" />
 	</p>
 	<br/>
 	<p>・カテゴリー<font color="red">（必須）</font>
 	<select name="ｃategory_id">
         <option value="">選択してください</opution>
         <option value="">肉類</option>					<%-- value=""bean見て入力する --%>
         <option value="">魚介類</option>
         <option value="">野菜類</option>
         <option value="">乳製品・卵</option>
         <option value="">加工品</option>
         <option value="">飲料</option>
         <option value="">その他</option>
        </select>
 	</p>
 	<br/>
 	<p>・栄養素</p>
 	<input type="submit" value="栄養素追加" />
 	<input type="reset" value="クリア" />
 	<br/><br/><br/><br/>

 </form>

	<input type="button" value="戻る" onClick="history.back()" />
	<input type="submit"  value="次へ" />

</body>
</html>
