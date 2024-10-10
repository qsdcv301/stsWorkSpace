<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<h1>관리자 모드</h1>
<nav class="d-flex justify-content-between">
    <div>
        <a href="admin/mkbbs" class="btn btn-outline-dark mx-2">공지사항 등록</a>
        <a href="admin/mkbbs" class="btn btn-outline-dark mx-2">커뮤니티 생성</a>
        <a href="admin/mkbbs" class="btn btn-outline-dark mx-2">커뮤니티 관리</a>
        <a href="admin/mkbbs" class="btn btn-outline-dark mx-2">회원 관리</a>
    </div>
    <div>
        <a href="/" class="btn btn-outline-dark mx-2" target="_blank">홈페이지로</a>
        <a href="#" data-log="logout" class="btn btn-outline-dark mx-2 logout">로그아웃</a>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" id="csrf">
    </div>
</nav>
<script>
    $(function () {
        $(".logout").click(function () {
            e.preventDefault();
            const cname=$("#csrf").attr("name");
            const cvalue = $("#csrf").val();

            let form = $("<form></form>");
            form.attr("action","logout");
            form.attr("method", "post")
            form.append("<input type='hidden' name="+cname+" value"+cvalue+" />")
            form.appendTo("body");
            form.submit();
        });
    });
</script>