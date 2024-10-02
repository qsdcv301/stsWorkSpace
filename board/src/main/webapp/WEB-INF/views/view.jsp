<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="include/header.jsp"%>
<div class="bg-white bbs">
	<section class="view">
		<div class="view-box">
			<div class="view-head">
				<i class="ri-arrow-right-circle-fill"></i> ${boardView.title}
			</div>
			<div class="view-body">
				<div class="contents-box">
					<div class="wdate">
						<i class="ri-calendar-2-line"></i> ${boardView.create_at}
					</div>
					<div class="writer">
						<i class="ri-user-voice-line"></i>${boardView.writer}</div>
				</div>
				<div class="contents">
					<p>${boardView.contents}</p>
				</div>
			</div>

			<div class="view-foot">
				<a href="#" onclick="history.back(); return false;"
					class=" btn btn-success mr-2">목록</a> <a
					href="edit?num=${boardView.num}&pg=${currentPage}"
					class="btn btn-warning mr-2">수정</a> <a
					href="del?num=${boardView.num}&pg=${currentPage}"
					class="btn btn-danger mr-2">삭제</a> <a
					href="write?pg=${currentPage}" class="btn btn-success">글쓰기</a>
			</div>

		</div>
	</section>
</div>
<%@ include file="include/footer.jsp"%>