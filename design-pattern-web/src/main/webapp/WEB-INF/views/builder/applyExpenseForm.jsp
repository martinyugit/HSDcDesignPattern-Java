<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!-- Begin Body -->
<div class="container">
	<div class="row">
		<div class="span12">
			<h2>新增費用申請單</h2>
			<form:form id="frmSave" method="POST"
				commandName="${pageContext.request.contextPath }/bd/nae" modelAttribute="form">
				<table>
					<tr>
						<th>申請人</th>
						<td><form:input path="applier" /></td>
					</tr>
					<tr>
						<th>申請類別</th>
						<td><form:input path="applyExpenseType" /></td>
					</tr>
					<tr>
						<th>申請日期</th>
						<td><form:input path="applyDate" /></td>
					</tr>
					<tr>
						<th>總申請金額</th>
						<td><form:input path="totalExpense" /></td>
					</tr>
				</table>
				<br />

				<input type="button" value="Add Row" onclick="addRow('dataTable')" />
				<input type="button" value="Delete Row"
					onclick="deleteRow('dataTable')" />
				<table id="dataTable" width="350px" border="1">
					<tr>
						<th>&nbsp;</th>
						<th>OccureDate</th>
						<th>Expense</th>
					</tr>
					<tr>
						<td>
							<INPUT type="checkbox" name="chk" />
						</td>
						
						<td>
							<input type='text' name="lineItems[0].occureDate" />
						</td>
						<td>
							<input type='text' name="lineItems[0].expense" />
						</td>
					</tr>
				</table>


				<br />
				<button id="save">儲存</button>
			</form:form>
		</div>
	</div>
</div>

<script>
	$("#save").click(function() {
		$("#frmSave").submit();
	});

	function addRow(tableID) {

		var table = document.getElementById(tableID);

		var rowCount = table.rows.length;
		var row = table.insertRow(rowCount);

		var cell1 = row.insertCell(0);
		var element1 = document.createElement("input");
		element1.type = "checkbox";
		element1.name = "chkbox[]";
		cell1.appendChild(element1);

		

		var cell2 = row.insertCell(1);
		var element2 = document.createElement("input");
		element2.type = "text";
		var length = (table.rows.length) - 2;
		element2.name = "lineItems[" + length + "].occureDate";
		cell2.appendChild(element2);
		
		var cell3 = row.insertCell(2);
		var element3 = document.createElement("input");
		element3.type = "text";
		
		element3.name = "lineItems[" + length + "].expense";
		cell3.appendChild(element3);

	}

	function deleteRow(tableID) {
		try {
			var table = document.getElementById(tableID);
			var rowCount = table.rows.length;

			for (var i = 1; i < rowCount; i++) {
				var row = table.rows[i];
				var chkbox = row.cells[0].childNodes[0];
				if (null != chkbox && true == chkbox.checked) {
					table.deleteRow(i);
					rowCount--;
					i--;
				}
			}
		} catch (e) {
			alert(e);
		}
	}
</script>