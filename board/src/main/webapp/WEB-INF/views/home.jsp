<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="include/header.jsp"%>
<div class="bg-white bbs">
	<h1 class="text-center mb-5">게시판</h1>
	<table class="bbslist table-hover">
		<colgroup>
			<col width="10%">
			<col width="40%">
			<col width="20%">
			<col width="30%">
		</colgroup>
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성날짜</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="post" items="${boardView}">
				<tr>
					<td class="text-center">${post.id}</td>
					<td class="ellipsis"><a
						href="view?id=${post.id}&pg=${paging.currentPage}">${post.title}</a></td>
					<td class="ellipsis text-center">${post.writer}</td>
					<td class="text-center">${post.create_at}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<div class="search-and-button">
		<div class="col-md-5 searchbox">
			<form id="searchForm" name="searchForm" method="get">
				<div class="input-group mt-3 mb-3">
					<div class="input-group-prepend">
						<button type="button"
							class="btn btn-outline-secondary dropdown-toggle"
							data-toggle="dropdown" id="searchtext">제목검색</button>
						<div class="dropdown-menu">
							<a class="dropdown-item" href="#" data-search="title"> 제목검색 </a>
							<a class="dropdown-item" href="#" data-search="writer"> 작성자검색 </a>
						</div>
					</div>
					<input type="text" class="form-control" name="searchVal"
						id="searchInput" placeholder="검색어 입력"> <input
						type="hidden" id="searchKey" name="searchKey"
						value="${encodeSearchKey}">
					<div class="input-group-append">
						<button class="btn btn-success" id="searchSubmit" type="submit">검색</button>
					</div>
				</div>
			</form>
		</div>
		<div class="col-md-7 text-right">
			<a href="redirect:/" class="btn btn-success">목록</a> <a
				href="write" class="btn btn-success">등록하기</a>
		</div>
	</div>

	<ul class="pagination justify-content-center">
		<li class="page-item"><a class="page-link bg-light"
			href="?pg=1&searchKey=${encodeSearchKey}&searchVal=${encodeSearchVal}"><i
				class="ri-arrow-left-double-line"></i></a></li>
		<c:if test="${paging.startPageOfGroup > 1}">
			<li class="page-item"><a class="page-link"
				href="?pg=${paging.startPageOfGroup - 1}&searchKey=${encodeSearchKey}&searchVal=${encodeSearchVal}"><i
					class="ri-arrow-left-s-line"></i></a></li>
		</c:if>
		<c:forEach var="i" begin="${paging.startPageOfGroup}"
			end="${paging.endPageOfGroup}">
			<li
				class='page-item <c:if test="${ i == paging.currentPage}">active</c:if>'><a
				class="page-link"
				href="?pg=${i}&searchKey=${encodeSearchKey}&searchVal=${encodeSearchVal}">${i}</a></li>
		</c:forEach>
		<c:if test="${paging.endPageOfGroup < paging.totalPages}">
			<li class="page-item"><a class="page-link"
				href="?pg=${paging.endPageOfGroup + 1}&searchKey=${encodeSearchKey}&searchVal=${encodeSearchVal}"><i
					class="ri-arrow-right-s-line"></i></a></li>
		</c:if>
		<li class="page-item"><a class="page-link bg-light"
			href="?pg=${paging.totalPages}&searchKey=${encodeSearchKey}&searchVal=${encodeSearchVal}"><i
				class="ri-arrow-right-double-line"></i></a></li>
	</ul>
</div>
<script>
	$(function() {
		$(".dropdown-item").click(function(e) {
			e.preventDefault();
			const selectedText = $(this).text();
			const selectedKey = $(this).data("search");
			$("#searchKey").val(selectedKey);
			$("#searchtext").text(selectedText);
		});

		$("#searchForm").submit(function() {
			const keyword = $("#searchInput").val().trim();
			if (keyword === "") {
				alert("검색어를 입력하세요.");
				$("#searchInput").focus();
				return false;
			}
		});
	});
</script>
<%@ include file="include/footer.jsp"%>
</body>
</html>
