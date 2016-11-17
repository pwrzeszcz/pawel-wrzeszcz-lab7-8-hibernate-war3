<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
    <head>
        <title>HotelApp</title>
    </head>
    <body>
    <h2>HotelApp</h2>
    <form:form method="post" action="add" commandName="reservation">
        <table>
        <tr>
            <td><form:label path="name"><spring:message code="label.name"/></form:label></td>
            <td><form:input path="name" required="required" /></td>
        </tr>
        <tr>
            <td><form:label path="surname"><spring:message code="label.surname"/></form:label></td>
            <td><form:input path="surname" required="required" /></td>
        </tr>
        <tr>
            <td><form:label path="room"><spring:message code="label.room"/></form:label></td>
            <td>
                <form:select path="room" items="${roomList}" itemLabel="number" itemValue="id" />
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="<spring:message code="label.add"/>"/>
            </td>
        </tr>
    </table>
    </form:form>
    <c:choose>
        <c:when test="${!empty reservationList}">
            <h3>Reservations</h3>
            <table class="data">
            <tr>
                <th>Name</th>
                <th>Surname</th>
                <th>&nbsp;</th>
            </tr>
            <c:forEach items="${reservationList}" var="reservation">
                <tr>
                    <td>${reservation.name}</td>
                    <td>${reservation.surname}</td>
                    <td><a href="delete/${reservation.id}">delete</a></td>
                </tr>
            </c:forEach>
            </table>
        </c:when>
        <c:otherwise>
            <h3>There are no reservations</h3>
        </c:otherwise>
    </c:choose>
    </body>
</html>