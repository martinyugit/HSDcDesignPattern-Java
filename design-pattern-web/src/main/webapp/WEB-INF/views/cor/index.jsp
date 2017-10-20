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
		<img src="${pageContext.request.contextPath }/resources/image/Chain_of_responsibility__.svg">
		<img src="${pageContext.request.contextPath }/resources/image/Chain_of_responsibility_example.png">
	</div>
</div>

<script>
$("#doAction").click(function () {
    $.ajax({
        type: 'GET',
        url: '${pageContext.request.contextPath }/cor/inputNum/'+$('#inputNum').val(),
        datatype: 'application/json',
        async: false,
        success: function (data) {
            var div = $('#result');
            div.empty();
            div.append('data.result');
            div.show();
        }
    });
});
</script>