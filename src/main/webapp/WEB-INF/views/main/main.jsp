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
<sec:authorize access="isAnonymous()">
<a href='<c:url value="/memberInfo/login/loginPage"/>'>login</a></br> 
<a href='<c:url value="/member/page"/>'>GUEST</a></br> 
<a href='<c:url value="/member/user/page"/>'>USER</a></br>
<a href='<c:url value="/member/member/page"/>'>MEMBER</a></br>
<a href='<c:url value="/admin/page"/>'>ADMIN</a></br> 
</sec:authorize>
<sec:authorize access="isAuthenticated()">
		<li><a href="javascript:logout();">로그아웃</a></li>	
</sec:authorize>
<form id="logoutFrm" action="${pageContext.request.contextPath}/member/logout" method="post" style:"display:none">
	<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }">
</form>
</body>
</html>