<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!-- Begin Body -->
<div class="container">
	<div class="row">
		<div class="span12">
			<h2>威力彩</h2>
			<table>
			    <tr>
			        <th>請輸入獎號:</th>
			        <td>
			        	<button id="doComputerSelNum">電腦選號</button>
			        	<button id="doAppend">下注</button>
			        	<button id="doUpdate" disabled>修改</button>
			        </td>
			    </tr>
			</table>
			
			<br />
			<div id="result" style="display:none"></div>
		</div>
		
		<hr>
		<img src="${pageContext.request.contextPath }/resources/image/AdapterDiagram.png">
		
		<hr>
		[Object Adapter pattern]
		<br>
		<img src="${pageContext.request.contextPath }/resources/image/300px-ObjectAdapter.png">
		<img src="${pageContext.request.contextPath }/resources/image/500px-Adapter(Object)_pattern_in_LePUS3.png">

		<hr>
		[Class Adapter pattern]
		<br>
		<img src="${pageContext.request.contextPath }/resources/image/300px-ClassAdapter.png">
		<img src="${pageContext.request.contextPath }/resources/image/500px-Adapter(Class)_pattern_in_LePUS3.png">
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