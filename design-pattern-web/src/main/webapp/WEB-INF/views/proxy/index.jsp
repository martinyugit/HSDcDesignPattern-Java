<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!-- Begin Body -->
<div class="container">
	<div class="row">
		<div class="span12">
			<h2>Proxy</h2>
			<table>
			    <tr>
			        <th></th>
			        <td>
			        	<button id="doAction">確定</button>
			        </td>
			    </tr>
			</table>
			
			<br />
			<div id="result" style="display:none"></div>
		</div>
		
		<hr>
		<img src="${pageContext.request.contextPath }/resources/image/Proxy1.svg">
		<img src="${pageContext.request.contextPath }/resources/image/Proxy_example1.svg">
	</div>
</div>

<script>
$("#doUpdate").click(function () {
    var inputdata = { inputIdx: restoreNum, inputNum: getNumber()};
	$.ajax({
		   type: 'GET',
		   url: '${pageContext.request.contextPath }/mem/update',
		   datatype: 'application/json',
		   data: inputdata,
		   async: false,
		   success: function (data) {},
		   error: function(data) {}
	});
	getList();
});
</script>