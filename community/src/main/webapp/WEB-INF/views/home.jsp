<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<c:if test="${not empty error }">
	<script>
		alert("${error}");
		history.go(-1);
	</script>
</c:if>
<c:if test="${param.logout != null}">
	<script>
		alert("로그아웃 되었습니다.");
	</script>
</c:if>
<div class="container position-relative">
	<div class="row">
		<div class="col-6">
			<div class="comu-box">
				<h2>갤러리</h2>
				<div class="photos-gallery clearfix">
					<!-- loop -->
					<div class="picture">
						<a href="#"><img src="res/images/upload/001.jpg" alt="001"></a>
						<div class="txt-box">제목1 테스트1</div>
					</div>
					<div class="picture">
						<a href="#"><img src="res/images/upload/002.jpg" alt="002"></a>
						<div class="txt-box">제목2 테스트2</div>
					</div>
					<div class="picture">
						<a href="#"><img src="res/images/upload/003.jpg" alt="003"></a>
						<div class="txt-box">제목3 테스트3</div>
					</div>
					<div class="picture">
						<a href="#"><img src="res/images/upload/004.jpg" alt="004"></a>
						<div class="txt-box">제목4 테스트4</div>
					</div>
				</div>
			</div>
		</div>
		<div class="col-6">
			<div class="comu-box">
				<h2>공지사항</h2>
				<ul class="noticeul">
					<li><a href="#"> <span class="notice notice1">공지</span>
							공지사항 게시판 입니다.
					</a> <span class="ndate">2024.07.31</span></li>
					<li><a href="#"> <span class="notice notice2">공지</span>
							공지사항 게시판 입니다.
					</a> <span class="ndate">2024.07.31</span></li>
					<li><a href="#"> <span class="notice notice3">공지</span>
							공지사항 게시판 입니다.
					</a> <span class="ndate">2024.07.31</span></li>
					<li><a href="#"> <span class="notice notice4">공지</span>
							공지사항 게시판 입니다.
					</a> <span class="ndate">2024.07.31</span></li>
					<li><a href="#"> <span class="notice notice1">공지</span>
							공지사항 게시판 입니다.
					</a> <span class="ndate">2024.07.31</span></li>
					<li><a href="#"> <span class="notice notice2">공지</span>
							공지사항 게시판 입니다.
					</a> <span class="ndate">2024.07.31</span></li>
					<li><a href="#"> <span class="notice notice3">공지</span>
							공지사항 게시판 입니다.
					</a> <span class="ndate">2024.07.31</span></li>
					<li><a href="#"> <span class="notice notice4">공지</span>
							공지사항 게시판 입니다.
					</a> <span class="ndate">2024.07.31</span></li>
				</ul>
				<!-- <ul class="notice-ul">
                        <li><a href="#">
                                <span class="badge badge-primary mr-1">Notice</span>
                                <span class="notice notice1">공지</span>
                                <span class="notice-text">공지사항1</span>
                                <span class="date">2024.08.27</span></a></li>
                        <li><a href="#">
                                <span class="badge badge-primary mr-1">Notice</span>
                                <span class="notice notice2">이벤트</span>
                                <span class="notice-text">공지사항 1</span><span class="date">2024.08.27</span></a></li>
                        <li><a href="#">
                                <span class="badge badge-primary mr-1">Notice</span>
                                <span class="notice notice3">알림</span>
                                <span class="notice-text">공지사항 1</span><span class="date">2024.08.27</span></a></li>
                        <li><a href="#">
                                <span class="badge badge-primary mr-1">Notice</span>
                                <span class="notice notice4">점검</span>
                                <span class="notice-text">공지사항 1</span><span class="date">2024.08.27</span></a></li>
                        <li><a href="#">
                                <span class="badge badge-primary mr-1">Notice</span>
                                <span class="notice notice1">공지</span>
                                <span class="notice-text">공지사항 1</span><span class="date">2024.08.27</span></a></li>
                        <li><a href="#">
                                <span class="badge badge-primary mr-1">Notice</span>
                                <span class="notice notice1">공지</span>
                                <span class="notice-text">공지사항 1</span><span class="date">2024.08.27</span></a></li>
                        <li><a href="#">
                                <span class="badge badge-primary mr-1">Notice</span>
                                <span class="notice notice1">공지</span>
                                <span class="notice-text">공지사항 1</span><span class="date">2024.08.27</span></a></li>
                    </ul> -->
			</div>
		</div>
		<div class="col-6">
			<div class="comu-box">
				<h2>블로그</h2>
				<ul class="blogul">
					<li><a href="#" class="blogs">
							<div class="thumb">
								<img src="res/images/upload/005.jpg" alt="005">
							</div>
							<div class="blog-text">
								<h3>기사의 제목을 넣음</h3>
								<p>법률은 특별한 규정이 없는 한 공포한 날로부터 20일을 경과함으로써 효력을 발생한다.</p>
							</div>
					</a></li>
					<li><a href="#" class="blogs">
							<div class="thumb">
								<img src="res/images/upload/005.jpg" alt="005">
							</div>
							<div class="blog-text">
								<h3>기사의 제목을 넣음</h3>
								<p>법률은 특별한 규정이 없는 한 공포한 날로부터 20일을 경과함으로써 효력을 발생한다.</p>
							</div>
					</a></li>
					<li><a href="#" class="blogs">
							<div class="thumb">
								<img src="res/images/upload/005.jpg" alt="005">
							</div>
							<div class="blog-text">
								<h3>기사의 제목을 넣음</h3>
								<p>법률은 특별한 규정이 없는 한 공포한 날로부터 20일을 경과함으로써 효력을 발생한다.</p>
							</div>
					</a></li>
				</ul>
			</div>
		</div>
		<div class="col-6">
			<div class="comu-box">
				<h2>Community</h2>
				<ul class="noticeul">
					<li><a href="#"> 공지사항 게시판 입니다. </a> <span class="ndate">2024.07.31</span>
					</li>
					<li><a href="#"> <span class="blank"></span><i
							class="ri-corner-down-right-line"></i> 공지사항 게시판 입니다.
					</a> <span class="ndate">2024.07.31</span></li>
					<li><a href="#"> <span class="blank"></span><span
							class="blank"></span><i class="ri-corner-down-right-line"></i>
							공지사항 게시판 입니다.
					</a> <span class="ndate">2024.07.31</span></li>
					<li><a href="#"> 공지사항 게시판 입니다. </a> <span class="ndate">2024.07.31</span>
					</li>
					<li><a href="#"> 공지사항 게시판 입니다. </a> <span class="ndate">2024.07.31</span>
					</li>
					<li><a href="#"> 공지사항 게시판 입니다. </a> <span class="ndate">2024.07.31</span>
					</li>
					<li><a href="#"> 공지사항 게시판 입니다. 공지사항 게시판 입니다. 공지사항 게시판 입니다.
							공지사항 게시판 입니다. </a> <span class="ndate">2024.07.31</span></li>
					<li><a href="#"> 공지사항 게시판 입니다. </a> <span class="ndate">2024.07.31</span>
					</li>
				</ul>
			</div>
		</div>
	</div>
</div>