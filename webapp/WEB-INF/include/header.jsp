<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

	<div class="header">
		<div class="container">
		
			<h1 class="logo">
				<a title="马拉松超级系统" href="${ctx}">马拉松超级系统</a>
			</h1>
			
			<sec:authorize access="isFullyAuthenticated()">
				<%@ include file="/WEB-INF/include/welcome.jsp" %>	
			</sec:authorize>
			
		</div>
	</div>