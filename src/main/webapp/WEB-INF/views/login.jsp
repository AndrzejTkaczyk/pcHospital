<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>

<html>

<head>
    <meta charset="utf-8">
    <title>pcHospital - Logowanie</title>
    <link href='<c:url value="/html/style.css"/>' rel="stylesheet" type="text/css">
</head>

<body>

<%@ include file="header.jsp" %>

<table class="mainTable">
    <tr>
        <td>
            <h1>Logowanie</h1>
            <form method="post" action="/login">
                <label>
                    E-mail: <br><input type="text" name="email"/><br>
                </label>
                <label>
                    Haslo: <br><input type="password" name="password"/>
                    <p class="alert-danger">${error}</p>
                </label>
                <button type="submit">Zaloguj</button>
            </form>
        </td>
    </tr>
</table>

<%@ include file="footer.jsp" %>

</body>
</html>