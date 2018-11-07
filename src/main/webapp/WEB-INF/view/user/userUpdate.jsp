
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<head>
<%@ include file="/WEB-INF/view/common/basicLib.jsp"%>

<!-- jquery ui API  -->
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<!-- daum 주소 API -->
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<!-- jquery ui api -->
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<%-- <%
	UserVO user = (UserVO)request.getAttribute("userVo");
	//String userId = request.getParameter("userId");
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
%> --%>
<script>
	$(document).ready(function() {
		//개발 과정에서 사용한 기본  값 설정
		$("#userId").val("${userVo.userId}");
		$("#pass").val("${userVo.pass}");
		$("#name").val("${userVo.name}");
		$("#addr1").val("${userVo.addr1}");
		$("#addr2").val("${userVo.addr2}");
		$("#zipcd").val("${userVo.zipcd}");
		$("#email").val("${userVo.email}");
		// 여기는 jsp 구역이므로  jstl 태그를 사용할 수 없어
		//$("#birth").val("${userVo.birth}");  => formatDate를 사용하기 위해 input 태그에서 직접 value 값을 지정해 줬어
		$("#tel").val("${userVo.tel}");
		
		
		
		
		//생일 input datepicker 적용
		$("#birth").datepicker({
			dateFormat : "yy-mm-dd",
			changeMonth : true,
			changeYear : true,
			yearRange : "1990:2018"
		});

		$("#addrSearchButton").click(function() {
			//클릭 이벤트가 발생했을 때 실행
			new daum.Postcode({
				oncomplete : function(data) {
					// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분입니다.
					// 예제를 참고하여 다양한 활용법을 확인해 보세요.
					console.log(data);
					//주소 : roadAddress
					//상세주소 : ""
					//우편번호 : zonecode

					//주소 input에 value 설정: data.roadAddress
					//우편번호 input에 value 설정 : data.zonecode
					$("#addr1").val(data.roadAddress);
					$("#zipcd").val(data.zonecode);
				}
			}).open();

		});
		$("#profile").change(function(){
			var file = $("#profile").val().split("\\");
			var fileName = file[file.length-1];
			$("#image").attr("src","/profile/" + fileName);
			
		});
	});
</script>
</head>

<body>
	<%@ include file="/WEB-INF/view/common/header.jsp"%>
	<div class="container-fluid">
		<div class="row">
			<%-- left --%>
			<%@ include file="/WEB-INF/view/common/left.jsp"%>



			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<!-- 파일을 parameter로 넘겨주기 위해서 enctype="multipart/form-data" 반드시 사용해야함 -->
				<form action="/user/userUpdate" method="post"
					class="form-horizontal" role="form" enctype="multipart/form-data">
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">사용자 사진</label>
						<div class="col-sm-10">
							<c:if test="${userVo.profile} == null ">
								<img id="image" src= "/profile/noimage.png">
							</c:if>
								<img id="image" src= "${userVo.profile}">
							<br> <br> <input type="file" id="profile"
								name="profilePic" value="" onchange="fileClick()">
						</div>
					</div>
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">사용자 아이디</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="userId" name="userId"
								placeholder="사용자 아이디" readonly="readonly">
						</div>
					</div>

					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">비밀번호</label>
						<div class="col-sm-10">
							<input type="password" class="form-control" id="pass" name="pass"
								placeholder="비밀번호">
						</div>
					</div>

					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">이름</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="name" name="name"
								placeholder="이름">
						</div>
					</div>
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">주소</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="addr1" name="addr1"
								placeholder="주소" readonly="readonly">
							<!-- 주소 검색 버튼 -->
							<button id="addrSearchButton" type="button"
								class="btn btn-default">주소 검색</button>

						</div>
					</div>
					<div class="form-group">
						<label for="pass" class="col-sm-2 control-label">상세주소</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="addr2" name="addr2"
								placeholder="상세주소">
						</div>
					</div>

					<div class="form-group">
						<label for="pass" class="col-sm-2 control-label">우편번호</label>
						<div class="col-sm-10">
							<!--  readonly = 읽기전용으로 편집이 불가능 또다른 속성으로 disable을 사용할수 도 있지만 그렇게 되면 값이 넘어가지 않는다. -->
							<input type="text" class="form-control" id="zipcd" name="zipcd"
								placeholder="우편번호" readonly="readonly">
						</div>
					</div>

					<div class="form-group">
						<label for="pass" class="col-sm-2 control-label">생년월일</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="birth" name="birth"
								placeholder="생년월일" value= "<fmt:formatDate value="${userVo.birth}"/>" />
						</div>
					</div>

					<div class="form-group">
						<label for="pass" class="col-sm-2 control-label">이메일</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="email" name="email"
								placeholder="이메일 ">
						</div>
					</div>

					<div class="form-group">
						<label for="pass" class="col-sm-2 control-label">전화</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="tel" name="tel"
								placeholder="전화">
						</div>
					</div>

					<div class="form-group">
						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-10">
								<button type="submit" class="btn btn-default">수정</button>
							</div>
						</div>
						<div class="col-sm-10"></div>
					</div>

				</form>
			</div>
		</div>
	</div>
</body>
</html>
