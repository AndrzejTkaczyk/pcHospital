<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>

<html>

<head>
    <meta charset="utf-8">
    <title>Lista komputerów</title>
    <link href='<c:url value="/html/style.css"/>' rel="stylesheet" type="text/css">
</head>

<body>

<%@ include file="header.jsp" %>

<table class="mainTable">
    <tr>
        <td>
            <h1>Lista komputerów</h1>
            <c:choose>
                <c:when test="${empty computers}">
                    Lista jest pusta!
                </c:when>
                <c:otherwise>
                    <table class="List">
                        <thead>
                        <tr>
                            <th>Id</th>
                            <th>Marka</th>
                            <th>Model</th>
                            <th>Numer seryjny</th>
                            <th>Typ</th>
                            <th>Akcje</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${computers}" var="c">
                            <tr>
                                <td>${c.id}</td>
                                <td>${c.brand}</td>
                                <td>${c.model}</td>
                                <td>${c.serial_number}</td>
                                <td>${c.type}</td>
                                <td>
                                    <c:choose>
                                        <c:when test="${empty repair}">
                                            <a href="/app/user/computerEdit/${c.id}">Edytuj</a>
                                            <a href="/app/user/computerDelete/${c.id}">Usuń</a>
                                        </c:when>
                                        <c:otherwise>
                                            Brak
                                        </c:otherwise>
                                    </c:choose>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </c:otherwise>
            </c:choose>
            <br><br><a href="<c:url value="/app/user/computerAdd"/>">Dodaj komputer</a>
        </td>
    </tr>
</table>

<%@ include file="footer.jsp" %>

</body>
</html>