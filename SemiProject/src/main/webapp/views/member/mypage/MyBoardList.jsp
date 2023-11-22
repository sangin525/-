<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="../../common/head.jsp"%>
</head>
<body>
	<%@ include file="../../common/header.jsp"%>
	<%@ include file="../../common/nav.jsp"%>


<div class="container">
	<%@ include file="../../common/sidebar.jsp"%>
	
	<div class="contents">
	<div >
		<h4>문의 내역</h4>
	</div>
	<input type="hidden" name="cpage" value="1">
		<table class="table table-hover tableTypeA tableJoinForm tableUserInfo2" id="content">
		<colgroup>
			<col width="13%" class="col1">
			<col class="col2">
		</colgroup>
				<thead>
					<tr>
						<td>글번호</td>
						<td>제목</td>
						<td>문의일자</td>
						<td>조회수</td>
						<td>답변여부</td>
					</tr>
				</thead>
				<tbody class="table-group-divider" id="table-content">
					<c:choose>
						<c:when test="${empty list}">
							<tr>
								<td colspan="5" class="text-center">등록된 글이 없습니다.</td>
							</tr>
						</c:when>
						<c:otherwise>
							<c:forEach var="item" items="${list}">
								<tr onclick="detailPage(${item.no})">
									<td>${row}</td>
									<td>${item.title}</td>
									<td>${item.onDate}</td>
									<td>${item.views}</td>
									<td>${item.answer}</td>
								</tr>
								<c:set var="row" value="${row-1}" />
							</c:forEach>
						</c:otherwise>
					</c:choose>

				</tbody>
			</table>
	</div>
</div>
	
	
		<%@ include file="../../common/footer.jsp"%>
</body>
</html>