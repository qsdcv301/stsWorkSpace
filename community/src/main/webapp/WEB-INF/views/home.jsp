<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${not empty error }">
    <script>
        alert("${error }");
        history.go(-1);
    </script>
</c:if>
<h1>안녕하세요</h1>
<c:if test="${not empty nimg }">
    <img src="res/upload/members/${nimg }" alt="불러온이미지"/>
</c:if>