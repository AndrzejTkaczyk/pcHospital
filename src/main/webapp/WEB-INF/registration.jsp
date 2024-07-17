<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <title>pcHospital - Rejestracja</title>
    <link href='<c:url value="/html/style.css"/>' rel="stylesheet" type="text/css">
</head>

<body>

<%@ include file="header.jsp" %>

<h1>Rejestracja</h1>
<form:form modelAttribute="user" method="post" action="/user/registration">
    <form:hidden path="id"/>
    <form:hidden path="access" value="1"/>
    <label>
        Imie: <form:input path="firstName"/>
    </label>
    <label>
        Nazwisko: <form:input path="lastName"/>
    </label>
    <label>
        E-mail: <form:input path="email"/>
    </label>
    <label>
        Haslo: <form:input path="password"/>
    </label>
    <label>
        Telefon: <form:input path="phone"/>
    </label>
    <label>
        Adres: <form:input path="address"/>
    </label>

    <input type="submit"/>
</form:form>

<%@ include file="/WEB-INF/footer.jsp" %>

</body>
</html>