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
<a href='<c:url value="/memberInfo/login/loginPage"/>'><button class="btn btn-primary">login</button></a>
<a href='<c:url value="/memberInfo/join/register1"/>'><button class="btn btn-primary">회원가입</button></a>
</sec:authorize>

<sec:authorize access="isAuthenticated()">
<form id="logoutFrm" action="${pageContext.request.contextPath}/logout" method="post">
   <input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }">
   <button type="submit" class="btn btn-primary">LOGOUT</button>
<input type="button" value="정보수정" class="btn btn-primary" onclick="location.href='../memberInfo/modify/Member_Modify'">
<button type="button" class="btn btn-primary" id="modal">모달창 열기</button>
<div id="modalshow"></div>
</form>
</sec:authorize>


<script>
document.getElementById('modal').onclick = function() {
	var xhr = new XMLHttpRequest();
	xhr.open('get', '/modal/modal');
	xhr.send();
	xhr.onload = function () {
		console.log(xhr.responseText);
		document.getElementById('modalshow').innerHTML = xhr.responseText;
		
		document.getElementById('close').addEventListener('click', function () {
			document.getElementById('noticeModal').style.display = 'none';
			
		});
	}
}

</script>
</body>
</html>