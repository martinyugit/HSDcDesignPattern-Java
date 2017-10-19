<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!-- Begin Body -->
<div class="container">
	<div class="row">
		<div class="span12">
			<h2></h2>
			請輸入Handler個數:
		    <select id="handlerNum">
		        <option>1</option>
		        <option>2</option>
		        <option>3</option>
		        <option>4</option>
		        <option>5</option>
		        <option>6</option>
		        <option>7</option>
		        <option>8</option>
		        <option>9</option>
		        <option>10</option>
		    </select>
		    
		    <br/>
			<button id="doAction">執行</button>
			
			<br />
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
        url: '${pageContext.request.contextPath }/cor/handlerNum/'+$('#handlerNum').val(),
        datatype: 'application/json',
        async: false,
        success: function (data) {
            $("#result").val(data.response);
        }
    });
});
</script>