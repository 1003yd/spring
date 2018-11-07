
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<head>
<%@ include file="/WEB-INF/view/common/basicLib.jsp"%>

<!-- jquery ui API  -->
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<!-- daum 주소 API -->
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<!-- jquery ui api -->
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script>
	$(document).ready(function() {
		//개발 과정에서 사용한 기본  값 설정
		$("#userId").val();
		$("#pass").val("pass1234");
		$("#name").val("testUserId");
		$("#addr1").val("대전 중구 중앙로 76");
		$("#addr2").val("영민빌딩2층 대덕인재개발원");
		$("#zipcd").val("34940");
		$("#birth").val("2018-08-08");
		$("#email").val("newUser@gmail.com");
		$("#tel").val("0422228202");
		
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
				<form action="/user/userForm" method="post" class="form-horizontal" role="form" enctype="multipart/form-data">
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">사용자 사진</label>
						<div class="col-sm-10">
							<input type="file" id="profile" name="profilePic">
						</div>
					</div>
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">사용자 아이디</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="userId" name="userId"
								placeholder="사용자 아이디">
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
								placeholder="생년월일">
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
								<button type="submit" class="btn btn-default">사용자 등록</button>
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
