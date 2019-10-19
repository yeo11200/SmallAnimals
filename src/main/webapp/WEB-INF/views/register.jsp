<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8" http-equiv="Content-Type" content="text/html;">
<title>Insert title here</title>
<%
	//request.setCharacterEncoding("UTF-8");  //한글깨지면 주석제거
	//request.setCharacterEncoding("EUC-KR");  //해당시스템의 인코딩타입이 EUC-KR일경우에
	String inputYn = request.getParameter("inputYn");
	String roadFullAddr = request.getParameter("roadFullAddr");
	String roadAddrPart1 = request.getParameter("roadAddrPart1");
	String roadAddrPart2 = request.getParameter("roadAddrPart2");
	String engAddr = request.getParameter("engAddr");
	String jibunAddr = request.getParameter("jibunAddr");
	String zipNo = request.getParameter("zipNo");
	String addrDetail = request.getParameter("addrDetail");
	String admCd = request.getParameter("admCd");
	String rnMgtSn = request.getParameter("rnMgtSn");
	String bdMgtSn = request.getParameter("bdMgtSn");
	String detBdNmList = request.getParameter("detBdNmList");
	/** 2017년 2월 추가제공 **/
	String bdNm = request.getParameter("bdNm");
	String bdKdcd = request.getParameter("bdKdcd");
	String siNm = request.getParameter("siNm");
	String sggNm = request.getParameter("sggNm");
	String emdNm = request.getParameter("emdNm");
	String liNm = request.getParameter("liNm");
	String rn = request.getParameter("rn");
	String udrtYn = request.getParameter("udrtYn");
	String buldMnnm = request.getParameter("buldMnnm");
	String buldSlno = request.getParameter("buldSlno");
	String mtYn = request.getParameter("mtYn");
	String lnbrMnnm = request.getParameter("lnbrMnnm");
	String lnbrSlno = request.getParameter("lnbrSlno");
	/** 2017년 3월 추가제공 **/
	String emdNo = request.getParameter("emdNo");
%>
</head>
<script language="javascript" type="text/javascript">
// opener관련 오류가 발생하는 경우 아래 주석을 해지하고, 사용자의 도메인정보를 입력합니다. ("주소입력화면 소스"도 동일하게 적용시켜야 합니다.)
//document.domain = "abc.go.kr";

/*
		모의 해킹 테스트 시 팝업API를 호출하시면 IP가 차단 될 수 있습니다. 
		주소팝업API를 제외하시고 테스트 하시기 바랍니다.
*/
function init(){
	var popupX = (window.screen.width / 2) - (200 / 2);
	// 만들 팝업창 좌우 크기의 1/2 만큼 보정값으로 빼주었음
	var popupY= (window.screen.height / 2) - (300 / 2);
	// 만들 팝업창 상하 크기의 1/2 만큼 보정값으로 빼주었음
	//window.open('', '', 'status=no, height=300, width=200, left='+ popupX + ', top='+ popupY);
	
	var url = location.href;
	var confmKey = "devU01TX0FVVEgyMDE5MTAwNzIwMDUzMDEwOTA3ODk=";
	var resultType = "4"; // 도로명주소 검색결과 화면 출력내용, 1 : 도로명, 2 : 도로명+지번, 3 : 도로명+상세건물명, 4 : 도로명+지번+상세건물명
	var inputYn= "<%=inputYn%>";
	if(inputYn != "Y"){
		document.form.confmKey.value = confmKey;
		document.form.returnUrl.value = url;
		document.form.resultType.value = resultType;
		document.form.action="http://www.juso.go.kr/addrlink/addrLinkUrl.do", "주소", "width=500, height=500, toolbar=no, menubar=no, scrollbars=no, resizable=yes";
		//document.form.action="http://www.juso.go.kr/addrlink/addrMobileLinkUrl.do"; //모바일 웹인 경우, 인터넷망
		document.form.submit();
	}else{
		opener.jusoCallBack("<%=roadFullAddr%>","<%=roadAddrPart1%>","<%=addrDetail%>","<%=roadAddrPart2%>","<%=engAddr%>","<%=jibunAddr%>","<%=zipNo%>", "<%=admCd%>", "<%=rnMgtSn%>", "<%=bdMgtSn%>", "<%=detBdNmList%>", "<%=bdNm%>", "<%=bdKdcd%>", "<%=siNm%>", "<%=sggNm%>", "<%=emdNm%>", "<%=liNm%>", "<%=rn%>", "<%=udrtYn%>", "<%=buldMnnm%>", "<%=buldSlno%>", "<%=mtYn%>", "<%=lnbrMnnm%>", "<%=lnbrSlno%>", "<%=emdNo%>");
			window.close();
		}
	}
</script>
<body>
	<div style="margin-left: auto; margin-right: auto; width: 50%; height: 50%; background-color: green;">
		<form action="submit" name="*" method="get">
			<h3>회원가입</h3>
			<fieldset style="width: 100%;">

				아이디 <input type="email" id="user_id" autofocus> 
				<font color="red">이메일 입력</font> <input type="button" value="인증하기"
					onclick="">
				<hr>


				<fieldset style="width: 100%;">
					비밀번호 <input type="password" id="user_pwd" maxlength="16"><br>

					비밀번호 확인 <input type="password" id="user_pwdchk">
				</fieldset>
				<hr>
				닉네임 <input type="text" id="user_nickname">
				<hr>
				이름 <input type="text" id="user_name">
				<hr>
				<fieldset style="width: 100%;">
					전화번호<br> <select id="mm" class="sel" aria-label="월"
						style="width: 100px;">
						<option value="010">010</option>
						<option value="011">011</option>
						<option value="016">016</option>
						<option value="017">017</option>
						<option value="019">019</option>
					</select> -
					<!-- <input type="tel" name="*" id="user_phone" onkeyup="nextBlank(3, this.id, 'test2')" /> - -->
					<input type="tel" name="*" id="user_phone2"
						onkeyup="nextBlank(4, this.id, 'test3')" /> - <input type="tel"
						name="*" id="user_phone3" maxlength="4" />
					<hr>
			</fieldset>

				<!--생년월일-->
				<div class="join_row join_birthday">
					<h3>
						<label for="yy">생년월일</label>
					</h3>
					<div class="bir_wrap">

						<span class="ps_xbox"> <input type="text" id="yy"
							placeholder="년(4자)" aria-label="년(4자)" class="int" maxlength="4">
						</span> / 
						<span class="ps_box"> 
						<select id="mm" class="sel" aria-label="월" style="width: 100px; height: 30px;">
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
						</span>/ 
						
						<span class="ps_box"> 
						<input type="text" id="dd" placeholder="일" aria-label="일" class="int" maxlength="2">
							<label for="dd" class="lbl"></label>
						</span>

					</div>
					<span class="error_next_box" id="birthdayMsg" style="" role="alert">
						태어난 년도 4자리를 정확하게 입력하세요. </span>
				</div>
				<hr>
			</fieldset>
		</form>
		<form  id="form" name="form" method="get">
		<input type="hidden" id="confmKey" name="confmKey" value="" /> 
		<input type="hidden" id="returnUrl" name="returnUrl" value="" /> 
		<input type="hidden" id="resultType" name="resultType" value="" />
		
		<input type="text" id="" name=""/>
		<input type="text" id="" name=""/>
		<input type="text" id="" name=""/>
		
		<input type="submit" id="*" name="" value="주소" onclick="init()">
		<!-- 해당시스템의 인코딩타입이 EUC-KR일경우에만 추가 START-->
		<!-- 
		<input type="hidden" id="encodingType" name="encodingType" value="EUC-KR"/>
		 -->
		<!-- 해당시스템의 인코딩타입이 EUC-KR일경우에만 추가 END-->
	</form>
	
	
	</div>
	
	<!-- 
	회원번호 : <input type="text" id="user_no" placeholder="회원번호">
	
	등급번호 :<input type="text" id="gradeNo" placeholder="등급번호">
	가입일
	<input type="hidden" id="user_regdate" placeholder="가입일">
	로그인한 날
	<input type="hidden" id="user_loginDate" placeholder="로그인한 날">
	성장과정인증
	<input type="hidden" id="user_checkparcel" placeholder="성장과정인증">
	분양자 체크
	<input type="hidden" id="user_parcel" placeholder="분양자 체크">
	</div> 
	-->



</body>
</html>