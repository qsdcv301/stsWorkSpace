<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<%@ include file="include/header.jsp" %>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/summernote-bs4.css">
<script src="${pageContext.request.contextPath}/resources/js/summernote-bs4.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/lang/summernote-ko-KR.js"></script>
<div class="bg-white bbs">

<h1 class="text-center my-5">글쓰기</h1>
<form name="write_form" id="write_form" class="row was-valited" method="post" action="write">
   <div class="col-md-6 my-3">
      <div class="row align-items-center">
         <label for="title" class="w-label">제목</label>
         <input type="text" class="form-control" name="title" id="title" required />
      </div>
   </div>
   <div class="col-md-6 my-3">
      <div class="row align-items-center">
         <label for="writer" class="w-label">작가</label>
         <input type="text" class="form-control" name="writer" id="writer" required />
      </div>
   </div>
   <div class="col-md-6 my-3">
      <div class="row align-items-center">
         <label for="isbn" class="w-label">ISBN</label>
         <input type="text" class="form-control" name="isbn" id="isbn" required />
      </div>
   </div>
   <div class="col-md-6 my-3">
      <div class="row align-items-center">
         <label for="publication" class="w-label">출판날짜</label>
         <input type="text" class="form-control" name="publication" id="publication" required placeholder="작성방법: 2024-09-30 16:13:40"/>
      </div>
   </div>
    <div class="col-md-12 text-center">
		<button type="reset" class="btn btn-danger mx-2 px-4">취소</button>
		     <button type="submit" class="btn btn-success write mx-2 px-4">작성완료</button>
    </div>  
</form>

</div>
<%@ include file="include/footer.jsp" %>
<script>
$(function(){
   $('#contents').summernote({
	 height: 250  
   });	
});
</script>