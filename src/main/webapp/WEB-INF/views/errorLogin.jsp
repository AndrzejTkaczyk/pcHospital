<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<html>

<head>
    <meta charset="utf-8">
    <title>Błąd!</title>
    <link href='<c:url value="/html/style.css"/>' rel="stylesheet" type="text/css">
</head>

<body>

<%@ include file="header.jsp" %>

<table class="mainTable">
    <tr>
        <td><p style="color:#FF0000";>Błąd! Nie masz uprawnień do tej strony!</td>
    </tr>
    <tr>
        <td><button onclick="history.back()">Powrót</button></td>
    </tr>
</table>

<%@ include file="footer.jsp" %>

</body>
</html>