<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!-- Begin Body -->
<div class="container">
	<div class="row">
		<div class="span12">
			<h2>中文數值轉換</h2>
			<table>
			    <tr>
			        <th>請輸入字串:</th>
			        <td><input type="text" id="inputStr" value="" /></td>
			    </tr>
			</table>
			<button id="doAction">執行</button>
			<br />
			<div id="result" style="display:none"></div>
		</div>
		<img src="${pageContext.request.contextPath }/resources/image/Example_of_Facade_design_pattern_in_UML.png">
		<img src="${pageContext.request.contextPath }/resources/image/W3sDesign_Facade_Design_Pattern_UML.jpg">
	</div>
</div>

<script>
    $("#doAction").click(function () {
        var inputdata = { string: $("#inputStr").val() };
        $.ajax({
            type: 'GET',
            url: '${pageContext.request.contextPath }/fc/doaction',
            datatype: 'application/json',
            data: inputdata,
            async: false,
            success: function (data) {
                var div = $("#result");
                div.empty();
                var html = "<p>" + data + "</p>";
                div.append(html);
                div.show();
            },
            error: function(data) {
            }
        });
    });
</script>