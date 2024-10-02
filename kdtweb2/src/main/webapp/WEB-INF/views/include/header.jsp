<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
 
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>관리자모드</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/reset.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/fonts.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/remixicon.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
    <script src="${pageContext.request.contextPath}/resources/js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/popper.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/pycs-layout.jquery.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/jquery.validate.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/script.js"></script>
</head>
<body>
    <div class="container position-relative pl-300">
       <header class="position-absolute">
          <div class="logo"><a href="home"><img src="${pageContext.request.contextPath}/resources/images/logo.png" alt="kdt community"></a></div>
         
      <c:choose>
         <c:when test="${sessionScope.userid == null}">
	          <form id="loginform" name="loginform" class="login" method="post" action="login">
	             <input type="text" class="form-control" name="userid" id="userid" placeholder="아이디">
	             <input type="password" class="form-control" name="userpass" id="userpass" placeholder="비밀번호">
	             <div class="text-right"><label><input type="checkbox" name="rid" id="rid" value="ok" /> 아이디 저장</label></label></div>
	             <button type="submit" class="btn btn-success btn-block">로 그 인</button>
	          </form>
	          <div class="d-flex justify-content-between px-2 mb-5">
	            <a href="findidpass">아이디/비밀번호 찾기</a>
	            <a href="register">회원가입</a>
	          </div>
        </c:when>
        <c:when test="${sessionScope.userid =='admin'}">  
             <div id="loginform" class="login">
             <h5 class="text-center">
                관리자님 로그인
             </h5>
             <ul class="list-group">
                <li class="list-group-item">
                    <a href="memlist">회원관리</a>
                </li>
                <li class="list-group-item">
                    <a href="logout">로그아웃</a>
                </li>
             </ul>   
          </div>          
       </c:when>     		   
       <c:otherwise>
          <div id="loginform" class="login">
             <h5 class="text-center">
                 ${sessionScope.userid }님 로그인
              
             </h5>
             <p class="text-center">
              <a href="editmem">회원정보수정</a> | <a href="logout">로그아웃</a>
             </p>
          </div>
       </c:otherwise>
     </c:choose>
     
          <div>이미지배너</div>
       </header>