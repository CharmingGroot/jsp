<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/hello/request/file"  method="post" enctype="multipart/form-data">
		<table>
			<tr>
				<td>
					<input  name="userNm"  type="text"   placeholder="이름" />
				</td>				
			<tr>
			<td>
				<input type="file" name="file"/>			
			</td>
			</tr>				
			</tr>
			<tr>
				<td>
				<button type="submit">전송</button>			
				</td>
			</tr>
		</table>
	</form>
</body>
</html>