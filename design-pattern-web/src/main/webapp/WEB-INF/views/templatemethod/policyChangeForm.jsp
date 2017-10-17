<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!-- Begin Body -->
<div class="container">
	<div class="row">
		<div class="span12">
<h2>保單異動作業</h2>

選擇異動作業：
<select id="transactionType">
    <option value="-">請選擇</option>
    <option value="PolicyLoan">保單借款</option>
    <option value="ChangeInsuredName">更改被保人姓名</option>
    <option value="ChangeAddress">更改地址</option>
</select>

<div id="policyList" style="display:none">
</div>
		</div>
		<img src="${pageContext.request.contextPath }/resources/image/templatemethod.jpg">
	</div>
</div>

<script>
        $("#transactionType").change(function () {
            var value = $("#transactionType").val();
            if (value == "-") {
                $("#policyList").hide();
                return;
            }
            $.ajax({
                type: 'GET',
                url: '${pageContext.request.contextPath }/tm/qt/' + value,
                datatype: 'application/json',
                async: false,
                success: function (data) {
                    var div = $("#policyList");
                    div.empty();
                    var html = "";
                    $.each(data, function (i, item) {
                        if (item.canEdit) {
                            html = "<p>有異動權限保單:</p>";
                            html += "<table class='table'>";
                            html += "<tr><th>保單號碼</th><th>險種</th><th>要保人</th><th>被保險人</th></tr>"
                            $.each(item.policies, function (j, p) {
                                html += "<tr>";
                                html += "<td>" + p.policyNumber + "</td>";
                                html += "<td>" + p.policyName + "</td>";
                                html += "<td>" + p.policyOwnerName + "</td>";
                                html += "<td>" + p.policyInsuredName + "</td>";
                                html += "</tr>";
                            });
                            html += "</table>";
                        } else {
                            html += "<p>無異動權限保單:</p>"
                            html += "<table class='table'>";
                            html += "<tr><th>保單號碼</th><th>險種</th><th>要保人</th><th>被保險人</th></tr>"
                            $.each(item.policies, function (j, p) {
                                html += "<tr>";
                                html += "<td>" + p.policyNumber + "</td>";
                                html += "<td>" + p.policyName + "</td>";
                                html += "<td>" + p.policyOwnerName + "</td>";
                                html += "<td>" + p.policyInsuredName + "</td>";
                                html += "</tr>";
                            });
                            html += "</table>";
                        }
                    });
                    div.append(html);
                    div.show();
                }
            });
        });
    </script>