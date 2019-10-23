<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table>
<tbody>
	<tr class="tr" attr="gkgk">
		<td>하하</td>
	</tr>
	<tr class="tr" attr="gkgk">
		<td>하하</td>
	</tr>
	<tr class="tr" attr="gkgk">
		<td>하하</td>
	</tr>
	<tr class="tr" attr="gkgk">
		<td>하하</td>
	</tr>
	<tr class="tr" attr="gkgk">
		<td>하하</td>
	</tr>
	<tr class="tr" attr="gkgk">
		<td>하하</td>
	</tr>
	<tr class="tr" attr="gkgk">
		<td>하하</td>
	</tr>
	<tr class="tr" attr="gkgk">
		<td>하하</td>
	</tr>
</tbody>
</table>
<script type="text/javascript">
	let tr = document.getElementsByClassName('tr');
	
	for(let i=0; i < tr.length; i++) {
		tr[i].addEventListener('click', function() {
			let no = tr[i].getAttribute('attr');
			alert(no);
		});
	}
</script>
</body>
</html>