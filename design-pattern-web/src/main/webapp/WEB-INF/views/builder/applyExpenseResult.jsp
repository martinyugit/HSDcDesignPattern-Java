<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!-- Begin Body -->
<div class="container">
	<div class="row">
		<div class="span12">
			<h2>新增費用申請單結果</h2>
				<table>
					<tr>
            <th>費用申請單單號</th>
            <td>${o.applyExpenseID }</td>
        	</tr>
					<tr>
						<th>申請人</th>
						<td>${o.applier}</td>
					</tr>
					<tr>
						<th>申請類別</th>
						<td>${o.applyExpenseType}</td>
					</tr>
					<tr>
						<th>申請日期</th>
						<td><fmt:formatDate pattern="yyyy-MM-dd" value="${o.applyDate}" /></td>
					</tr>
					<tr>
						<th>總申請金額</th>
						<td>${o.totalExpense}</td>
					</tr>
				</table>
				<br />

			<table class="table-bordered">
				<tr>
					<th>OccureDate</th>
					<th>Expense</th>
				</tr>
				<c:forEach var="pod" items="${o.lineItems}">
					<tr>
						<td><fmt:formatDate pattern="yyyy-MM-dd" value="${pod.occureDate}" /></td>
						<td>${pod.expense}</td>
					</tr>
				</c:forEach>

			</table>

			<br />
		</div>
	</div>
</div>
