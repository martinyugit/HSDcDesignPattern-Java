<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!-- Begin Body -->
<div class="container">
	<div class="row">
		<div class="span12">
<h2>查詢員工資訊</h2>

請選擇部門:
<select id="deptId">
    <option>-</option>
    <c:forEach var="dept" items="${depts}">
    	<option>${dept}</option>
    </c:forEach>
</select>
<br />
<div id="divResult" style="display:none">
</div>
		</div>
	</div>
</div>

<script>
$("#deptId").change(function () {
    var value = $("#deptId").val();
    if (value == "-") {
        alert("請先選擇一個部門");
        $("#divResult").hide();
        return;
    }
    var inputdata = { deptName: value };
    $.ajax({
        type: 'GET',
        url: '${pageContext.request.contextPath }/cp/qe/' + value,
        datatype: 'application/json',
        data: inputdata,
        async: false,
        success: function (data) {
        	console.log(data);
            var div = $("#divResult");
            div.empty();
            var html = "<p>所有員工共" + data.results.length + "人</p>";
            html += "<p>員工列表如下:</p>";
            $.each(data.results, function (i, item) {
                html += "<p>" + data.results[i] + "</p>";
            });
            div.append(html);
            div.show();
        }
    });
});
</script>