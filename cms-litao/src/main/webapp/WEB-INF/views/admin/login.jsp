<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="<%=request.getContextPath() %>/css/bootstrap.min.css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body style="background:url(<%=request.getContextPath() %>/img/wallhaven-96ede8.png);">
<div id="login" align="center">
        <h3 class="text-center text-white pt-5">登录界面</h3>
        <div class="container">
            <div id="login-row" class="row justify-content-center align-items-center">
                <div id="login-column" class="col-md-10">
                    <div id="login-box" class="col-md-12" style="opacity: 0.8">
                        <form id="login-form" class="form" action="" method="post">
                        <h3 class="text-center text-info">Login</h3>
                            <div class="form-group col-mt-10">
                                <label for="username" class="text-info" ><br></label><br>
                                <input type="text" name="username" id="username" class="form-control" placeholder="请输入用户名">
                            </div>
                            <div class="form-group">
                                <label for="password" class="text-info"><br></label><br>
                                <input type="password" name="password" id="password" class="form-control" placeholder="请输入密码">
                            </div>
                            <div class="form-group">
                                <!-- <label for="remember-me" class="text-info"><span>Remember me</span> <span><input id="remember-me" name="remember-me" type="checkbox"></span></label><br> -->
                                <a href="home"><input type="button" name="submit" class="btn btn-info btn-md" value="登录"></a>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>