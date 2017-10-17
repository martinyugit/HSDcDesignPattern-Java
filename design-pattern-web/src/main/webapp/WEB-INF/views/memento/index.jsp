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
			    </tr>
			    <tr align="center" >
			    	<td colspan="6">第一區</td>
			    	<td>第二區</td>
			    	<td>&nbsp;</td>
			    </tr>
			        <td colspan="6">
			        	<input type="text" id="inputNum1" value="0" size="1" style="text-align:center;"/>
			        	<input type="text" id="inputNum2" value="0" size="1" style="text-align:center;"/>
			        	<input type="text" id="inputNum3" value="0" size="1" style="text-align:center;"/>
			        	<input type="text" id="inputNum4" value="0" size="1" style="text-align:center;"/>
			        	<input type="text" id="inputNum5" value="0" size="1" style="text-align:center;"/>
			        	<input type="text" id="inputNum6" value="0" size="1" style="text-align:center;"/>
			        </td>
			        <td>
			        	<input type="text" id="inputNum7" value="0" size="1" style="text-align:center;"/>
			        </td>
			        <td colspan="2">
			        	<button id="doComputerSelNum">電腦選號</button>
			        	<button id="doAppend">下注</button>
			        	<button id="doUpdate" disabled>修改</button>
			        </td>
			    </tr>
			</table>
			
			<br />
			<div id="result" style="display:none"></div>
		</div>
		<img src="${pageContext.request.contextPath }/resources/image/Memento-1.jpg">
	</div>
</div>

<script>
function setNumber(data){
	var num = data.split(',');
	$("#inputNum1").val(num[0]);
	$("#inputNum2").val(num[1]);
	$("#inputNum3").val(num[2]);
	$("#inputNum4").val(num[3]);
	$("#inputNum5").val(num[4]);
	$("#inputNum6").val(num[5]);
	$("#inputNum7").val(num[6]);
}

$("#doComputerSelNum").click(function () {
    $.ajax({
        type: 'GET',
        url: '${pageContext.request.contextPath }/mem/computerSelNum',
        datatype: 'application/json',
        data: null,
        async: false,
        success: function (data) {
        	setNumber(data);
        },
        error: function(data) {
        }
    });
});

function getList(){
    var inputdata = null;
    $.ajax({
        type: 'GET',
        url: '${pageContext.request.contextPath }/mem/list',
        datatype: 'application/json',
        data: inputdata,
        async: false,
        success: function (data) {
        	data = data.split('|');
            var div = $("#result");
            div.empty();
            var html = '';
            for(var i=0; i<data.length-1; i++){
            	html += '<p>(' + (i+1) + ')'
            	html += '&nbsp;&nbsp;&nbsp;' + data[i];
            	html += '&nbsp;<button onclick="doDelete(' + i + ')">刪除</button>';
            	html += '&nbsp;<button onclick="doRestore(' + i + ')">修改</button>';
            	html += '</p>';
            }
            div.append(html);
            div.show();
        },
        error: function(data) {
        }
    });
    
    $("#doUpdate").prop("disabled", true);
}

function getNumber(){
	return $("#inputNum1").val()
		+ ',' + $("#inputNum2").val()
		+ ',' + $("#inputNum3").val()
		+ ',' + $("#inputNum4").val() 
		+ ',' + $("#inputNum5").val() 
		+ ',' + $("#inputNum6").val() 
		+ ',' + $("#inputNum7").val()
		;
}

$("#doAppend").click(function () {
    var inputdata = { inputNum: getNumber()};
    $.ajax({
        type: 'GET',
        url: '${pageContext.request.contextPath }/mem/append',
        datatype: 'application/json',
        data: inputdata,
        async: false,
        success: function (data) {},
        error: function(data) {}
    });
    getList();
    $("#doUpdate").disabled = !true;
});

function doDelete(idx){
    var inputdata = { inputIdx: idx};
	$.ajax({
	   type: 'GET',
	   url: '${pageContext.request.contextPath }/mem/delete',
	   datatype: 'application/json',
	   data: inputdata,
	   async: false,
	   success: function (data) {},
	   error: function(data) {}
	});
	getList();
}

var restoreNum;
function doRestore(idx){
	restoreNum = idx;
    var inputdata = { inputIdx: idx};
	$.ajax({
	   type: 'GET',
	   url: '${pageContext.request.contextPath }/mem/restore',
	   datatype: 'application/json',
	   data: inputdata,
	   async: false,
	   success: function (data) {setNumber(data)},
	   error: function(data) {}
	});
	
	getList();
	
	$("#doUpdate").prop("disabled", false);
}

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