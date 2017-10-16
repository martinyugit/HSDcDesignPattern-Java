<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!-- Begin Body -->
<div class="container">
	<div class="row">
		<div class="span12">
<h2>輸入地址</h2>

<table>
    <tr>
        <th>請選擇城市別:</th>
        <td>
            <select id="city">
                <option>-</option>
                <c:forEach var="code" items="${codes}">
                	<option value="${code.codeValue }">${code.codeText }</option>
               	</c:forEach>
            </select>
        </td>
    </tr>
</table>
<div id="areaDiv">
</div>
		</div>
	</div>
</div>

<script>
$("#city").change(function () {
    var value = $("#city").val();
    if (value == "-") {
        $("#areaDiv").hide();
        alert("請先選擇一個城市");
        return;
    }
    $.ajax({
        type: 'GET',
        url: '${pageContext.request.contextPath }/fw/qa/' + value,
        datatype: 'application/json',
        async: false,
        success: function (data) {
            var div = $("#areaDiv");
            div.empty();
            var html = "<table><tr><th>請選擇地區別:</th><td><select id='area'><option>-</option>";
            $.each(data, function (i, item) {
                html += "<option value='" + item.codeValue + "'>" + item.codeText+ "</option>";
            });
            html += "</select></td></tr></table>";
            div.append(html);
            div.show();
        }
    });
});
</script>