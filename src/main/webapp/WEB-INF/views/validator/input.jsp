<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>input.jsp</title>
</head>
<body>
<form action="inputsave" method="post" name="form1">
	<table border="1" width="300px" align="center">
		<caption>검증예제입력</caption>
		<tr>
			<th>이름</th>
			<td><input type="text" name="name"> </td>
		</tr>
		<tr>
			<th>나이</th>
			<td><input type="text" name="age"> </td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="submit" value="전송">
				<input type="reset" value="취소">
				<input type="button" value="메인으로" onclick="location.href='./main'">
			</td>
		</tr>
	</table>
</form>
</body>
</html>