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
                            <th>Pracownik</th>
                            <th>Akcje i status</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${repairs}" var="repair">
                            <tr>
                                <td>${repair.id}</td>
                                <td>${repair.computer.client.firstNameAndLastName}</td>
                                <td>${repair.dateOfOrderFormat}</td>
                                <td>${repair.descriptionOfTheProblem}</td>
                                <td>${repair.computer.detailComputer}</td>
                                <td>
                                    <c:forEach items="${repair.repairDetails}" var="repairDetails">
                                        ${repairDetails.employee.firstNameAndLastName}
                                    </c:forEach>
                                </td>
                                <td>
                                    <c:if test="${repair.status == 1}">
                                        Oczekuje na naprawę
                                        <a href="/app/employee/repairAddEmployee/${repair.id}">Podejmij naprawę</a>
                                        <a href="/app/employee/repairDetailsEmployee/${repair.id}">Szczegóły</a>
                                    </c:if>
                                    <c:if test="${repair.status == 2}">
                                        W trakcie naprawy
                                        <a href="/app/employee/repairEditEmployeeRepair/${repair.id}">Edytuj naprawę</a>
                                        <a href="/app/employee/repairDetailsEmployee/${repair.id}">Szczegóły</a>
                                    </c:if>
                                    <c:if test="${repair.status == 3}">
                                        Zakończono naprawę <a href="/app/employee/repairDetailsEmployee/${repair.id}">Szczegóły</a>
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