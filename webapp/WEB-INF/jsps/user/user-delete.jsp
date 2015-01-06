<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
  
	<title>用户列表</title>
	
  </head>
  
  <body>
	<form action="/malasong/users/${user.id}" method="POST">
		<input type="hidden" name="_method" value="DELETE" />
		<input type="submit" value="确认" />
		<a href="/malasong/users">取消</a>
	</form>

  </body>
</html>