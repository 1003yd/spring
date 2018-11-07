
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri ="http://java.sun.com/jsp/jstl/fmt"%>

<head>
<%@ include file="/WEB-INF/view/common/basicLib.jsp"%>
</head>

<body>
	<%@ include file="/WEB-INF/view/common/header.jsp"%>
	<div class="container-fluid">
		<div class="row">
			<%-- left --%>
			<%@ include file="/WEB-INF/view/common/left.jsp"%>

	<%-- 		<%
				UserVO user = (UserVO) request.getAttribute("userVo");
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				
			//	if(user.getProfile()== null){
				//	user.setProfile("/profile/noimage.png");
				//}
				 
			%>
 --%>

			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
			<h2>제품 상세 정보</h2>
			<hr>
			<br>
			
				<form class="form-horizontal" role="form">
			
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">Prod Id</label>
						
						<div class="col-sm-10">
						<label for="userNm" class="col-sm-2 control-label">${prodVo.prod_id}</label>
						</div>
					</div>

					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">Prod Name</label>
						<div class="col-sm-10">
							<label class="control-label" >${prodVo.prod_name}</label>
						</div>
					</div>
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">ProdGroup Name</label>
						<div class="col-sm-10">
							<label class="control-label" >${prodVo.lprod_nm}</label>
						</div>
					</div>
					<div class="form-group">
						<label for="pass" class="col-sm-2 control-label">Buyer Name</label>
						<div class="col-sm-10">
							<label class="control-label">${prodVo.buyer_name}</label>
						</div>
					</div>

					<div class="form-group">
						<label for="pass" class="col-sm-2 control-label">Buyer Mail</label>
						<div class="col-sm-10">
							<label class="control-label">${prodVo.buyer_mail}</label>
						</div>
					</div>
				</form>
				<form action="/userUpdateServlet" method="get">
					<div class="form-group">
						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-10">
							<input type="hidden" name="userId" value="${prodVo.prod_id}">
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
