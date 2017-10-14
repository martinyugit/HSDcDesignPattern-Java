<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!-- Begin Body -->
<div class="container">
	<div class="row">
		<div class="span12">
			<h2>選擇維護功能</h2>
			<p><a href="${pageContext.request.contextPath }/fm/cust">維護客戶資料</a></p>
			<p><a href="${pageContext.request.contextPath }/fm/supp">維護廠商資料</a></p>
			<p><a href="${pageContext.request.contextPath }/fm/prod">維護產品資料</a></p>
		</div>
	</div>
</div>
