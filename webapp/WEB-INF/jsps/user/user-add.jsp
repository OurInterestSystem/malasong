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
		<select name="clazz.id">
		<c:forEach var="clazz" items="${clazzes}">
			<option value="${clazz.id}">${clazz.name}</option>
		</c:forEach>
		</select>	
		<input type="submit" value="创建">
	</form>

  </body>
</html>