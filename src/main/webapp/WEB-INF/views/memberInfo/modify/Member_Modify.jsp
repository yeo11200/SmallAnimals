<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/join.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/base.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/pdsr.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/button.css">
	
    <link href="https://cdn.rawgit.com/openhiun/hangul/14c0f6faa2941116bb53001d6a7dcd5e82300c3f/nanumbarungothic.css" rel="stylesheet" type="text/css">
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet">
<style>
	 th{
 	
 	text-align:center;
 	width:50px;
 }
</style>
<style>
body{
width:100%;
}
</style>
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
    //본 예제에서는 도로명 주소 표기 방식에 대한 법령에 따라, 내려오는 데이터를 조합하여 올바른 주소를 구성하는 방법을 설명합니다.
    function sample4_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var roadAddr = data.roadAddress; // 도로명 주소 변수
                var extraRoadAddr = ''; // 참고 항목 변수

                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraRoadAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                   extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if(extraRoadAddr !== ''){
                    extraRoadAddr = ' (' + extraRoadAddr + ')';
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('sample4_postcode').value = data.zonecode;
                document.getElementById("sample4_roadAddress").value = roadAddr;
                document.getElementById("sample4_jibunAddress").value = data.jibunAddress;
                
                // 참고항목 문자열이 있을 경우 해당 필드에 넣는다.
                if(roadAddr !== ''){
                    document.getElementById("sample4_extraAddress").value = extraRoadAddr;
                } else {
                    document.getElementById("sample4_extraAddress").value ='';
                }

                var guideTextBox = document.getElementById("guide");
                // 사용자가 '선택 안함'을 클릭한 경우, 예상 주소라는 표시를 해준다.
                if(data.autoRoadAddress) {
                    var expRoadAddr = data.autoRoadAddress + extraRoadAddr;
                    guideTextBox.innerHTML = '(예상 도로명 주소 : ' + expRoadAddr + ')';
                    guideTextBox.style.display = 'block';

                } else if(data.autoJibunAddress) {
                    var expJibunAddr = data.autoJibunAddress;
                    guideTextBox.innerHTML = '(예상 지번 주소 : ' + expJibunAddr + ')';
                    guideTextBox.style.display = 'block';
                } else {
                    guideTextBox.innerHTML = '';
                    guideTextBox.style.display = 'none';
                }
            }
        }).open();
    }
</script>
<body>
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>

<div align="center">
	<form action="${pageContext.request.contextPath}/registerMember" method="post" >
<input type="hidden" name="${_csrf.parameterName}"	value="${_csrf.token}">
	<h3>정보수정</h3>
				<table border="1" style="width:800px; height:500px;">
				
				<tr>
						<th><label for="user_id">아이디</label></th>
						<td>
							<input type="email" id="user_id" name="userId"  readonly>
						</td>
					</tr>
					<tr>
						<th>비밀번호</th>
						<td colspan="3">
							<input type="button" value="비밀번호 변경" id="chngpwd" onclick="window.open('changepwd','정보수정','width=600,height=500,location=no,status=no,scrollbars=yes');" style="margin: 0 0 0 10px;">	
						</td>
						
					
					</tr>
					<tr>
						<th>닉네임</th>
						<td><input type="text" id="user_nickname"name="userNickname"></td>
					</tr>
					<tr>
						<th>이름</th>
						<td><input type="text" id="user_name"name="userName" name="userName"></td>
					</tr>
					<tr>
						<th>전화번호</th>
						<td>
							<input type="tel" id="mm" name="userPhone" class="sel" aria-label="월" id="userPhone" style="width: 100px;">
							-
							<input type="tel" name="*" name="userPhone" id="userPhone" maxlength="4" /> 
							- 
							<input type="tel" name="*" name="userPhone" id="userPhone" maxlength="4" />
						</td>
					</tr>
					<tr>
						<th>생년월일</th>
						<td>
							<input type="text" id="yy" aria-label="년(4자)" class="int" maxlength="4" >
							/
							<input type="text" id="mm" class="sel" aria-label="월" style="width: 100px; height: 30px;">
							/
							<input type="text" id="mm" class="sel" aria-label="월" style="width: 100px; height: 30px;">
						</td>
					</tr>
					
					<tr>
						<th>주소</th>
						<td style="height:100px;">
							<input type="text" id="sample4_postcode" placeholder="우편번호">
							<input type="text" id="sample4_roadAddress" placeholder="도로명주소" style="width:300px;">
							<input type="text" id="sample4_jibunAddress" placeholder="지번주소" style="width:300px;">
							<span id="guide" style="color:#999;display:none;"></span><br>	
							<input type="text" id="sample4_detailAddress" placeholder="상세주소" style="width:300px;">
							<input type="text" id="sample4_extraAddress" placeholder="참고항목" style="width:300px;"><br>
							<input type="button" onclick="sample4_execDaumPostcode()" value="주소변경(이전)">
						</td>
					
					</tr>
					<tr>
						<th colspan="2" align="right">
							<input type="submit" value="정보수정" onclick="chkValidate()">
							<input type="button" value="취소" onclick="location.href='../../main/main'">
						</th>
					</tr>
		</table>
				
	</form>
</div>
</body>
</html>