<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!-- Begin Body -->
<div class="container">
	<div class="row">
		<div class="span12">
			<h2></h2>
			輸入 x1, x2, y1, y2:
			<br/>x1: <input id="x1">
			<br/>x2: <input id="x2">
			<br/>y1: <input id="y1">
			<br/>y2: <input id="y2">
		    &nbsp;
			<button id="execute">執行</button>
			
			<br/>
			<div id="result" style="display:none"></div>
		</div>
		
		<img src="${pageContext.request.contextPath }/resources/image/Adapter.svg">
		<img src="${pageContext.request.contextPath }/resources/image/Adapter_example1.svg">
		<br><br>
		<img src="${pageContext.request.contextPath }/resources/image/Adapter_1.svg">
	</div>
</div>

<script>
$("#execute").click(function () {
    var inputdata = { x1: $("#x1").val(), x2: $("#x2").val(), y1: $("#y1").val(), y2: $("#y2").val() };
    $.ajax({
        type: 'GET',
        url: '${pageContext.request.contextPath }/ad/execute/',
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
        	alert('[error]:' + data);
        }
    });
});
</script>