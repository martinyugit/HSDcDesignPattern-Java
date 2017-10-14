<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!-- Begin Body -->
<div class="container">
	<div class="row">
		<div class="span12">
			<h2>中文數值轉換</h2>
<table>
    <tr>
        <th>請輸入數值進行轉換:</th>
        <td><input type="text" id="inputVal" value="" /></td>
    </tr>
</table>
<button id="transChinese">轉換為中文數值</button>
<br />
<div id="result" style="display:none">
</div>
		</div>
	</div>
</div>

    <script>
        $("#transChinese").click(function () {
            var inputdata = { number: $("#inputVal").val() };
            $.ajax({
                type: 'GET',
                url: '${pageContext.request.contextPath }/it/toch',
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
                }
            });
        });
    </script>