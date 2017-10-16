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
						<th>購買項目</th>
						<th>總金額</th>
					</tr>
				</thead>
				<tbody>
							<c:forEach var="po" items="${polist}">
								<tr>
									<td>${po.poNumber}</td>
									<td>${po.customerName}</td>
									<td>
										<table class="table-bordered">
											<tr>
												<th>商品名稱</th>
												<th>數量</th>
												<th>單價</th>
												<th>小計</th>
											</tr>
											<c:forEach var="pod" items="${po.lineItems}">
												<tr>
													<td>${pod.productName}</td>
													<td>${pod.quantity}</td>
													<td>${pod.price}</td>
													<td>${pod.subTotal}</td>
												</tr>
											</c:forEach>
										</table>
									</td>
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