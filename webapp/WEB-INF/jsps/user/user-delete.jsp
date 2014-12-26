<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
  
	<title>用户列表</title>
	
  </head>
  
  <body>
	<form action="/malasong/users" method="POST">
		姓名: <input name="name" />
		年龄: <input name="year" />
		班级: 
		<c:forEach var="clazz" items="${clazzes}">
		<select name="clazz.id">
			<option value="${clazz.id}">${clazz.name}</option>
		</select>
		</c:forEach>
		<input type="submit" value="创建">
	</form>

  </body>
</html>