<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!-- Begin Body -->
<div class="container">
	<div class="row">
		<div class="span12">
<h2>使用者登入</h2>

<div id="main">
    <table>
        <tr>
            <th>使用者代號</th>
            <td><input type="text" id="userId" /></td>
        </tr>
        <tr>
            <th>使用者密碼</th>
            <td><input type="password" id="password" /></td>
        </tr>
    </table>
    <br />
    <table>
        <tr>
            <td><button id="btnDefault">基本登入</button></td>
            <td><button id="btnDb">使用DB登入</button></td>
            <td><button id="btnLdapAndAuthority">使用LDAP登入(加入新的功能)</button></td>
        </tr>
    </table>
</div>
<br />
<div id="userContent"></div>
<br />
<div id="functionList"></div>
		</div>
	</div>
</div>

<script>
$("#btnDefault").click(function () {
    login("default");
});
$("#btnDb").click(function () {
    login("db");
});
$("#btnLdapAndAuthority").click(function () {
    login("ldap");
});
function login(type) {
    var inputdata = { userId : $("#userId").val(), password : $("#password").val() };
    $.ajax({
        type: 'GET',
        url: '${pageContext.request.contextPath }/dec/login/'+type,
        datatype: 'application/json',
        data: inputdata,
        async: false,
        success: function (data) {
            var div = $("#userContent");
            var divFunction = $("#functionList");
            div.empty();
            divFunction.empty();
            var html = "";
            if (data.user == null) {
                html = "<p>不是有效的使用者</p>"
                div.append(html);
                div.show();
                divFunction.hide();
                return;
            }
            html = "<p>使用者名稱為：" + data.user.userName + "</p>";
            div.append(html);
            div.show();
            html = "<p>功能列表如下：</p>";
            $.each(data.acl, function (i, item) {
                html += "<p><a href='${pageContext.request.contextPath }" + item.functionUrl + "'>" + item.functionName + "</a></p>";
            });
            divFunction.append(html);
            divFunction.show();
        }
    });
};
</script>