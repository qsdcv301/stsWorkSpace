<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="include/header.jsp" %>

<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/summernote-bs4.css">
<script src="${pageContext.request.contextPath}/resources/js/summernote-bs4.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/lang/summernote-ko-KR.js"></script>
<div class="bg-white bbs">

    <h1 class="text-center my-5">글수정</h1>
    <form name="update_form" id="update_form" class="row was-valited" method="post" action="write">
        <div class="col-md-6 my-3">
            <div class="row align-items-center">
                <label for="writer" class="w-label">작성자</label>
                <input type="text" class="form-control" name="writer" id="writer"
                       required/>
            </div>
        </div>
        <div class="col-md-6 my-3">
        </div>
        <div class="col-md-12 my-3">
            <div class="row align-items-center">
                <label for="title" class="w-label">제목</label>
                <input type="text" class="form-control" name="title" id="title"
                       required/>
            </div>
        </div>
        <div class="col-md-12 my-3">
            <div class="row align-items-center">
                <label for="contents" class="w-label">내용</label>
                <textarea class="form-control" name="contents" id="contents" required>

                </textarea>
            </div>
        </div>
        <div class="col-md-12 text-center">
            <button type="reset" class="btn btn-danger mx-2 px-4">취소</button>
            <button type="submit" class="btn btn-success update mx-2 px-4">작성완료</button>
        </div>
    </form>

</div>
<%@ include file="include/footer.jsp" %>
<script>
    $(function () {
        $('#contents').summernote({
            height: 250
        });
    });
</script>
