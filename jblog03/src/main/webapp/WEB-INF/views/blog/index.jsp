<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JBlog</title>
<Link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/jblog.css">
</head>
<body>
	<div id="container">
		<div id="header">
			<h1>${setBlogVo2.title }</h1>
			<ul>
				<li><a href="${pageContext.request.contextPath }/user/login">로그인</a></li>
				<li><a href="${pageContext.request.contextPath }/user/logout">로그아웃</a></li>
				<li><a href="${pageContext.request.contextPath }/${authUser.id }/admin">블로그 관리</a></li>
			</ul>
		</div>
		<div id="wrapper">
			<div id="content">
				<div class="blog-content">
					<h4>${getIndex.title }</h4>
					<p>
						${getIndex.contents }
					<p>
				</div>
				<c:forEach items="${postTitle }" var="vo" varStatus="status">
					<ul class="blog-list">
						<li><a href="">${vo.title }</a> <span>${vo.regDate }</span> </li>
					</ul>
				</c:forEach>
			</div>
		</div>

		<div id="extra">
			<div class="blog-logo">
				<a href="${pageContext.request.contextPath }/${authUser.id }${setBlogVo2.profile }"></a>
			</div>
		</div>

		<div id="navigation">
			<h2>카테고리</h2>
			
			<ul>
				<c:forEach items="${categoryList }"	var="vo" varStatus="status">
	      			<li><a href="">${vo.title }</a></li>		
		      	</c:forEach>
			</ul>
		</div>
		
		<div id="footer">
			<p>
				<strong>${authUser.name }님의 블로그입니다.</strong> is powered by JBlog (c)2022
			</p>
		</div>
	</div>
</body>
</html>