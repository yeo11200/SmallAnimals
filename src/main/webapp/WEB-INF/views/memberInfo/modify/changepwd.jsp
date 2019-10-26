<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
table{
	width:400px;
	height:300px;
}
td {
	text-align: right;
}
</style>
<script language="javacript">
	function close(){
		self.close();
	}
</script>

<script type="text/javascript">
	
	//클릭시 캡챠 글자 변경
	/*  $("#imgCaptcha").on('click',function(e){
		$(this).attr("src", "${pageContext.request.contextPath}/captcha/index");
	}); */
	
	
	 $(document).ready(function() {
	        $("#imgCaptcha").on('click',function() {
	        	$(this).attr("src", "${pageContext.request.contextPath}/captcha/index");
	        });
	    });
	
	function doJoin(){
		if($("#isCheckedId").val() == "N"){
			alert("ID 체크를 먼저 해주세요");
		}
		if($("#joinBlock").valid()){
			
			$.get("${pageContext.request.contextPath}/captcha/isRight",{captcha : $("#captcha").val()}, function(){
				// 캡챠 성공시
				if(data == 1){
					var url="/memberInfo/join/changepwd";
					$.post(url,$("#joinBlock".serialize(),function(data){
						if(data ==1){
							alert("회원가입에 성공하였습니다.");
							document.location.href="/index";
						}else{
							alert("회원가입에 실패하였습니다. 관리자에게 문의해주세")
						}
					}));	
				}else{
					alert("캡챠 문자가 다릅니다.")
				}
			});
		}
	}
</script>
<script type="text/javascript">
//비밀번호 일치 확인 fuction
    $(function(){
        $("#alert-success").hide();
        $("#alert-danger").hide();
        $("input").keyup(function(){
            var user_pwd=$("#user_pwd").val();
            var user_pwdchk=$("#user_pwdchk").val();
            if(user_pwd != "" || user_pwdchk != ""){
                if(user_pwd == user_pwdchk){
                    $("#alert-success").show();
                    $("#alert-danger").hide();
                    $("#submit").removeAttr("disabled");
                }else{
                    $("#alert-success").hide();
                    $("#alert-danger").show();
                    $("#submit").attr("disabled", "disabled");
                }
            }
        });
    });
</script>
</head>
<body>

	<form action="" method="post">
		<table align="center" border="1">
			<tr>
				<td>현재 비밀번호 :</td>
				<th><input type="password" id="user_pwd" name=""></th>
			</tr>
			<tr>
				<td>변경 할 비밀번호 :</td>
				<th><input type="password" id="user_pwd" name=""></th>
			</tr>
			<tr>
				<td>변경 할 비밀번호 확인 :</td>
				<th><input type="password" id="user_pwdchk" name=""></th>
			</tr>
			<tr>
				<td colspan="2">
					<div>
						<img src="${pageContext.request.contextPath}/captcha/index" alt="캡챠 이미지" id="imgCaptcha" style="cursor:pointer;"/>
						<input type="text" name="captcha"id="captcha" placeholder="이미지 문자 작성을 입력하세요" style="width:200px" required>
						<input type="button" id="imgCaptcha" value="새로고침" onclick="" style="margin:0 50px 0 0; ">
						<label style="cursor:pointer;" id="imgCaptcha">버튼</label>
						<input type="button" id="*" name="*" value="확인" onclick="" style="width:70px;">
					</div>
				</td>
			</tr>
			<tr>
				<td colspan="2">
				<input type="submit" id="" name="" value="변경">
				<input type="button" value="취소" id="*" name="*" onclick="window.close()">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>