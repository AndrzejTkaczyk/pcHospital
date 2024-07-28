<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>

<html>

<head>
    <meta charset="utf-8">
    <title>Szczegóły komputera do naprawy</title>
    <link href='<c:url value="/html/style.css"/>' rel="stylesheet" type="text/css">
</head>

<body>

<%@ include file="header.jsp" %>

<table class="mainTable">
    <tr>
        <td>
            <h1>Szczegóły komputera do naprawy</h1>
            <c:choose>
                <c:when test="${empty repairsDetails}">
                    Lista jest pusta!
                </c:when>
                <c:otherwise>
                    <table class="List">
                        <thead>
                        <tr>
                            <th>Id</th>
                            <th>Szczegóły naprawy</th>
                            <th>Cena</th>
                            <th>Status</th>
                            <th>Kto naprawia</th>
                            <th>Id naprawy</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${repairsDetails}" var="rd">
                            <tr>
                                <td>${rd.id}</td>
                                <td>${rd.descriptionOfRepair}</td>
                                <td>${rd.price}</td>
                                <td>
                                <c:if test="${rd.status == 0}">
                                    Oczekuje na naprawę
                                </c:if>
                                <c:if test="${rd.status == 1}">
                                    W trakcie naprawy
                                </c:if>
                                <c:if test="${rd.status == 2}">
                                    Naprawiony
                                </c:if></td>
                                <td>${rd.employee.firstNameAndLastName}</td>
                                <td>${rd.id}</td>
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