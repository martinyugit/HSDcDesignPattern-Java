<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!-- Begin Body -->
<div class="container">
	<div class="row">
		<div class="span12">
			<h2>維護客戶資料</h2>
			<table class="table-bordered">
				<thead>
					<tr>
						<th>客戶編號</th>
						<th>客戶姓名</th>
						<th>客戶聯絡人</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="c" items="${customers}">
						<tr>
							<td>${c.customerID}</td>
							<td>${c.customerName}</td>
							<td align="right">${c.customerContactPerson}</td>
							<td><a
								href="${pageContext.request.contextPath }/fm/cust/${c.customerID}">編輯</a>
								<a
								href="${pageContext.request.contextPath }/fm/cust/del/${c.customerID}">刪除</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</div>
