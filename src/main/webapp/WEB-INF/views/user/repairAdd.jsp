<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>

<html>

<head>
    <meta charset="utf-8">
    <c:choose>
        <c:when test="${repair.id == null}">
            <title>Dodaj naprawę</title>
        </c:when>
        <c:otherwise>
            <title>Edytuj naprawę</title>
        </c:otherwise>
    </c:choose>
    <link href='<c:url value="/html/style.css"/>' rel="stylesheet" type="text/css">
</head>

<body>

<%@ include file="header.jsp" %>

<table class="mainTable">
    <tr>
        <td>
            <c:choose>
                <c:when test="${repair.id == null}">
                    <h1>Dodaj naprawę</h1>
                </c:when>
                <c:otherwise>
                    <h1>Edytuj naprawę</h1>
                </c:otherwise>
            </c:choose>
            <form:form modelAttribute="repair" method="post" action="/app/user/repairAdd">
                <form:hidden path="id"/>
                <form:hidden path="computer.id"/>
                <label>
                    Opis problemu:<br><form:input type="text" path="descriptionOfTheProblem"/>
                    <p class="alert-danger"><form:errors path="descriptionOfTheProblem"/></p>
                </label>
                <br>
                <button type="submit">Zapisz</button>
            </form:form>

        </td>
    </tr>
</table>

<%@ include file="footer.jsp" %>

</body>
</html>