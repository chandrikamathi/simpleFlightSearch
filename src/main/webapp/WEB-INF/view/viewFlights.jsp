<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<table border="2" width="70%" cellpadding="2">
    <tr><th>Flight Number</th><th>Status</th><th>Arrival Time</th><th>Distance</th><th>Travel Time</th>
    <c:forEach var="flight" items="${list}">
        <tr>
            <td>${flight.flightNumber}</td>
            <td>${flight.status}</td>
            <td>${flight.arrival}</td>
            <td>${flight.distance}</td>
            <td>${flight.travelTime}</td>
        </tr>
    </c:forEach>
</table>