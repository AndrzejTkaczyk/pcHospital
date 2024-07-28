<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>

<html>

<head>
    <meta charset="utf-8">
    <title>Lista napraw</title>
    <link href='<c:url value="/html/style.css"/>' rel="stylesheet" type="text/css">
</head>

<body>

<%@ include file="header.jsp" %>

<table class="mainTable">
    <tr>
        <td>
            <h1>Lista napraw</h1>
            <c:choose>
            <c:when test="${empty repairs}">
                Lista jest pusta!
            </c:when>
            <c:otherwise>
            <table class="List">
                <thead>
                <tr>
                    <th>Id</th>
                    <th>Data zgłoszenia</th>
                    <th>Opis problemu</th>
                    <th>Dotyczy komputera</th>
                    <th>Akcje i status</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${repairs}" var="r">
                    <tr>
                        <td>${r.id}</td>
                        <td>${r.dateOfOrder}</td>
                        <td>${r.descriptionOfTheProblem}</td>
                        <td>${r.computer.detailComputer}</td>
                        <td>
                            <c:if test="${r.status == 0}">
                                <a href="/app/user/repairEdit/${r.id}">Edytuj</a>
                                <a href="/app/user/repairDelete/${r.id}">Usuń</a>
                                Oczekuje na przyjęcie.
                            </c:if>
                            <c:if test="${r.status == 1}">
                                Przyjęty do naprawy.
                            </c:if>
                            <c:if test="${r.status == 2}">
                                Naprawiony. <a href="/app/user/repairDetailsUser/${r.id}">Szczegóły</a>
                            </c:if>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            </c:otherwise>
            </c:choose>
            <c:choose>
            <c:when test="${empty computers}">
                Najpierw dodaj swój pierwszy komputer do listy!
            </c:when>
            <c:otherwise>
            <br><br><a href="<c:url value="/app/user/repairAdd"/>">Dodaj naprawę</a>
            </c:otherwise>
            </c:choose>
        </td>
    </tr>
</table>

<%@ include file="footer.jsp" %>

</body>
</html>