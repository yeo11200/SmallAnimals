<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
<textarea rows="3" cols="4" id="summernote" name="content"></textarea>
<input type="button" style="width:200px; line-height:200px;">
<script type="text/javascript" src="<c:url value='/resources/js/notice/notice.js' />"></script>
</body>
</html>
