<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title ������</title>
</head>
<body>
<h1>ȸ����� ����Ʈ</h1>
	<c:forEach items="${list}"  var="member">
		<p>ȸ�� ID : ${member.me_id}</p>
		<p>ȸ�� �̸� : ${member.me_name}</p>
	</c:forEach>
</body>
</html>