<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>

<html>

<head>
    <meta charset="utf-8">
    <c:choose>
        <c:when test="${repairDetails.id == null}">
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
                <c:when test="${repairDetails.id == null}">
                    <h1>Dodaj naprawę</h1>
                </c:when>
                <c:otherwise>
                    <h1>Edytuj naprawę</h1>
                </c:otherwise>
            </c:choose>
            <form:form modelAttribute="repairDetails" method="post" action="/app/employee/repairAddEmployee">
            <form:hidden path="id"/>
            <form:hidden path="repair.id" value="${repair.id}"/>
            <c:if test="${repairDetails.employee != null}">
                <form:hidden path="employee.id"/>
            </c:if>
            <label>
                Status:<br><form:select path="status">
                <form:option value="1" label="Rozpocznij naprawę"/>
                <form:option value="2" label="Zakończ naprawę"/>
            </form:select>
                <p class="alert-danger"><form:errors path="status"/></p>
            </label>
            <label>
                <label>
                    Opis naprawy:<br><form:input type="text" path="descriptionOfRepair"/>
                    <p class="alert-danger"><form:errors path="descriptionOfRepair"/></p>
                </label>

                <label>
                    Cena:<br><form:input type="number" path="price"/>
                    <p class="alert-danger"><form:errors path="price"/></p>
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