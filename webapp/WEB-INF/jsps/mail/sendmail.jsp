<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
		  	
  	<%@ include file="/WEB-INF/include/meta.jsp" %>
  	<%@ include file="/WEB-INF/include/css.jsp" %>
	
	<title>发送邮件</title>

  </head>
  
  <body>
	
	<%@ include file="/WEB-INF/include/header.jsp" %>

	<div class="container main-content">
	
		<form class="form-horizontal" method="post" action="/malasong/mail">

    		<div class="modal-body">

   				<div class="form-group demo2do-form-group">
      				<label class="col-xs-3 control-label">发件人</label>
      				<div class="col-xs-7">
 						<input type="text" class="form-control" name="from" value="" />
      				</div>
   				</div>

				<div class="form-group demo2do-form-group">
         			<label class="col-xs-3 control-label">收件人</label>
         			<div class="col-xs-7">
			 			<input type="text" class="form-control" name="to" value="" />
         			</div>
      			</div>

				<div class="form-group demo2do-form-group">
         			<label class="col-xs-3 control-label">内容</label>
         			<div class="col-xs-7">
         				<textarea rows="4" class="form-control" name="content"></textarea>
         			</div>
      			</div>

    		</div>

	      	<div class="modal-footer">
	        	<button type="submit" class="btn btn-success btn-shadow btn-shadow-success demo2do-btn">提交</button>
	      	</div>
	
	    </form>
	
  	</div>

	<%@ include file="/WEB-INF/include/script.jsp" %>
	
  </body>
</html>