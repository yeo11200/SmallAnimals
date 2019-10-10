<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="org.springframework.security.core.context.SecurityContextHolder" %>
<%@ page import="org.springframework.security.core.Authentication" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    Object principal = auth.getPrincipal();
 
    String name = "";
    if(principal != null) {
        name = auth.getName();
    }
%>
<body>
<h2>메인입니다</h2>
<a href='<c:url value="/page"/>'>GUEST</a></br> 
<a href='<c:url value="/user/page"/>'>USER</a></br>
<a href='<c:url value="/member/page"/>'>MEMBER</a></br>
<a href='<c:url value="/admin/page"/>'>ADMIN</a></br> 
<sec:authorize access="isAnonymous()">
<a href='<c:url value="/memberInfo/login/loginPage"/>'>login</a></br> 
<a href='<c:url value="/register"/>'>회원가입</a></br> 

</sec:authorize>
<sec:authorize access="isAuthenticated()">
<form id="logoutFrm" action="${pageContext.request.contextPath}/logout" method="post" style:"display:none">
	<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }">
	<button type="submit">LOGOUT</button>
</form>
</sec:authorize>

</body>
</html>