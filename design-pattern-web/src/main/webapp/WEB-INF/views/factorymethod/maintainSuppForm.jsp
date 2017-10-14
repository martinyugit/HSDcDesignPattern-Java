<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!-- Begin Body -->
<div class="container">
	<div class="row">
		<div class="span12">
			<h2>維護廠商資料</h2>
			<table class="table-bordered">
				<thead>
					<tr>
						<th>廠商編號</th>
						<th>廠商名稱</th>
						<th>廠商聯絡Email</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="s" items="${suppliers}">
						<tr>
							<td>${s.supplierNumber}</td>
							<td>${s.supplierName}</td>
							<td>${s.supplierContactEmail}</td>
							<td><a
								href="${pageContext.request.contextPath }/fm/supp/${s.supplierNumber}">編輯</a>
								<a
								href="${pageContext.request.contextPath }/fm/supp/del/${s.supplierNumber}">刪除</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</div>
