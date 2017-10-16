<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!-- Begin Body -->
<div class="container">
	<div class="row">
		<div class="span12">
			<h2>維護產品資料</h2>
			<table class="table-bordered">
				<thead>
					<tr>
						<th>產品編號</th>
						<th>產品名稱</th>
						<th>產品類別</th>
						<th>產品建議售價</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="p" items="${products}">
						<tr>
							<td>${p.productID}</td>
							<td>${p.productName}</td>
							<td>${p.productType}</td>
							<td align="right">${p.productMSRP}</td>
							<td><a
								href="${pageContext.request.contextPath }/fm/prod/${p.productID}">編輯</a>
								<a
								href="${pageContext.request.contextPath }/fm/prod/del/${p.productID}">刪除</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</div>
