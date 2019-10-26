<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:url value="/login" var="loginUrl" />
<form class="px-4 py-3" action="${loginUrl}" method="post">
   
    <input type="text" class="form-control" name="loginId" placeholder="example">
   
    <input type="password" class="form-control" name="loginPwd" placeholder="Password">
  
    <input name="${_csrf.parameterName}" type="hidden" value="${_csrf.token}"/>
    <button type="submit" class="btn btn-primary">Sign in</button>
	<c:if test="${not empty SPRING_SECURITY_LAST_EXCEPTION}">
    	<font color="red">
        	<p>Your login attempt was not successful due to <br/>
            ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}</p>
        	<c:remove var="SPRING_SECURITY_LAST_EXCEPTION" scope="session"/>
    	</font>
	</c:if>


</form>

</body>
</html>