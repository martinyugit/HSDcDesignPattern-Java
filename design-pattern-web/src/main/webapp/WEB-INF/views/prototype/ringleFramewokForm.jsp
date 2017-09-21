<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!-- Begin Body -->
<div class="container">
	<div class="row">
		<div class="span12">
			<h2>新增採購單</h2>
			<form:form id="frmSave" method="POST"
				commandName="${pageContext.request.contextPath }/pt/rfa" modelAttribute="form">
				<table>
        <tr>
            <th>客戶名稱</th>
            <td><input type="text" name="custName" /></td>
        </tr>
    </table>
    <br />
    <br />
    <button id="btnAdd">新增</button>
			</form:form>
		</div>
	</div>
</div>

<script>
	$("#save").click(function() {
		$("#frmSave").submit();
	});
</script>