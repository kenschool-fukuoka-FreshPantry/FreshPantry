<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>
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
<%
String name1 ="+1";
int cnt = 1;
%>
    <div id="piyo">
        <table border="1">
            <tr id="histrow1">
                <td id="num"><%= cnt %></td>
                <td><input type="text" name="nutrient<%= cnt %>" id="nutrienttxt"></td>
            </tr>
        </table>
    </div>

<input type="button" value="<%= name1%>" onClick="add();">


<button type="button" name="aaa" value="aaa">
☆
</button>

</br>
<hr/>
<form action="TestMenu2" method="post">
↓増加分の改行がわかってない……
</br>
<input type="text" name="num1" value="v1">
<div id="input">
</div>
<input type="button" value="増加" onClick="input()">
<input type="submit" value="表示" />
</form>



</body>
</html>