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
                    <c:forEach items="${computers}" var="computer">
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
                        <tr>
                            <td>${computer.id}</td>
                            <td>${computer.brand}</td>
                            <td>${computer.model}</td>
                            <td>${computer.serial_number}</td>
                            <td>${computer.type}</td>
                            <td>
                                <c:if test="${computer.status == 1}">
                                    <a href="/app/user/computerEdit/${computer.id}">Edytuj</a>
                                    <a href="/app/user/computerDelete/${computer.id}">Usuń</a>
                                </c:if>
                                <c:if test="${computer.status == 2}">
                                    W trakcie naprawy
                                </c:if>
                                <c:if test="${computer.status == 3}">
                                    <a href="/app/user/computerDelete/${computer.id}">Usuń</a>
                                </c:if>
                            </td>
                        </tr>

                        <c:choose>
                            <c:when test="${empty computer.repairs}">
                                <tr>
                                    <th colspan="6">Lista napraw jest pusta.
                                    </th>
                                </tr>
                                <tr>
                                    <th colspan="6"><a href="<c:url value="/app/user/repairAdd/${computer.id}"/>">Dodaj
                                        naprawę</a>
                                    </th>
                                </tr>
                            </c:when>
                            <c:otherwise>
                                <thead>
                                <tr>
                                    <th colspan="6">Lista napraw:
                                    </th>
                                </tr>
                                <tr>
                                    <th>Id</th>
                                    <th>Data zgłoszenia</th>
                                    <th>Data naprawy</th>
                                    <th>Problem</th>
                                    <th colspan="2">Akcje</th>
                                </tr>
                                </thead>

                                <c:forEach items="${computer.repairs}" var="computerRepairs">
                                    <tr>
                                        <td>${computerRepairs.id}</td>
                                        <td>${computerRepairs.dateOfOrderFormat}</td>
                                        <td>${computerRepairs.dateOfEndFormat}</td>
                                        <td>${computerRepairs.descriptionOfTheProblem}</td>
                                        <td colspan="2">
                                            <c:if test="${computerRepairs.status == 1}">
                                                <a href="/app/user/repairEdit/${computerRepairs.id}">Edytuj</a>
                                                <a href="/app/user/repairDelete/${computerRepairs.id}">Usuń</a>
                                                Oczekuje na przyjęcie naprawy.
                                            </c:if>
                                            <c:if test="${computerRepairs.status == 2}">
                                                W trakcie naprawy.
                                            </c:if>
                                            <c:if test="${computerRepairs.status == 3}">
                                                Naprawiono. <a href="/app/user/repairDetailsUser/${computerRepairs.id}">Szczegóły</a>
                                            </c:if>
                                        </td>
                                    </tr>
                                </c:forEach>
                                <tr>
                                    <c:if test="${computer.status == 1 || computer.status == 3}">
                                        <th colspan="6"><a href="<c:url value="/app/user/repairAdd/${computer.id}"/>">Dodaj
                                            kolejną naprawę</a>
                                        </th>
                                    </c:if>
                                </tr>
                            </c:otherwise>
                        </c:choose>

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