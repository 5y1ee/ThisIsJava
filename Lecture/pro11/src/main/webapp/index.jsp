<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> <!-- 디렉티브 태그 -->
<%@ page import="java.util.Date" %>

<%

request.setAttribute("name", "Aaron");
session.setAttribute("name", "Judge");

member.MemberVO vo = new member.MemberVO();
vo.setName("Gerrit");
session.setAttribute("loginSession", vo);

java.util.Map map = new java.util.HashMap();
map.put("id", "Cole");
request.setAttribute("data", map);

%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
String name = "이름";
System.out.print(name);
out.println(name);
Date date = new Date();
%> <!-- 스크립트릿 Scriptlet -->
<%=name %> <!-- 표현식 -->
<%="<h1>"+date+"</h1>"%> <!-- 표현식 -->

name : ${name} <br>
session.name : ${sessionScope.name} <br>

sessionScope.loginSession : ${sessionScope.loginSession.name} <br>
맵에 있는 아이디 : ${requestScope.data.id }




</body>
</html>