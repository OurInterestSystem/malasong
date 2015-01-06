<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
		  	
  	<%@ include file="/WEB-INF/include/meta.jsp" %>
  	<%@ include file="/WEB-INF/include/css.jsp" %>
	
	<title>马拉松编程超级系统  - 登录</title>

  </head>
  
  <body>
	
	<%@ include file="/WEB-INF/include/header.jsp" %>
	
	<div id="banner">
		
		<div class="container">
			
			<div id="login-panel" class="well">
			
				<form id="login-form" action="/malasong/j_spring_security_check" method="POST" data-validate="true">
					
					<h2>账号&nbsp;-&nbsp;登录</h2>
					
					<c:if test="${not empty errorMessage}">
						<div class="alert alert-danger"><i class="glyphicon glyphicon-remove"></i>&nbsp;&nbsp;${errorMessage}</div>
					</c:if>
					
					<div class="input-group input-group-lg">
					  <span class="input-group-addon"><span class="glyphicon glyphicon-user"></span></span>
					  <input type="text" class="form-control" placeholder="账号" name="j_username" value="" data-validate="required" />
					</div>
					
					<div class="input-group input-group-lg">
					  <span class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></span>
					  <input type="password" class="form-control" placeholder="密码"  name="j_password" data-validate="required" />
					</div>
					
					<div class="form-inline">
					      
					    <button class="btn btn-success btn-shadow btn-shadow-success demo2do-btn pull-right" type="submit">登录</button>
					    
					</div>
					
				</form>
				
			</div>
			
		</div>
		
	</div>
  	
	<%@ include file="/WEB-INF/include/script.jsp" %>
	
  </body>
</html>