<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!-- Begin Body -->
<div class="container">
	<div class="row">
		<div class="span12">
			<h2>辦公室自動化系統</h2>
				<button id="newLeave">新增請假單</button>
				<br />
				<br />
				<button id="newApplyExpense">新增費用申請單</button>
		</div>
	</div>
</div>

<script>
	$("#newLeave").click(function () {
	    window.location.href = "${pageContext.request.contextPath }/bd/nlv";
	});
	$("#newApplyExpense").click(function () {
	    window.location.href = "${pageContext.request.contextPath }/bd/nae";
	});
</script>