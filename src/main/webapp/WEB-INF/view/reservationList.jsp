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
            <td><form:input path="name" /></td>
        </tr>
        <tr>
            <td><form:label path="surname"><spring:message code="label.surname"/></form:label></td>
            <td><form:input path="surname" /></td>
        </tr>
        <tr>
            <td><form:label path="roomNumber"><spring:message code="label.roomNumber"/></form:label></td>
            <td><form:input path="roomNumber" /></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="<spring:message code="label.add"/>"/>
            </td>
        </tr>
    </table>
    </form:form>
    <h3>Employees</h3>
    <c:if  test="${!empty reservationList}">
    <table class="data">
    <tr>
        <th>Name and surname</th>
        <th>Room Number</th>
        <th>Action</th>
    </tr>
    <c:forEach items="${reservationList}" var="reservation">
        <tr>
            <td>${reservation.name}, ${reservation.surname} </td>
            <td>${reservation.roomNumber}</td>
            <td>delete</td>
        </tr>
    </c:forEach>
    </table>
    </c:if>
    </body>
</html>