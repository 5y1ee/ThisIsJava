<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div id="wrap">
	<%
		String name = "이상윤";
	%>
	<!-- 디렉티브 태그로는 변수를 쓸 수 있게 됨... 소스를 먼저 불러오기 때문 -->
	<%-- @이 주석은 아예 보이지 않음. --%>
	<%--@ include file="/include/header.jsp" --%>
	
	<jsp:include page="/include/header.jsp">
		
	</jsp:include>
	
	<div id="container">
		????
	</div>
</div>
</body>
</html>