<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<h1>aside</h1>
<sec:authorize access="!isAuthenticated()">
	<sec:authorize access="hasAnyRole('ROLE_USER', 'ROLE_ADMIN')">
		<p>안녕하세요? ${member.username}회원님 (level: ${member.grade})</p>
	</sec:authorize>
	<sec:authorize access="hasRole('ROLE_ADMIN')">
		<p>당신은 관리자입니다.</p>
	</sec:authorize>
</sec:authorize>
<sec:authorize access="!isAuthenticated()">
	<form action="./login" method="post">
		<table>
			<tr>
				<td><input type="text" name="userid" id="userid"></td>
			</tr>
			<tr>
				<td><input type="password" name="userpass" id="userpass"></td>
			</tr>
			<tr>
				<td class="text-center"><input type="reset" value=" 리 셋 " /> <input
					type="submit" value=" 로 그 인 " /></td>
			</tr>
		</table>
	</form>
</sec:authorize>