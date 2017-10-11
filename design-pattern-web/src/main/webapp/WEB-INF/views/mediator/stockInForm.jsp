<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!-- Begin Body -->
<div class="container">
	<div class="row">
		<div class="span12">
<h2>入庫</h2>

    <p>請選擇產品:
    <select id="prodName" name="prodName">
        <option value="0">請選擇</option>
        <c:forEach var="p" items="${products}">
        	<option>${p.productName}</option>
        </c:forEach>
    </select>
    </p>
<p>請輸入數量:<input type="text" id="qty" value="" /></p>

<button id="stockin">入庫</button>
<br />
<div id="msg" style="display:none"></div>

		</div>
	</div>
</div>

<script src="${pageContext.request.contextPath }/resources/js/sockjs-1.0.0.min.js"></script>
<script src="${pageContext.request.contextPath }/resources/js/stomp.min.js"></script>
<script type="text/javascript">
	var stompClient = null;
	function connect() {
		var socket = new SockJS('/design-pattern-web/stocking');
		stompClient = Stomp.over(socket);
		stompClient.connect({method: "stockin"}, function(frame) {
			//console.log('Connected: ' + frame);
			stompClient.subscribe('/topic/sellOut', function(messageOutput) {
				//console.log(messageOutput.body);
				notify(messageOutput.body);
			});
		});
	}

	function disconnect() {
		if (stompClient != null) {
			stompClient.disconnect();
		}
		setConnected(false);
		//console.log("Disconnected");
	}
	
	function notify(prodName) {
		var div = $("#msg");
        var html = "<p>產品-" + prodName + " 目前已缺貨，請快補貨 !!!!</p>";
        div.empty();
        div.append(html);
        div.show();
	}
	
	$('#stockin').click(function () {
		var value = $("#prodName").val();
        if (value == "0") {
            alert("請先選擇一筆產品");
            $("#msg").hide();
            return;
        }
		$.ajax({
            type: 'GET',
            url: '${pageContext.request.contextPath }/md/stockIn/' + $("#prodName").val() + '/' + $('#qty').val(),
            datatype: 'application/json',
            async: false,
            success: function (data) {
            }
        });
	});
	
</script>