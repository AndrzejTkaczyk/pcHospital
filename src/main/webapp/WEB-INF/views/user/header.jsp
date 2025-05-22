<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<table class="mainTable">
    <tr>
        <td>
            Logo
        </td>
    </tr>
</table>

<table class="mainTableSmall">
    <tr>
        <td>
            Witaj, ${sessionScope.user.firstName}!
            <a href="<c:url value="/registrationEdit/${sessionScope.user.id}"/>">Edytuj konto</a>
            <a href="<c:url value="/logout"/>">Wyloguj</a>
        </td>
    </tr>
</table>

<table class="mainTable">
    <tr>
        <td>
            <c:if test="${sessionScope.user.access == 0}">
                <a href="<c:url value="/app/user/computerList"/>">Twoje komputery i naprawy</a>
            </c:if>
            <c:if test="${sessionScope.user.access == 1}">
                <a href="<c:url value="/app/employee/repairsEmployee"/>">Twoje naprawy</a>
                <a href="<c:url value="/app/employee/repairListEmployee"/>">Lista zgłoszeń</a>
            </c:if>
        </td>
    </tr>
</table>