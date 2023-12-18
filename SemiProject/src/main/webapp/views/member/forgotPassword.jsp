<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
    String message = (String) request.getAttribute("message");
    if (message != null) {
%>
    <div class="message">
        <%= message %>
    </div>
<%
    }
%>
</body>
</html>