<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<h2>Ticket Information</h2>

<c:choose>
    <c:when test="${fn:length(allTickets)==0}">
        There is no info to display because there are ${fn:length(allTickets)} tickets.
        <br />
    </c:when>
    <c:otherwise>
         There is info to display.
         <table>
               <c:forEach items="${allTickets}" var="allTickets">
                     <tr>
                         <td>Id</td>
                         <td>${allTickets.id}</td>
                     </tr>
                     <tr>
                         <td>Event</td>
                         <td>${allTickets.event}</td>
                     </tr>
                     <tr>
                         <td>Date Time</td>
                         <td>${allTickets.dateTime}</td>
                     </tr>
                     <tr>
                         <td>Seats</td>
                         <td>${allTickets.seats}</td>
                     </tr>
                     <tr>
                         <td>User</td>
                         <td>${allTickets.user}</td>
                     </tr>
                     <tr>
                         <td>Price</td>
                         <td>${allTickets.price}</td>
                     </tr>
               </c:forEach>
         </table>

         <br />
    </c:otherwise>
    </c:choose>

</body>
</html>