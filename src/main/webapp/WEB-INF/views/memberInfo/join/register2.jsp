<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
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
th {
	text-align: center;
}
</style>

<script type="text/javascript">
		function caps_lock(e) {
		    var keyCode = 0;
		    var shiftKey = false;
		    keyCode = e.keyCode; 
		    shiftKey = e.shiftKey;
		    if (((keyCode >= 65 && keyCode <= 90) && !shiftKey)
		            || ((keyCode >= 97 && keyCode <= 122) && shiftKey)) {
		        show_caps_lock();
		        setTimeout("hide_caps_lock()", 3500);
		    } else {
		        hide_caps_lock();
		    }
		}
	function show_caps_lock() {
		 $("#capslock").show();
		}
	function hide_caps_lock() {
		 $("#capslock").hide();
		}
</script>
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
                    document.getElementById("sample4_extraAddress").value = '';
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

<script type="text/javascript">
    	//패스워드 안내문
    	function pwd(element,min,max) { 
          var len = element.value.length;
			if(len==""){
				blank();
			}else if ((len<min)||(len>max)) {
				element.style.borderColor="#FF0000"; // 입력 필드의 경계선을 빨강으로 설정함
				danger();
				$(element).val("");
			}else {
				element.style.borderColor="#000000"; // 입력 필드의 경계선을 검정으로 설정
				success();
				}
			}
   		function success() {
   			$("#pwdcheck_success").show();
   			$("#pwdcheck_danger").hide();
   			$("#pwdcheck_blank").hide();
   		}
   		function danger() {
   			$("#pwdcheck_danger").show();
   			$("#pwdcheck_success").hide();
   			$("#pwdcheck_blank").hide();
   		}
   		function blank(){
   			$("#pwdcheck_blank").show();
   			$("#pwdcheck_success").hide();
   			$("#pwdcheck_danger").hide();
   		}
	//패스워드확인 안내문구
		function pwdchk(element,min,max) {
          var len1 = element.value.length;
			if(len1==""){
				blank1();
			}else if ((len1<min)||(len1>max)) {
				element.style.borderColor="#FF0000"; // 입력 필드의 경계선을 빨강으로 설정함
				danger1();
				$(element).val("");
			}else {
				element.style.borderColor="#000000"; // 입력 필드의 경계선을 검정으로 설정
				success1();
				}
			}
   		function success1() {
   			$("#pwdcheck_success2").show();
   			$("#pwdcheck_danger1").hide();
   			$("#pwdcheck_blank3").hide();
   		}
   		function danger1() {
   			$("#pwdcheck_danger1").show();
   			$("#pwdcheck_success2").hide();
   			$("#pwdcheck_blank3").hide();
   		}
   		function blank1(){
   			$("#pwdcheck_blank3").show();
   			$("#pwdcheck_success2").hide();
   			$("#pwdcheck_danger1").hide();
   		}
    	//닉네임 필수입력 체크	
   	function nickcheck(element){
   		var nick = element.value.length;
   		if(nick ==""){
   			nickcheck_bar();
   		}else{
   			nickcheck_hide();
   		}
    }
   	function nickcheck_bar(){
   		$("#nickcheck_blank").show();
   	}
   	function nickcheck_hide(){
   		$("#nickcheck_blank").hide();
   	}
   	 
   	//이름 필수입력 체크
   	function namecheck(element){
   		var name = element.value.length;
   		if(name ==""){
   			namecheck_bar();
   		}else{
   			namecheck_hide();
   		}
   	}
   	function namecheck_bar(){
   		$("#namecheck_blank").show();
   	} 
   	function namecheck_hide(){
   		$("#namecheck_blank").hide();
   	} 
   
	//생년월일 형식,필수 입력체크 
	var numberCheck = function(){
		var temp = document.getElementById('input').value;
		if(temp =="" ){
			fournum_blank();
		}else if(isNaN(temp) == true){
			fournum();
		}else if(isNaN(temp)==false){
			fournum_good();
		}
	}
	function fournum_good(){
		$("#fourNumber").hide();
		$("#fourNumber_blank").hide();
	}
	function fournum(){
		$("#fourNumber").show();
		$("#fourNumber_blank").hide();
	}
	function fournum_blank(){
		$("#fourNumber").hide();
		$("#fourNumber_blank").show();
	}
	
	
</script>



 <script type="text/javascript">
	/* <label for="id">너는 아이디다</label>
	<input type="text" name="id" id="id" onchange="idcheck();"> */
	//아이디 중복체크.
function idCheck() {
		var user_id = $('#user_id').val();
		var query = {user_id : $("#user_id").val()};
		
		if(user_id =="" || user_id == " "){
     		alert("아이디를 입력하여 주세요!");
     	}else{
      $.ajax({
         type: 'POST',
         url : "${pageContext.request.contextPath}/idCheck",
         data : query,
         contentType: "application/json",
         success : function (data) {
           //alert(data);
           if (data == "fail") {
				$("#idCheckView").html("  " + user_id + "이미 존재한 아이디 입니다.");
				checkResultId = "";
			} else {
				$("#idCheckView").html("  "+ user_id+ "사용 가능한 아이디 입니다.");
				checkResultmemberId = user_id;
			}
           /* alert(query);
           if(data == 1) {
               $(".result .msg").text("사용 불가");
               $(".result .msg").attr("style", "color:#f00");    
              } else {
               $(".result .msg").text("사용 가능");
               $(".result .msg").attr("style", "color:#00f");
              } */
         },
         error : function (request,status,error) {
             alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
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
	<script type="text/javascript">
// Mail 체크

function checkMail(){
	var email = document.getElementById("email").value;
	
	if(email ==""){
		alert("메일을 입력 해 주세요")
		return false;
	}
		var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function(){
		if(xhttp.readyState == 4){
			var data = JSON.parse(xhttp.responseText);
			
			if(data != 0){
				alert("이미 가입한 메일 입니다.");
			}else{
				sendMail(email);
			}
		}
	};
	xhttp.open("POST", 'checkMail', true);
	xhttp.setRequestHeader("content-Type","application/x-www-form-urlencoded; charset=UTF-8")
	xhttp.send('email=' + email);
	return false;
}
function checkJoinCode(){
	<%String chk = (String)session.getAttribute("joinCode");%>
	var inputCode= document.getElementById("inputCode").value;
	var regisuccess = document.getElementById("success");

	var query = {code : inputCode};
	$.ajax({
	      url : "codeCheck",
	      type : "POST",
	      data : query,
	      success : function(data) {
	      if(inputCode ==""){
	    	alert('인증번호를 입력하여 주세요.')  
	    	return;
	      }else if(data == 1) {
  			alert('정상 인증 되었습니다!!')
  			regisuccess.disabled = false;
	       } else {
			alert('인증번호가 일치하지 않습니다!!')
			regisuccess.disabled = true;
	       }
	      }
	     });
}
function sendMail(email){
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function(){
		if(xhttp.readyState ==4){
			if(xhttp.status == 200)
				alert("메일을 정상적으로 보냈습니다.");
			else
				alert("올바른 메일 형식이 아닙니다.");
		}
	};
	xhttp.open("POST", 'sendMail', true);
	xhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8")
	xhttp.send('email=' +email);
	return false;
}

</script>

<script>
function chkValidate(){ 
	if($("#isCheckedId").val() == "N"){
		alert("ID 체크를 먼저 해주세요.")
	}
	if(document.getElementById('user_id').value == ""){
		  alert('아이디는 필수 입력 사항입니다.');   
		}else if(document.getElementById('user_pwd').value == ""){
		   alert('비밀번호는 필수 입력 사항입니다.');
		}else{ document.form.submit(); }
	}
</script>

 
</head>

<body>
	<div align="center">
		<form action="${pageContext.request.contextPath}/registerMember" method="post" onsubmit="return;">
			<input type="hidden" name="isCheckedId" id="isCheckedId" value="N">
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
			<h3>정보입력</h3>
			<table border="1" style="width: 1000px; height: 500px;">
				<tr>
					<td align="center" colspan="2">
						<div class="stepLine">
							<div title="이용약관" class="stepDot"></div>
							<div title="정보입력" class="stepDot activeStep"></div>
							<div title="가입완료" class="stepDot"></div>
						</div>
						<br>
					<br>
					<br>
					</td>
				</tr>
				<tr>
					<th><label for="user_id">아이디</label></th>
					<td>
						<div class="form-group">
							<input type="email" class="form-control" id="user_id" name="user_id" style="width: 50%;" placeholder="이메일을 입력 하여 주세요" autofocus required>
							<input type="button" value="중복체크" onclick="idCheck()">
							<span id="idCheckView"></span> 
							<div class="check_font" id="id_check"></div>
							<!-- <input type="button" value="인증하기" onclick="checkMail()"> -->
						</div>
					</td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td colspan="3">
						<input type="password" id="user_pwd" name="userPwd"  placeholder="비밀번호" onblur="pwd(this,8,16)" onkeypress="caps_lock(event)">
						<span id="capslock" style="position: relative; border: 1px solid #003b83; width:300px; bottom: 0px; display: none"> &nbsp; <b>* CapsLock</b> 키가 눌려있습니다. &nbsp;</span> <br> 
						<div>
						<span id="pwdcheck_danger" style="color:red; display:none;">8자 이상 16자 이하로 입력해야 합니다.</span>
						<span id="pwdcheck_success" style="display:none;">안전</span>
						<span id="pwdcheck_blank" style="color:red; display:none;">필수정보</span>
						</div>
						<input type="password" id="user_pwdchk" name="userPwdchk" placeholder="비밀번호 확인" onblur="pwdchk(this,8,16)" onkeypress="caps_lock(event)"> 
						<span id="alert-success">비밀번호가 일치합니다^^</span> <span id="alert-danger" style="">비밀번호가 일치하지 않습니다!!</span>
						<div>
						<span id="pwdcheck_danger1" style="color:red; display:none;">8자 이상 16자 이하로 입력해야 합니다.</span>
						<span id="pwdcheck_success2" style="display:none;">안전</span>
						<span id="pwdcheck_blank3" style="color:red; display:none;">필수정보</span>
						</div>
					</td>
				</tr>
				<tr>
					<th>닉네임</th>
					<td>
					<input type="text" id="user_nickname" name="userNickname" onblur="nickcheck(this)"><br>
					<span id="nickcheck_blank" style="color:red; display:none;">필수정보</span>
					</td>
				</tr>
				<tr>
					<th>이름</th>
					<td>
						<input type="text" id="user_name" name="userName" name="userName" onblur="namecheck(this)"><br>
						<span id="namecheck_blank" style="color:red; display:none;">필수정보</span>
					</td>	
				</tr>
				<tr>	
					<th>전화번호</th>
					<td>
						<select id="mm" name="userPhone" class="sel" aria-label="월" id="userPhone" style="width: 100px;">
								<option value="010">010</option>
								<option value="011">011</option>
								<option value="016">016</option>
								<option value="017">017</option>
								<option value="019">019</option>
						</select>
						- 
						<input type="tel" name="*" name="userPhone1" id="userPhone1" maxlength="4" />
						- 
						<input type="tel" name="*" name="userPhone2" id="userPhone2" maxlength="4" />
					</td>
				</tr>
				<tr style="height:50px;">
					<th>생년월일</th>
					<td>
					

						<input type="text" id="input" name="year" class="int" placeholder="년(4자)" aria-label="년(4자)" maxlength="4" onfocus="this.select();" onblur="numberCheck(isNaN(this.value));"> / 
						<select name="month" class="sel" aria-label="월" style="width: 100px; height: 30px;">
							<option>월</option>
							<option value="01">1</option>
							<option value="02">2</option>
							<option value="03">3</option>
							<option value="04">4</option>
							<option value="05">5</option>
							<option value="06">6</option>
							<option value="07">7</option>
							<option value="08">8</option>
							<option value="09">9</option>
							<option value="10">10</option>
							<option value="11">11</option>
							<option value="12">12</option>
						</select> 
						/ 
						<select name="day" class="sel" aria-label="월" style="width: 100px; height: 30px;">
							<option>일</option>
							<option value="01">1</option>
							<option value="02">2</option>
							<option value="03">3</option>
							<option value="04">4</option>
							<option value="05">5</option>
							<option value="06">6</option>
							<option value="07">7</option>
							<option value="08">8</option>
							<option value="09">9</option>
							<option value="10">10</option>
							<option value="11">11</option>
							<option value="12">13</option>
							<option value="12">14</option>
							<option value="12">15</option>
							<option value="12">16</option>
							<option value="12">17</option>
							<option value="12">18</option>
							<option value="12">19</option>
							<option value="12">20</option>
							<option value="12">21</option>
							<option value="12">22</option>
							<option value="12">23</option>
							<option value="12">24</option>
							<option value="12">25</option>
							<option value="12">26</option>
							<option value="12">27</option>
							<option value="12">28</option>
							<option value="12">29</option>
							<option value="12">30</option>
							<option value="12">31</option>
					</select><br>
					<div>
					<span id="fourNumber" style="color:red; display:none;">태어난 년도 4자리를 정확하게 입력하여 주세요.</span>
					<span id="fourNumber_blank" style="color:red; display:none;">필수입력</span>
					</div>
					</td>
				</tr>

				<tr>
					<th>주소</th>
					<td style="height: 100px;">
						<input type="text" id="sample4_postcode" placeholder="우편번호"> 
						<input type="button" onclick="sample4_execDaumPostcode()" value="우편번호 찾기"><br>
						<input type="text" id="sample4_roadAddress" placeholder="도로명주소"style="width: 300px;"> 
						<input type="text" id="sample4_jibunAddress" placeholder="지번주소" style="width: 300px;">
						<span id="guide" style="color: #999; display: none;"></span><br>
						<input type="text" id="sample4_detailAddress" placeholder="상세주소" style="width: 300px;"> 
						<input type="text" id="sample4_extraAddress" placeholder="참고항목" style="width: 300px;">
					</td>
					<td></td>
				</tr>
				<tr>
					<th colspan="2" align="right">
						<input type="submit" value="회원가입" onclick="chkValidate()" class="btn btn-primary"> 
						<input type="button" value="취소" class="btn btn-primary" onclick="location.href='../../main/main'">
					</th>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>