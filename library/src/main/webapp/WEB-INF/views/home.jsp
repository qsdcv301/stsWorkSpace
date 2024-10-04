<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.sql.*, java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ include file="include/header.jsp"%>
<div class="bg-white bbs">
	<h1 class="text-center mb-5">도서 정보</h1>
	<table class="bbslist table-hover">
		<colgroup>
			<col width="10%">
			<col width="20%">
			<col width="15%">
			<col width="20%">
			<col width="15%">
			<col width="20%">
		</colgroup>
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작가</th>
				<th>ISBN</th>
				<th>출판연도</th>
				<th>수정/삭제</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="post" items="${library}">
				<tr>
					<td class="text-center">${post.id}</td>
					<td class="ellipsis">${post.title}</td>
					<td class="ellipsis text-center">${post.writer}</td>
					<td class="text-center">${post.isbn}</td>
					<td class="text-center">  <fmt:formatDate value="${post.publication}" pattern="yyyy" /></td>
					<td class="text-center"><a href="edit?id=${post.id}">수정</a> / <a href="del?id=${post.id}">삭제</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
		<div class="col-md-12 text-right">
		 <a href="write" class="btn btn-success">등록하기</a>
		</div>
	</div>

<%@ include file="include/footer.jsp"%>
</body>
</html>
