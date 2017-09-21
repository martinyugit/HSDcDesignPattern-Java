<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!-- Begin Body -->
<div class="container">
	<div class="row">
		<div class="span12">
			<h2>Prototype範例</h2>
				<button id="rf">RingleFramework範例</button>
				<br />
				<br />
				<button id="rerp">RingleERP範例</button>
		</div>
	</div>
</div>

<script>
	$("#rf").click(function () {
	    window.location.href = "${pageContext.request.contextPath }/pt/rf";
	});
	$("#rerp").click(function () {
	    window.location.href = "${pageContext.request.contextPath }/pt/rerp";
	});
</script>