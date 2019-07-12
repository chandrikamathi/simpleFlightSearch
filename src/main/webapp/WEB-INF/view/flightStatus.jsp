<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Hello Spring MVC</title>
</head>

<body>
<h2>${message}</h2>

<form:form method="get" action="checkFlightStatus">
    <table >
        <tr>
            <td>Flight Number : </td>
            <td><form:input path="flightNum"  /></td>
        </tr>
        <tr>
            <td>Origin :</td>
            <td><form:input path="origin" /></td>
        </tr>
        <tr>
            <td>Destination :</td>
            <td><form:input path="destination" /></td>
        </tr>
        <tr>
            <td>Departure :</td>
            <td><form:input path="destination" /></td>
        </tr>

        <tr>
            <td colspan="2"><input type="submit" value="Check Flight Status" /></td>
        </tr>
    </table>
</form:form>

<table border="2" width="70%" cellpadding="2">
    <tr><th>Flight Number</th><th>Status</th><th>Arrival Time</th><th>Distance</th><th>Travel Time</th>
        <c:forEach var="flight" items="${flights}">
    <tr>
        <td>${flight.flightNumber}</td>
        <td>${flight.status}</td>
        <td>${flight.arrival}</td>
        <td>${flight.distance}</td>
        <td>${flight.travelTime}</td>
    </tr>
    </c:forEach>
</table>
</body>
</html>
