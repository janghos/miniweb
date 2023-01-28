<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title ㅇㅇㄴ</title>
</head>
<body>
<h1>하이</h1>
	<c:forEach items="${list}"  var="member">
		<p>${member.me_id}</p>
		<p>${member.me_name}</p>
	</c:forEach>
</body>
</html>