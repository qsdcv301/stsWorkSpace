<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="include/header.jsp" %>
<div class="bg-white bbs">
    <h1 class="text-center my-5">내용 보기</h1>
    <div class="col-md-6 my-3">
        <div class="row align-items-center">
            <p>제목 : ${boardView.title}</p>
        </div>
    </div>
    <div class="col-md-6 my-3">
        <div class="row align-items-center">
            <p>작가 : ${boardView.writer}</p>
        </div>
    </div>
    <div class="col-md-6 my-3">
        <div class="row align-items-center">
            <p>ISBN : ${boardView.isbn}</p>
        </div>
    </div>
    <div class="col-md-6 my-3">
        <div class="row align-items-center">
            <p>출판연도 : ${boardView.publication}</p>
        </div>
    </div>
    <div class="col-md-12 text-center">
        <a href="#" onclick="history.back(); return false;" class=" btn btn-success mr-2">목록</a>
        <a href="edit?id=${boardView.id}&pg=${currentPage}" class="btn btn-warning mr-2">수정</a>
        <a href="del?id=${boardView.id}&pg=${currentPage}"
           class="btn btn-danger mr-2">삭제</a>
        <a href="write?pg=${currentPage}" class="btn btn-success">글쓰기</a>
    </div>

</div>
<%@ include file="include/footer.jsp" %>