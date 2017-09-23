<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!-- Begin Body -->
<div class="container">
	<div class="row">
		<div class="span12">
<h2>PXHome 訂單出貨查詢</h2>

請選擇訂單號碼:
    <select id="selOid">
        <option>-</option>
        <option>ORD1411140001</option>
        <option>ORD1411140002</option>
        <option>ORD1411140003</option>
    </select>

<br />

<div id="divResult" style="display:none">
</div>
		</div>
	</div>
</div>

<script>
$("#selOid").change(function () {
    var value = $("#selOid").val();
    if (value == "-") {
        alert("請先選擇一筆訂單");
        $("#divResult").hide();
        return;
    }
    $.ajax({
        type: 'GET',
        url: '${pageContext.request.contextPath }/bg/qo/' + value,
        datatype: 'application/json',
        async: false,
        success: function (data) {
            var div = $("#divResult");
            div.empty();
            var html = "<p>該訂單目前狀態為:</p>";
            html += "<p>" + data.result + "</p>"
            div.append(html);
            div.show();
        }
    });
});
</script>