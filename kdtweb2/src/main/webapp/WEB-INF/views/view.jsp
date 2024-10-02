<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="../include/header.jsp" %>
<div class="bg-white bbs">
<section class="view">
   <div class="view-box">
      <div class="view-head">
         <i class="ri-arrow-right-circle-fill"></i>
         ${boardView.title}
      </div>
      <div class="view-body">
         <div class="contents-box">
            <div class="wdate"><i class="ri-calendar-2-line"></i> ${boardView.wdate}</div>
            <div class="writer"><i class="ri-user-voice-line"></i>${boardView.writer}</div>
            <div class="count"><i class="ri-anticlockwise-2-line"></i> ${boardView.count}</div>
         </div>
         <div class="contents">
            <p>${boardView.contents}</p>
         </div>
      </div>
      <div class="view-foot">
         <a href="?mode=list&pg=${currentPage}" class="btn btn-success mr-2">목록</a>
         <a href="?mode=edit&bmode=edit&num=${boardView.num}&pg=${currentPage}" class="btn btn-warning mr-2">수정</a>
         <a href="${pageContext.request.contextPath}/bbs/del?mode=pass&bmode=del&num=${boardView.num}&pg=${currentPage}" class="btn btn-danger mr-2">삭제</a>
         <a href="?mode=write&pg=${currentPage}" class="btn btn-success">글쓰기</a>
      </div>
   </div>
</section>
</div>
<%@ include file="../include/footer.jsp" %>