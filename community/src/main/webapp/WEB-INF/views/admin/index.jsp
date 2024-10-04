<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<table class="table table-bordered comtable">
	<colgroup>
		<col />
		<col />
		<col />
		<col />
		<col />
		<col />
		<col />
		<col />
		<col />
		<col />
	</colgroup>
	<tr>
		<th>#</th>
		<th>이름</th>
		<th>카테고리</th>
		<th>스킨</th>
		<th>목록수</th>
		<th>페이지수</th>
		<th>파일첨부</th>
		<th>코멘트</th>
		<th>답글</th>
		<th>수정/삭제</th>
	</tr>
	<!-- loop -->
	<tr>
		<td>1</td>
		<td><input type="text" name="title" class="title" value="공지사항" /></td>
		<td><select name="category" id="">
				<option value="n">없음</option>
				<option value="y">있음</option>
		</select></td>
		<td><select name="skin" id="">
				<option value="1">목록형</option>
				<option value="2">갤러리</option>
				<option value="3">기사형</option>
				<option value="4">블로그형</option>
		</select></td>
		<td><input type="text" name="listCount" value="15" /></td>
		<td><input type="text" name="pageCount" value="15" /></td>
		<td><select name="file" id="">
				<option value="n">no</option>
				<option value="y">yes</option>
		</select></td>
		<td><select name="coment" id="">
				<option value="n">no</option>
				<option value="y">yes</option>
		</select></td>
		<td><select name="rewrite" id="">
				<option value="n">no</option>
				<option value="y">yes</option>
		</select></td>
		<td><a href="#" data-num="1" class="del-board">삭제</a> <a href="#"
			data-num="1" class="edt-board">수정</a></td>
	</tr>
	<!-- /loop -->
</table>
