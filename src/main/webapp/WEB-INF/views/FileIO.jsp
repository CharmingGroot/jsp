<%@ page language = "java" contentType = "text/html; charset=UTF-8" pageEncoding="UTF-8"%> 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일IO</title>
</head>
<body>

	<form action="/file/upload" method="post" enctype="multipart/form-data" >
		<input type="file"  name="atchFile"  />
		<button type="submit"> 제출</button>
	</form>

</body>
</html>