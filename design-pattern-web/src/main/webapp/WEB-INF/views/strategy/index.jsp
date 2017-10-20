<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!-- Begin Body -->
<div class="container">
	<div class="row">
		<div class="span12">
			<h2></h2>
			輸入金額:
		    <input id="inputNum">
		    &nbsp;
			<button id="doAction">執行</button>
			
			<br/>
			<div id="result" style="display:none"></div>
		</div>
		
		<hr>
		<img src="${pageContext.request.contextPath }/resources/image/Strategy_.svg">
		<br><br>
		<img src="${pageContext.request.contextPath }/resources/image/Strategy1.svg">
		<img src="${pageContext.request.contextPath }/resources/image/Strategy_example1.svg">
	</div>
</div>

<script>
$("#doAction").click(function () {
    var inputdata = { inputStr: $("#inputStr").val() };
    $.ajax({
        type: 'GET',
        url: '${pageContext.request.contextPath }/stg/doaction/' + $("#inputStr").val(),
        datatype: 'application/json',
        //data: inputdata,
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