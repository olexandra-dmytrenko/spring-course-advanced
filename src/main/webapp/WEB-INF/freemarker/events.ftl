<html>
<head>
    <title>Welcome!</title>
</head>
<body>
    <p>Events that are on:
    <table border=1>
            <tr>
                <th>Event Name</th>
                <th>Hall</th>
                <th>Date and Time</th>
                <th>Rate</th>
                <th>Number of Seats in the Hall</th>
                <th>Base Price</th>
                <th>Book</th>
            </tr>
        <#list events as event>
            <tr>
                <td>${event.name}
                <td>${event.auditorium.name}
                <td>${event.dateTime}
                <td>${event.rate}
                <td>${event.auditorium.seatsNumber}
                <td>${event.basePrice} Euros
                <td><a href="${bookTicketUrl!"/bookTicket"!}"+ ?event=${event.name}>${bookTicketName!"Book ticket"!}</a></td>
            </tr>
          </#list>
    </table>
</body>
</html>