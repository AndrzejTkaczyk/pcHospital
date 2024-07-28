<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>

<html>

<head>
    <meta charset="utf-8">
    <c:choose>
        <c:when test="${computer.id == null}">
            <title>Dodaj komputer</title>
        </c:when>
        <c:otherwise>
            <title>Edytuj komputer</title>
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
                <c:when test="${computer.id == null}">
                    <h1>Dodaj komputer</h1>
                </c:when>
                <c:otherwise>
                    <h1>Edytuj komputer</h1>
                </c:otherwise>
            </c:choose>
            <form:form modelAttribute="computer" method="post" action="/app/user/computerAdd">
            <form:hidden path="id"/>
            <c:if test="${computer.client != null}">
            <form:hidden path="client.id"/>
            </c:if>
                <label>
                    Marka:<br><form:input type="text" path="brand"/>
                    <p class="alert-danger"><form:errors path="brand"/></p>
                </label>
                <label>
                    Model: <br><form:input type="text" path="model"/>
                    <p class="alert-danger"><form:errors path="model"/></p>
                </label>
                <label>
                    Numer seryjny: <br><form:input type="text" path="serial_number"/>
                    <p class="alert-danger"><form:errors path="serial_number"/></p>
                </label>
                <label>
                    Typ: <br><form:input path="type"/>
                    <p class="alert-danger"><form:errors path="type"/></p>
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