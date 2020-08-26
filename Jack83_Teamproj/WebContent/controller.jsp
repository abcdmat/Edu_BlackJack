<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%  
// 1. 요청을 받는다(param)
// 2. 요청에 따른 분기
// 3. dao 실행
// 4. 결과값 담기
// 5. 이동
	String command = request.getParameter("command");
System.out.println("요청 값 : "+command);
if(command.trim().equalsIgnoreCase("boardList")){
	
	
	
}

%>
</body>
</html>