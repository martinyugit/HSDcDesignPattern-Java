<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!-- Begin Body -->
<div class="container">
	<div class="row">
		<div class="span12">
			<h2></h2>
			輸入(Strategy):
			<br/>
			<select id="inputStrategy" multiple="multiple">
				<option>FOO</option>
				<option>BAR</option>
				<option>FOO</option>
				<option>BAR</option>
			</select>
		    &nbsp;
			<button id="execute">執行</button>
			
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
$("#execute").click(function () {
    //var inputdata = { inputStrategy: $("#inputStrategy").val() };
    $.ajax({
        type: 'GET',
        url: '${pageContext.request.contextPath }/stg/execute/' + $("#inputStrategy").val(),
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