<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!-- Begin Body -->
<div class="container">
	<div class="row">
		<div class="span12">
			<h2>取得採購清單</h2>
			<table class="table-bordered">
				<colgroup>
					<col width="100" />
					<col width="400" />
					<col width="300" />
				</colgroup>
				<thead>
					<tr>
						<th>採購編號</th>
						<th>客戶名稱</th>
						<th>總金額</th>
					</tr>
				</thead>
				<tbody>
							<c:forEach var="po" items="${polist}">
								<tr>
									<td>${po.poNumber}</td>
									<td>${po.customerName}</td>
									<td align="right">${po.total}</td>
								</tr>
							</c:forEach>
				</tbody>
			</table>
			<br /> <br />
			<button id="newPo">新增採購單</button>
			<form id="newPoFrm" action="${pageContext.request.contextPath }/pt/rfa" method="get"></form>
		</div>
	</div>
</div>

<script>
	$("#newPo").click(function() {
		$("#newPoFrm").submit();
	});
</script>