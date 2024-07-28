<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>

<html>

<head>
    <meta charset="utf-8">
    <title>pcHospital - Rejestracja</title>
    <link href='<c:url value="/html/style.css"/>' rel="stylesheet" type="text/css">
</head>

<body>

<%@ include file="header.jsp" %>

<table class="mainTable">
    <tr>
        <td>
            <h1>Rejestracja</h1>
            <form:form modelAttribute="user" method="post" action="/registration">
                <form:hidden path="id"/>
                <form:hidden path="createdOn"/>

                <c:if test="${user.access != null}">
                    <form:hidden path="access" value="${user.access}"/>
                </c:if>
                <label>
                    Imie:<br><form:input type="text" path="firstName"/>
                    <p class="alert-danger"><form:errors path="firstName"/></p>
                </label>
                <label>
                    Nazwisko: <br><form:input type="text" path="lastName"/>
                    <p class="alert-danger"><form:errors path="lastName"/></p>
                </label>
                <label>
                    E-mail: <br><form:input type="text" path="email"/>
                    <p class="alert-danger"><form:errors path="email"/></p>
                </label>
                <label>
                    Haslo: <br><form:input path="password"/>
                    <p class="alert-danger"><form:errors path="password"/></p>
                </label>
                <label>
                    Telefon: <br><form:input type="number" path="phone"/>
                    <p class="alert-danger"><form:errors path="phone"/></p>
                </label>
                <label>
                    Adres: <br><form:input path="address"/>
                    <p class="alert-danger"><form:errors path="address"/></p>
                </label>
                <br><form:button>Zarejestruj</form:button>
            </form:form>
        </td>
    </tr>
</table>

<%@ include file="footer.jsp" %>

</body>
</html>