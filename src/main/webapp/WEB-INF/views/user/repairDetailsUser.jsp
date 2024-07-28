<%@ page import="java.util.Arrays" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>

<html>

<head>
    <meta charset="utf-8">
    <title>Podsumowanie napraw</title>
    <link href='<c:url value="/html/style.css"/>' rel="stylesheet" type="text/css">
</head>

<body>

<%@ include file="header.jsp" %>

<table class="mainTable">
    <tr>
        <td>
            <h1>Podsumowanie napraw</h1>
            <c:choose>
                <c:when test="${empty repairsDetails}">
                    Lista jest pusta!
                </c:when>
                <c:otherwise>
                    <table class="List">
                        <thead>
                        <tr>
                            <th>Szczegóły naprawy</th>
                            <th>Kto naprawił</th>
                            <th>Cena</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:set var="sum" value="0"/>
                        <c:forEach items="${repairsDetails}" var="rd">
                            <tr>
                                <td>${rd.descriptionOfRepair}</td>
                                <td>${rd.employee.firstNameAndLastName}</td>
                                <td>${rd.price}</td>
                                <c:set var="sum" value="${sum + rd.price}"/>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                    <table class="List">
                        <thead>
                        <tr>
                            <th>Łączna kwota do zapłaty: <c:out value="${sum}"/></th>
                        </tr>
                        </thead>
                    </table>
                </c:otherwise>
            </c:choose>
        </td>
    </tr>
</table>

<%@ include file="footer.jsp" %>

</body>
</html>