<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!-- Begin Body -->
<div class="container">
	<div class="row">
		<div class="span12">
			<h2>新增請假單結果</h2>
				<table>
					<tr>
            <th>請假單號</th>
            <td>${o.leaveID }</td>
        	</tr>
					<tr>
						<th>申請人</th>
						<td>${o.applier}</td>
					</tr>
					<tr>
						<th>申請類別</th>
						<td>${o.leaveType}</td>
					</tr>
					<tr>
						<th>申請日期</th>
						<td><fmt:formatDate pattern="yyyy-MM-dd" value="${o.leaveBeginDate}" /></td>
					</tr>
					<tr>
						<th>總申請日</th>
						<td>${o.leaveDay}</td>
					</tr>
				</table>
				<br />
				<br />
		</div>
	</div>
</div>
