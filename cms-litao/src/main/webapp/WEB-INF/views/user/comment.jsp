<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cms后台登录</title>
<link href="/public/css/bootstrap.min.css" rel="stylesheet">
<link href="/public/css/cms.css" rel="stylesheet">
</head>
<body>
	<table class="table">
		<thead>
			<tr>
				<th scope="col">#</th>
				<th scope="col">文章标题</th>
				<th scope="col">评论内容</th>
				<th scope="col">评论时间</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${pageInfo.list }" var="item">
				<tr>
					<th scope="row">${item.id }</th>
					<td>${item.nickname }</td>
					<td>${item.content }</td>
					<td>${item.created }</td>
				</tr>
				
			</c:forEach>

		</tbody>
	</table>

	<script type="text/javascript" src="/public/js/bootstrap.min.js"></script>
</body>
</html>