<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
  
	<title>更新用户</title>
	
  </head>
  
  <body>
	<form action="/malasong/users/${user.id}" method="POST">
		<input type="hidden" name="_method" value="PATCH" />
		姓名: <input name="name" value="${user.name}" />
		年龄: <input name="year" value="${user.year}" />
		班级: 
		<c:forEach var="clazz" items="${clazzes}">
		<select name="clazz.id">
			<option value="${clazz.id}" <c:if test="${clazz.id == user.clazz.id }">checked</c:if>>${clazz.name}</option>
		</select>
		</c:forEach>
		<input type="submit" value="更改">
	</form>

  </body>
</html>