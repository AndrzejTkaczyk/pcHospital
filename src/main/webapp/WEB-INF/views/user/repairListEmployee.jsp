<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>

<html>

<head>
    <meta charset="utf-8">
    <title>Lista komputerów do naprawy</title>
    <link href='<c:url value="/html/style.css"/>' rel="stylesheet" type="text/css">
</head>

<body>

<%@ include file="header.jsp" %>

<table class="mainTable">
    <tr>
        <td>
            <h1>Lista komputerów do naprawy</h1>
            <c:choose>
                <c:when test="${empty repairs}">
                    Lista jest pusta!
                </c:when>
                <c:otherwise>
                    <table class="List">
                        <thead>
                        <tr>
                            <th>Id</th>
                            <th>Klient</th>
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
                                <td>${r.client.firstNameAndLastName}</td>
                                <td>${r.dateOfOrder}</td>
                                <td>${r.descriptionOfTheProblem}</td>
                                <td>${r.computer.detailComputer}</td>
                                <td>
                                    <c:if test="${r.status == 0}">
                                        Oczekuje na naprawę
                                        <a href="/app/employee/repairAddEmployee/${r.id}">Podejmij naprawę</a>
                                        <a href="/app/employee/repairDetailsEmployee/${r.id}">Szczegóły</a>
                                    </c:if>
                                    <c:if test="${r.status == 1}">
                                        W trakcie naprawy
                                        <a href="/app/employee/repairEditEmployeeRepair/${r.id}">Edytuj naprawę</a>
                                        <a href="/app/employee/repairDetailsEmployee/${r.id}">Szczegóły</a>
                                        <a href="/app/employee/repairEnd/${r.id}">Zakoncz</a>
                                    </c:if>
                                    <c:if test="${r.status == 2}">
                                        Zakończono naprawę <a href="/app/employee/repairDetailsEmployee/${r.id}">Szczegóły</a>
                                    </c:if>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </c:otherwise>
            </c:choose>
        </td>
    </tr>
</table>

<%@ include file="footer.jsp" %>

</body>
</html>