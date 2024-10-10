<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<sec:authorize access="isAuthenticated()">
	<sec:authorize access="hasAnyRole('USER', 'ADMIN')">
		<c:if test="${not empty member}">
			<p>안녕하세요? ${member.username} 회원님 (level: ${member.grade})</p>
		</c:if>
		<c:if test="${empty member}">
			<p>회원 정보가 없습니다.</p>
		</c:if>
	</sec:authorize>
	<sec:authorize access="hasRole('ADMIN')">
		<p>당신은 관리자입니다.</p>
	</sec:authorize>
	<form action="${pageContext.request.contextPath}/logout" method="post">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
		<button type="submit">로그아웃</button>
	</form>
</sec:authorize>
<sec:authorize access="!isAuthenticated()">
	<form action="./login" method="post">
		<div class="logo"><a href="/"><img src="res/images/logo.png" alt="kdt community"></a></div>
		<div class="login">
			<input type="text" class="form-control" name="userid" id="mkuserid" placeholder="아이디">
			<input type="password" class="form-control" name="userpass" id="mkuserpass" placeholder="비밀번호">
			<div class="text-right"><label><input type="checkbox" name="rid" value="ok">아이디 저장</label></div>
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
			<button type="submit" class="btn btn-success btn-block">전송</button>
		</div>
		<div class="banner">
			이미지배너
		</div>
	</form>
</sec:authorize>
