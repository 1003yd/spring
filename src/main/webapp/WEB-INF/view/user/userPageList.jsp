
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<head>
<%@ include file="/WEB-INF/view/common/basicLib.jsp"%>

<style type="text/css">
.userClick {
	cursor: pointer;
}
</style>


<script type="text/javascript">
	$(document).ready(function(){
		console.log("documnet.ready");
		
		//tr에 select(class="userClick")
		$(".userClick").on("click", function(){
			console.log("userClick");
			var userId= $(this).children()[1].innerHTML;
			
			$("#userId").val(userId);
			$("#frm").submit();
		});
	});
		
	
	
</script>

</head>
<form id="frm" action="/user/userDetail" method="get">
	<input type="hidden" id="userId" name="userId">
</form>

<body>
	<%@ include file="/WEB-INF/view/common/header.jsp"%>
	<div class="container-fluid">
		<div class="row">
			<%-- left --%>
			<%@ include file="/WEB-INF/view/common/left.jsp"%>

			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<div class="row">
					<div class="col-sm-8 blog-main">
						<h2 class="sub-header">사용자</h2>
						<div class="table-responsive">
							<table class="table table-striped table-hover">
								<tr>
									<th>번호</th>
									<th>사용자 아이디</th>
									<th>사용자 이름</th>
									<th>생일</th>
								</tr>

								<%-- <%
									List<UserVO> userList = (List) request.getAttribute("pageUserList");
									int index = 1;
									for (UserVO uservo : userList) {
										SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
								%>

								<tr class="userClick">
									<td><%=uservo.getRnum()%></td>
									<td><%=uservo.getUserId()%></td>
									<td><%=uservo.getName()%></td>
									<td><%=sdf.format(uservo.getBirth())%></td>
								</tr>


								<%
									index++;
									}
								%> --%>

								<c:forEach items="${pageUserList}" var="user">
									<tr class="userClick">
										<td>${user.rnum}</td>
										<td>${user.userId}</td>
										<td>${user.name}</td>
										<td><fmt:formatDate value="${user.birth}"
												pattern="yyyy-MM-dd" /></td>
									</tr>

								</c:forEach>


							</table>
						</div>

						<a class="btn btn-default pull-right" href="/user/userForm">사용자 등록</a>

						<div class="text-center">

							<ul class="pagination">
								<li><a href="/user/userPageList?page=1&pageSize=10" aria-label="Previous"> <span
										aria-hidden="true">&laquo;</span>
								</a></li>
								<%-- <%
								int pageCnt = (Integer)request.getAttribute("pageCnt");
								for(int p = 1; p <= pageCnt ; p++){
									
								
							%>
								<li><a href="/userPageList?page=<%=p%>&pageSize=10"><%=p%></a></li>
								<%
								}
								%>
								<li><a href="/userPageList?page=<%=pageCnt%>&pageSize=10"
									aria-label="Next"> <span aria-hidden="true">&raquo;</span>
								</a></li> --%>
								<c:forEach begin="1" end="${pageCnt}" var="p">
									<li><a href="/user/userPageList?page=${p}&pageSize=10">${p}</a></li>
								</c:forEach>
								<li><a href="/user/userPageList?page=${pageCnt}&pageSize=10"
									aria-label="Next"> <span aria-hidden="true">&raquo;</span>
								</a></li>
							</ul>
						</div>
					</div>
				</div>

			</div>
		</div>
	</div>
</body>
</html>
