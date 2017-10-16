<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!-- Begin Body -->
<div class="container">
	<div class="row">
		<div class="span12">
			<h2>ID Generator</h2>
			<table>
    <tr>
        <th>請輸入表單類別</th>
        <td><input type="text" id="formType" value="" /></td>
    </tr>
    <tr>
        <th>產生的編號為:</th>
        <td><input type="text" id="formID" value="" readonly="readonly" /></td>
    </tr>
</table>
<br />
<br />
<button id="genId">產生編號</button>
		</div>
		<img src="${pageContext.request.contextPath }/resources/image/500px-Singleton_UML_class_diagram.png">
	</div>
</div>

 <script>
        $("#genId").click(function () {
            $.ajax({
                type: 'GET',
                url: '${pageContext.request.contextPath }/sg/genid/'+$('#formType').val(),
                datatype: 'application/json',
                async: false,
                success: function (data) {
                    $("#formID").val(data.response);
                }
            });
        });
    </script>