<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!-- Begin Body -->
<div class="container">
	<div class="row">
		<div class="span12">
<h2>線上訂購</h2>

    <p>請選擇產品:
    <select id="prodName" name="prodName">
        <option value="0">請選擇</option>
        <c:forEach var="p" items="${products}">
        	<option>${p.productName}</option>
        </c:forEach>
    </select>
    </p>

<button id="order" disabled="disabled">開始搶購</button>
<br />
<div id="msg" style="display:none">當可以訂貨時，馬上按下開始訂購開始搶購</div>

		</div>
	</div>
</div>

<script src="${pageContext.request.contextPath }/resources/js/sockjs-1.0.0.min.js"></script>
<script src="${pageContext.request.contextPath }/resources/js/stomp.min.js"></script>
<script type="text/javascript">
	var stompClient = null;
	function connect() {
		var socket = new SockJS('/design-pattern-web/order');
		stompClient = Stomp.over(socket);
		stompClient.connect({method: "order"}, function(frame) {
			//console.log('Connected: ' + frame);
			stompClient.subscribe('/topic/hasStocking', function(messageOutput) {
				//console.log(messageOutput.body);
				notify(messageOutput.body);
			});
			stompClient.subscribe('/topic/addSellOut', function(messageOutput) {
				//console.log(messageOutput.body);
				addSellOut(messageOutput.body);
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
	
	function addSellOut(prodName) {
		var value = $("#prodName").val();
        if (value == prodName) {
            var div = $("#msg");
            $('#order').attr("disabled", "disabled");
            div.show();
        }
	}
	
	function notify(prodName) {
		var value = $("#prodName").val();
        if (value == prodName) {
            $("#msg").hide();
            $('#order').removeAttr("disabled");
        }
	}
	
	$('#order').click(function () {
		$.ajax({
            type: 'GET',
            url: '${pageContext.request.contextPath }/md/order/' + $("#prodName").val(),
            datatype: 'application/json',
            async: false,
            success: function (data) {
            }
        });
	});
	
	$("#prodName").change(function () {
		var value = $("#prodName").val();
        if (value == "0") {
            alert("請先選擇一筆產品");
            $("#msg").hide();
            return;
        }
        var inputdata = { prodName: value };
        $.ajax({
            type: 'GET',
            url: '${pageContext.request.contextPath }/md/cq/' + $("#prodName").val(),
            datatype: 'application/json',
            async: false,
            success: function (data) {
                var div = $("#msg");
                if (data) {
                    $('#order').attr("disabled", "disabled");
                    div.show();
                } else {
                    $('#order').removeAttr("disabled");
                    div.hide();
                }
            }
        });
    });
	
	
</script>