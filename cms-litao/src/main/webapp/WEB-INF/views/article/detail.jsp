<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="/public/css/bootstrap.min.css" rel="stylesheet">
<link href="/public/css/index.css" rel="stylesheet">
<title>${article.title }</title>
</head>
<body>
	<nav class="nav justify-content-start" style="background-color: #222;">
		<a class="nav-link navbar-brand" href="/"> <img
			src="https://v4.bootcss.com/docs/4.3/assets/brand/bootstrap-solid.svg"
			width="30" height="30" alt="">
		</a>
		<c:if test="${USER_SESSION_ID!=null }">
			<a class="nav-link" href="/user/center">发文</a>
			<a class="nav-link" href="/user/center">个人中心</a>
			<a class="nav-link" href="javascript:;">${USER_SESSION_ID.nickname }</a>
			<a class="nav-link" href="/user/logout">退出</a>
		</c:if>
		<c:if test="${USER_SESSION_ID==null }">
			<a class="nav-link" href="/user/login">登录</a>
		</c:if>
	</nav>
	<div class="container-fluid">
		<div class="row offset-1" style="margin-top: 15px;">
			<div class="col-7">
				<h1>${article.title }</h1>
				<div style="margin-top: 10px;margin-bottom: 10px;font-weight: bold;">
					<span>${user.nickname }</span> 
					<span><fmt:formatDate value="${article.created}" pattern="yyyy-MM-dd HH:mm:ss"/></span>
				</div>
				<div style="font-size: 24">
					${article.content }
				</div>
			</div>

			<div class="col-3">
				<c:if test="${articleList.size()>0 }">
					<div class="right">
						<div>相关文章</div>
						<ul class="list-unstyled">
							<c:forEach items="${articleList }" var="item">
								<li class="media">
									<a href="/article/${item.id }.html"><img style="width: 64px; height: 64px;"	src="${item.picture }" class="mr-3" alt=""></a>
									<div class="media-body">
										<h5 class="mt-0 mb-1"><a href="/article/${item.id }.html">${item.title }</a></h5>
									</div>
								</li>
							</c:forEach>
						</ul>
					</div>
				</c:if>
			</div>
		</div>
	</div>

	<script type="text/javascript" src="/public/js/jquery.min.1.12.4.js"></script>
	<script type="text/javascript" src="/public/js/bootstrap.min.js"></script>
</body>
</html>