<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<table class="mainTable">
    <tr>
        <td>
            Logo
        </td>
    </tr>
    <tr>
        <td>
            <a href="<c:url value="/"/>">Strona glowna</a>
            <a href="<c:url value="registration"/>">Rejestracja</a>
            <a href="<c:url value="login"/>">Logowanie</a>
        </td>
    </tr>
</table>